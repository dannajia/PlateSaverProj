package com.ht.food_forecast.service;

import com.ht.food_forecast.domain.FoodForecastRecordEntity;

import java.util.List;

public interface FoodForecastRecordService {

    public int insert(FoodForecastRecordEntity entity);

    public int update(FoodForecastRecordEntity entity);

    public FoodForecastRecordEntity detail(Long id);

    public List<FoodForecastRecordEntity> list(FoodForecastRecordEntity entity);

    public Object getMyForecast();

    int delByUserId(Long userId);
}
