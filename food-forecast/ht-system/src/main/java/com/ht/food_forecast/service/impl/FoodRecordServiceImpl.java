package com.ht.food_forecast.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ht.common.exception.ServiceException;
import com.ht.common.utils.DateUtils;
import com.ht.common.utils.PolynomialRegression;
import com.ht.common.utils.SecurityUtils;
import com.ht.food_forecast.domain.FoodForecastRecordEntity;
import com.ht.food_forecast.domain.FoodRecordEntity;
import com.ht.food_forecast.mapper.FoodForecastRecordMapper;
import com.ht.food_forecast.mapper.FoodRecordMapper;
import com.ht.food_forecast.service.FoodRecordService;
import org.apache.poi.ss.formula.functions.DateFunc;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoodRecordServiceImpl implements FoodRecordService {

    @Autowired
    private FoodRecordMapper foodRecordMapper;
    @Autowired
    private FoodForecastRecordMapper forecastRecordMapper;

    @Override
    public int insert(FoodRecordEntity recordEntity) {
        
        Long userId = SecurityUtils.getUserId();
        FoodRecordEntity foodRecordEntities = foodRecordMapper.selectTodayDataOne(userId);
        Date nowDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        int week = calendar.get(Calendar.DAY_OF_WEEK);

        if (foodRecordEntities == null) {
            
//            recordEntity.setWeekday(week);
            recordEntity.setWeekday(1);
            foodRecordMapper.insert(recordEntity);
        } else {
            recordEntity.setId(foodRecordEntities.getId());
            recordEntity.setUserId(foodRecordEntities.getUserId());
            foodRecordMapper.updateById(recordEntity);
        }
        FoodForecastRecordEntity foodForecastRecordEntity = computeNextDayInfo(week);
        foodForecastRecordEntity.setLaunchPeriod(recordEntity.getLaunchPeriod());
        foodForecastRecordEntity.setCreateTime(DateUtils.addDays(DateUtils.getNowDate(), 1));
        forecastRecordMapper.delete(new LambdaQueryWrapper<FoodForecastRecordEntity>().eq(FoodForecastRecordEntity::getUserId, recordEntity.getUserId()));

        return forecastRecordMapper.insert(foodForecastRecordEntity);
    }

    private FoodForecastRecordEntity computeNextDayInfo(int weekday) {
        
        LambdaQueryWrapper<FoodRecordEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(FoodRecordEntity::getUserId, SecurityUtils.getUserId())
                .orderByDesc(FoodRecordEntity::getCreateTime);
        wrapper.last("LIMIT 30");
        List<FoodRecordEntity> foodRecordEntities = foodRecordMapper.selectList(wrapper);
        if (CollectionUtils.isEmpty(foodRecordEntities)) {
            throw new ServiceException("Insufficient reference data");
        } else if (foodRecordEntities.size() == 1) {
            
            FoodForecastRecordEntity entity = new FoodForecastRecordEntity();
            BeanUtils.copyProperties(foodRecordEntities.get(0), entity);
            entity.setId(null);
            entity.setWeekday(weekday);
            entity.setCreateTime(DateUtils.addDays(entity.getCreateTime(), 1));
            entity.setEntreesRemainder(getRemainder(entity.getEntrees()));
            entity.setFruitsRemainder(getRemainder(entity.getFruits()));
            entity.setProteinsRemainder(getRemainder(entity.getProteins()));
            entity.setMilkRemainder(getRemainder(entity.getMilk()));
            entity.setGrainsRemainder(getRemainder(entity.getGrains()));
            entity.setVegetablesRemainder(getRemainder(entity.getVegetables()));
            return entity;
        } else {
            return doComputed(foodRecordEntities, weekday);
        }
    }

    /**
     * doComputation
     *
     * @param foodRecordEntities
     */
    public FoodForecastRecordEntity doComputed(List<FoodRecordEntity> foodRecordEntities, int weekday) {
        //X axis
        List<Double> xRows = foodRecordEntities.stream().map(recordEntity -> (double) recordEntity.getWeekday()).collect(Collectors.toList());
        List<Double> vegetables = new ArrayList<>(),
                fruits = new ArrayList<>(), proteins = new ArrayList<>(),
                grains = new ArrayList<>(), entrees = new ArrayList<>(),
                milk = new ArrayList<>();
        // Y axis
        foodRecordEntities.forEach(recordEntity -> {
            vegetables.add(recordEntity.getVegetables());
            fruits.add(recordEntity.getFruits());
            proteins.add(recordEntity.getProteins());
            grains.add(recordEntity.getGrains());
            entrees.add(recordEntity.getEntrees());
            milk.add(recordEntity.getMilk());
        });
        // regression alg.
        PolynomialRegression regression = new PolynomialRegression(1); // regression algorithm
        FoodForecastRecordEntity entity = new FoodForecastRecordEntity();
        entity.setWeekday(weekday);
        entity.setCreateTime(DateUtils.addDays(DateUtils.getNowDate(), 1));

        double veg = complete(regression, xRows, vegetables, weekday);
        entity.setVegetables(veg);
        entity.setVegetablesRemainder(getRemainder(veg));

        double fru = complete(regression, xRows, fruits, weekday);
        entity.setFruits(fru);
        entity.setFruitsRemainder(getRemainder(fru));

        double ent = complete(regression, xRows, entrees, weekday);
        entity.setEntrees(ent);
        entity.setEntreesRemainder(getRemainder(ent));

        double gra = complete(regression, xRows, grains, weekday);
        entity.setGrains(gra);
        entity.setGrainsRemainder(getRemainder(gra));

        double mi = complete(regression, xRows, milk, weekday);
        entity.setMilk(mi);
        entity.setMilkRemainder(getRemainder(mi));

        double pro = complete(regression, xRows, proteins, weekday);
        entity.setProteins(pro);
        entity.setProteinsRemainder(pro);

        entity.setUserId(SecurityUtils.getUserId());
        return entity;
    }

    private double getRemainder(double value) {
        BigDecimal[] bigDecimals = BigDecimal.valueOf(value).divideAndRemainder(BigDecimal.ONE);
        return bigDecimals[1].doubleValue();
    }

    private double complete(PolynomialRegression regression, List<Double> xRows, List<Double> yRows, int weekday) {
        List<Double> collect = yRows.stream().filter(Objects::nonNull).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(collect)) {
            return 0;
        }
        regression.fit(xRows, collect);
        return regression.predict((double) weekday);
    }

    @Override
    public int update(FoodRecordEntity recordEntity) {
        return foodRecordMapper.updateById(recordEntity);
    }

    @Override
    public List<FoodRecordEntity> list(FoodRecordEntity foodRecordEntity) {
        LambdaQueryWrapper<FoodRecordEntity> wrapper = new LambdaQueryWrapper<>();
        return foodRecordMapper.selectList(wrapper);
    }

    @Override
    public FoodRecordEntity detail(Long id) {
        return foodRecordMapper.selectById(id);
    }

    @Override
    public int delByUserId(Long userId) {
        LambdaQueryWrapper<FoodRecordEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(FoodRecordEntity::getUserId, userId);
        return foodRecordMapper.delete(wrapper);
    }
}
