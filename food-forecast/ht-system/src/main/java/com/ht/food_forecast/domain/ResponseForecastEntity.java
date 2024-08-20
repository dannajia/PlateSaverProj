package com.ht.food_forecast.domain;

import lombok.Data;

import java.util.List;

@Data
public class ResponseForecastEntity {

    private String percent; 
    private List<FinalForecastEntity> users; 

}
