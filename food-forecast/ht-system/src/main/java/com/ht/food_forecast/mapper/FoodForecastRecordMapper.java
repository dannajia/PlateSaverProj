package com.ht.food_forecast.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ht.food_forecast.domain.FinalForecastEntity;
import com.ht.food_forecast.domain.FoodForecastRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface FoodForecastRecordMapper extends BaseMapper<FoodForecastRecordEntity> {

    @Select("SELECT u.first_name, u.last_name, u.phone, u.user_school, f.vegetables, f.create_time FROM " +
            "sys_user_info u LEFT JOIN food_forecast_record f ON" +
            " u.user_id = f.user_id WHERE u.user_school = #{school} " +
            "AND f.launch_period = #{launchPeriod} AND u.user_id <> #{userId} AND f.create_time = #{weekday} " +
            "AND vegetables_remainder BETWEEN #{small} AND #{big} limit 5;")
    List<FinalForecastEntity> getVeTogetherUsers(@Param("launchPeriod") Integer launchPeriod,
                                                 @Param("school") String school, @Param("weekday") String weekday,
                                                 @Param("small") double small, @Param("big") double big, @Param("userId") Long userId);

    @Select("SELECT u.first_name, u.last_name, u.phone, u.user_school, f.fruits, f.create_time FROM " +
            "sys_user_info u LEFT JOIN food_forecast_record f ON" +
            " u.user_id = f.user_id WHERE u.user_school = #{school} " +
            "AND f.launch_period = #{launchPeriod} AND u.user_id <> #{userId} AND f.create_time = #{weekday} " +
            "AND fruits_remainder BETWEEN #{small} AND #{big} limit 5;")
    List<FinalForecastEntity> getFrTogetherUsers(@Param("launchPeriod") Integer launchPeriod,
                                                 @Param("school") String school, @Param("weekday") String weekday,
                                                 @Param("small") double small, @Param("big") double big, @Param("userId") Long userId);
    @Select("SELECT u.first_name, u.last_name, u.phone, u.user_school, f.milk, f.create_time FROM " +
            "sys_user_info u LEFT JOIN food_forecast_record f ON" +
            " u.user_id = f.user_id WHERE u.user_school = #{school} " +
            "AND f.launch_period = #{launchPeriod} AND u.user_id <> #{userId} AND f.create_time = #{weekday} " +
            "AND milk_remainder BETWEEN #{small} AND #{big} limit 5;")
    List<FinalForecastEntity> getMilkTogetherUsers(@Param("launchPeriod") Integer launchPeriod,
                                                   @Param("school") String school, @Param("weekday") String weekday,
                                                   @Param("small") double small, @Param("big") double big, @Param("userId") Long userId);
    @Select("SELECT u.first_name, u.last_name, u.phone, u.user_school, f.entrees, f.create_time FROM " +
            "sys_user_info u LEFT JOIN food_forecast_record f ON" +
            " u.user_id = f.user_id WHERE u.user_school = #{school} " +
            "AND f.launch_period = #{launchPeriod} AND u.user_id <> #{userId} AND f.create_time = #{weekday} " +
            "AND entrees_remainder BETWEEN #{small} AND #{big} limit 5;")
    List<FinalForecastEntity> getEntTogetherUsers(@Param("launchPeriod") Integer launchPeriod,
                                                  @Param("school") String school, @Param("weekday") String weekday,
                                                  @Param("small") double small, @Param("big") double big, @Param("userId") Long userId);
    @Select("SELECT u.first_name, u.last_name, u.phone, u.user_school, f.grains, f.create_time FROM " +
            "sys_user_info u LEFT JOIN food_forecast_record f ON" +
            " u.user_id = f.user_id WHERE u.user_school = #{school} " +
            "AND f.launch_period = #{launchPeriod} AND u.user_id <> #{userId} AND f.create_time = #{weekday} " +
            "AND grains_remainder BETWEEN #{small} AND #{big} limit 5;")
    List<FinalForecastEntity> getGraTogetherUsers(@Param("launchPeriod") Integer launchPeriod,
                                                  @Param("school") String school, @Param("weekday") String weekday,
                                                  @Param("small") double small, @Param("big") double big, @Param("userId") Long userId);
    @Select("SELECT u.first_name, u.last_name, u.phone, u.user_school, f.proteins, f.create_time FROM " +
            "sys_user_info u LEFT JOIN food_forecast_record f ON" +
            " u.user_id = f.user_id WHERE u.user_school = #{school} " +
            "AND f.launch_period = #{launchPeriod} AND u.user_id <> #{userId} AND f.create_time = #{weekday} " +
            "AND proteins_remainder BETWEEN #{small} AND #{big} limit 5;")
    List<FinalForecastEntity> getProTogetherUsers(@Param("launchPeriod") Integer launchPeriod,
                                                  @Param("school") String school, @Param("weekday") String weekday,
                                                  @Param("small") double small, @Param("big") double big, @Param("userId") Long userId);
}
