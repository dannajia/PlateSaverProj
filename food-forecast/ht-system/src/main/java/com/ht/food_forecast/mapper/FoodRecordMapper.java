package com.ht.food_forecast.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.food_forecast.domain.FoodRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodRecordMapper extends BaseMapper<FoodRecordEntity> {
    @Select("SELECT * FROM food_record WHERE date(create_time) = curdate()")
    List<FoodRecordEntity> selectTodayData();

    @Select("SELECT * FROM food_record WHERE date(create_time) = curdate() and user_id = #{userId} limit 1")
    FoodRecordEntity selectTodayDataOne(Long userId);
}
