package com.ht.common.utils;

import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PolynomialRegression {
    private PolynomialCurveFitter fitter; 
    private double[] coefficients; 

    public PolynomialRegression(int degree) {
        fitter = PolynomialCurveFitter.create(degree);
    }

    public void fit(List<Double> xData, List<Double> yData) {
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < yData.size(); i++) {
            points.add(xData.get(i), yData.get(i));
        }
        
        coefficients = fitter.fit(points.toList());
    }

    /**
     * @Description: predict Y value based on X value
     * @date:2023/8/1 13:18
     */
    public List<Double> predict(List<Double> preX) {
        DecimalFormat df = new DecimalFormat("#.00");
        List<Double> preY = new ArrayList<>();
        for (int index = 0; index < preX.size(); index++) {
            double y = (double) 0;
            for (int i = 0; i < coefficients.length; i++) {
                y += coefficients[i] * Math.pow(preX.get(index), i);
            }
            y = Double.parseDouble(df.format(y));
            preY.add(y);
        }

        return preY;
    }

    public Double predict(Double preX) {
        DecimalFormat df = new DecimalFormat("#.0");
        double y = (double) 0;
        for (int i = 0; i < coefficients.length; i++) {
            y += coefficients[i] * Math.pow(preX, i);
        }
        return Double.parseDouble(df.format(y));
    }

}
