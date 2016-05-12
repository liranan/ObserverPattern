/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.uestc.observerpattern;

import cn.edu.uestc.observerpattern.javabuiltinsupport.WeatherData;
import cn.edu.uestc.observerpattern.javabuiltinsupport.CurrentConditionsDisplay;
import cn.edu.uestc.observerpattern.javabuiltinsupport.StatisticsDisplay;
import cn.edu.uestc.observerpattern.javabuiltinsupport.ForecastDisplay;
import cn.edu.uestc.observerpattern.javabuiltinsupport.HeatIndexDisplay;

/**
 *
 * @author Liranan
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay
                = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay
                = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay
                = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay
                = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println("======================");

        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println("======================");

        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
