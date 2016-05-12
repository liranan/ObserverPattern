/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.uestc.observerpattern;

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

        weatherData.setMeasureMents(80, 65, 30.4f);
        System.out.println("======================");

        weatherData.setMeasureMents(82, 70, 29.2f);
        System.out.println("======================");

        weatherData.setMeasureMents(78, 90, 29.2f);
    }
}
