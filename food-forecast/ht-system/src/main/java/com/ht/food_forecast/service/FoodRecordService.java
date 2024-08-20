package com.ht.food_forecast.service;

import com.ht.food_forecast.domain.FoodRecordEntity;

import java.util.List;

public interface FoodRecordService {

    public int insert(FoodRecordEntity recordEntity);

    public int update(FoodRecordEntity recordEntity);

    public List<FoodRecordEntity> list(FoodRecordEntity foodRecordEntity);

    public FoodRecordEntity detail(Long id);

    int delByUserId(Long userId);
}
