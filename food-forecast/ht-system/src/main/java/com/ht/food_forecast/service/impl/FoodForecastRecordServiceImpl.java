package com.ht.food_forecast.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ht.common.utils.DateUtils;
import com.ht.common.utils.SecurityUtils;
import com.ht.food_forecast.domain.FinalForecastEntity;
import com.ht.food_forecast.domain.FoodForecastRecordEntity;
import com.ht.food_forecast.domain.ResponseForecastEntity;
import com.ht.food_forecast.mapper.FoodForecastRecordMapper;
import com.ht.food_forecast.service.FoodForecastRecordService;
import com.ht.system.domain.SysUserInfo;
import com.ht.system.mapper.SysUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodForecastRecordServiceImpl implements FoodForecastRecordService {

    @Autowired
    private FoodForecastRecordMapper recordMapper;

    @Autowired
    private SysUserInfoMapper userInfoMapper;

    @Override
    public int insert(FoodForecastRecordEntity entity) {
        return recordMapper.insert(entity);
    }

    @Override
    public int update(FoodForecastRecordEntity entity) {
        return recordMapper.updateById(entity);
    }

    @Override
    public FoodForecastRecordEntity detail(Long id) {
        return recordMapper.selectById(id);
    }

    @Override
    public List<FoodForecastRecordEntity> list(FoodForecastRecordEntity entity) {
        LambdaQueryWrapper<FoodForecastRecordEntity> wrapper = new LambdaQueryWrapper<>();
        return recordMapper.selectList(wrapper);
    }

    @Override
    public Map<String, Object> getMyForecast() {
        Long userId = SecurityUtils.getUserId();
        
        LambdaQueryWrapper<SysUserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserInfo::getUserId, userId);
        SysUserInfo userInfo = userInfoMapper.selectOne(wrapper);

        // forecast 
        LambdaQueryWrapper<FoodForecastRecordEntity> forecastWrapper = new LambdaQueryWrapper<>();
        forecastWrapper.eq(FoodForecastRecordEntity::getUserId, userId);
        FoodForecastRecordEntity forecastRecord = recordMapper.selectOne(forecastWrapper);
        Map<String, Object> map = new HashMap<>();
        String createTime = DateUtils.parseDateToStr("yyyy-MM-dd", forecastRecord.getCreateTime());
        // find matching buddies
        // Vegetables
        if (forecastRecord.getVegetables() == 0 || forecastRecord.getVegetables() == 1) {
            map.put("vegetables", new ArrayList<>());
        } else {
            double smallVe = BigDecimal.valueOf(forecastRecord.getVegetablesRemainder()).subtract(BigDecimal.valueOf(0.8)).abs().doubleValue();
            if (forecastRecord.getVegetablesRemainder() >= 0.8) {
                smallVe = 0.1;
            }
            double bigVe = BigDecimal.ONE.subtract(BigDecimal.valueOf(forecastRecord.getVegetablesRemainder())).doubleValue();

            List<FinalForecastEntity> togetherVeUsers = recordMapper.getVeTogetherUsers(forecastRecord.getLaunchPeriod(),
                    userInfo.getUserSchool(), createTime, smallVe, bigVe, userId);
            map.put("vegetables", togetherVeUsers);
        }

        if (forecastRecord.getFruits() == 0 || forecastRecord.getFruits() == 1) {
            map.put("fruits", new ArrayList<>());
        } else {
            // Fruits
            double smallFr = BigDecimal.valueOf(forecastRecord.getFruitsRemainder()).subtract(BigDecimal.valueOf(0.8)).abs().doubleValue();
            if (forecastRecord.getFruitsRemainder() >= 0.8) {
                smallFr = 0.1;
            }
            double bigFr = BigDecimal.ONE.subtract(BigDecimal.valueOf(forecastRecord.getFruitsRemainder())).doubleValue();
            List<FinalForecastEntity> togetherFrUsers = recordMapper.getFrTogetherUsers(forecastRecord.getLaunchPeriod(),
                    userInfo.getUserSchool(), createTime, smallFr, bigFr, userId);
            map.put("fruits", togetherFrUsers);
        }

        if (forecastRecord.getMilk() == 0 || forecastRecord.getMilk() == 1) {
            map.put("milk", new ArrayList<>());
        } else {
            // milk_remainder
            double smallMilk = BigDecimal.valueOf(forecastRecord.getMilkRemainder()).subtract(BigDecimal.valueOf(0.8)).abs().doubleValue();
            if (forecastRecord.getMilkRemainder() >= 0.8) {
                smallMilk = 0.1;
            }
            double bigMilk = BigDecimal.ONE.subtract(BigDecimal.valueOf(forecastRecord.getMilkRemainder())).doubleValue();
            List<FinalForecastEntity> togetherMilkUsers = recordMapper.getMilkTogetherUsers(forecastRecord.getLaunchPeriod(),
                    userInfo.getUserSchool(), createTime, smallMilk, bigMilk, userId);
            map.put("milk", togetherMilkUsers);
        }

        if (forecastRecord.getEntrees() == 0 || forecastRecord.getEntrees() == 1) {
            map.put("entrees", new ArrayList<>());
        } else {
            // entrees_remainder
            double smallEnt = BigDecimal.valueOf(forecastRecord.getEntreesRemainder()).subtract(BigDecimal.valueOf(0.8)).abs().doubleValue();
            if (forecastRecord.getEntreesRemainder() >= 0.8) {
                smallEnt = 0.1;
            }
            double bigEnt = BigDecimal.ONE.subtract(BigDecimal.valueOf(forecastRecord.getEntreesRemainder())).doubleValue();
            List<FinalForecastEntity> togetherEntUsers = recordMapper.getEntTogetherUsers(forecastRecord.getLaunchPeriod(),
                    userInfo.getUserSchool(), createTime, smallEnt, bigEnt, userId);
            map.put("entrees", togetherEntUsers);
        }

        if (forecastRecord.getGrains() == 0 || forecastRecord.getGrains() == 1) {
            map.put("grains", new ArrayList<>());
        } else {
            // grains_remainder
            double smallGra = BigDecimal.valueOf(forecastRecord.getGrainsRemainder()).subtract(BigDecimal.valueOf(0.8)).abs().doubleValue();
            if (forecastRecord.getGrainsRemainder() >= 0.8) {
                smallGra = 0.1;
            }
            double bigGra = BigDecimal.ONE.subtract(BigDecimal.valueOf(forecastRecord.getGrainsRemainder())).doubleValue();
            List<FinalForecastEntity> togetherGraUsers = recordMapper.getGraTogetherUsers(forecastRecord.getLaunchPeriod(),
                    userInfo.getUserSchool(), createTime, smallGra, bigGra, userId);
            map.put("grains", togetherGraUsers);
        }

        if (forecastRecord.getProteins() == 0 || forecastRecord.getProteins() == 1) {
            map.put("proteins", new ArrayList<>());
        } else {
            // proteins_remainder
            double smallPro = BigDecimal.valueOf(forecastRecord.getProteinsRemainder()).subtract(BigDecimal.valueOf(0.8)).abs().doubleValue();
            if (forecastRecord.getProteinsRemainder() >= 0.8) {
                smallPro = 0.1;
            }
            double bigPro = BigDecimal.ONE.subtract(BigDecimal.valueOf(forecastRecord.getProteinsRemainder())).doubleValue();
            List<FinalForecastEntity> togetherProUsers = recordMapper.getProTogetherUsers(forecastRecord.getLaunchPeriod(),
                    userInfo.getUserSchool(), createTime, smallPro, bigPro, userId);
            map.put("proteins", togetherProUsers);
        }
        map.put("forecast", forecastRecord);
        return map;
    }

    @Override
    public int delByUserId(Long userId) {
        LambdaQueryWrapper<FoodForecastRecordEntity> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(FoodForecastRecordEntity::getUserId, userId);
        return recordMapper.delete(wrapper);
    }
}
