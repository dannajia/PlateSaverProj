package com.ht.food_forecast.domain;

import lombok.Data;

@Data
public class FinalForecastEntity extends FoodForecastRecordEntity{

    private String firstName;
    private String lastName;
    private String phone;

}
