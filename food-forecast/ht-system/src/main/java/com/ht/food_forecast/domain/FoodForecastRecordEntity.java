package com.ht.food_forecast.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ht.common.core.domain.MpBaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "food_forecast_record")
public class FoodForecastRecordEntity extends MpBaseEntity {
    private Long id;
    private Long userId;
    private Integer weekday;
    private Double vegetables;
    private Double vegetablesRemainder;
    private Double fruits;
    private Double fruitsRemainder;
    private Double proteins;
    private Double proteinsRemainder;
    private Double grains;
    private Double grainsRemainder;
    private Double entrees;
    private Double entreesRemainder;
    private Double milk;
    private Double milkRemainder;
    private Integer launchPeriod;
    private Date createTime;

}
