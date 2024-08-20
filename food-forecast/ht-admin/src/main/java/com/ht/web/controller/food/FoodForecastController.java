package com.ht.web.controller.food;

import com.ht.common.core.controller.BaseController;
import com.ht.common.core.domain.R;
import com.ht.common.utils.SecurityUtils;
import com.ht.food_forecast.domain.FoodRecordEntity;
import com.ht.food_forecast.service.FoodForecastRecordService;
import com.ht.food_forecast.service.FoodRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodForecast")
public class FoodForecastController extends BaseController {

    @Autowired
    private FoodRecordService recordService;

    @Autowired
    private FoodForecastRecordService forecastRecordService;

    @PostMapping
    public R saveRecord(@RequestBody FoodRecordEntity foodRecord) {
        foodRecord.setUserId(SecurityUtils.getUserId());
        recordService.insert(foodRecord);
        return R.ok();
    }

    // get forecast
    @GetMapping
    public R getForecast() {
        Object myForecast = forecastRecordService.getMyForecast();
        return R.ok(myForecast);
    }

}
