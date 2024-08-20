package com.ht.food_forecast.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ht.common.core.domain.MpBaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "food_record")
public class FoodRecordEntity extends MpBaseEntity {

    private Long id;
    private Long userId;
    private Integer weekday;
    private Double vegetables;
    private Double fruits;
    private Double proteins;
    private Double grains;
    private Double entrees;
    private Double milk;
    private Integer launchPeriod;
    private Date createTime;

}
