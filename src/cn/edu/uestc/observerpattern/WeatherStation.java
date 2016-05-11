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

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasureMents(80, 65, 30.4f);
        weatherData.setMeasureMents(82, 70, 29.2f);
        weatherData.setMeasureMents(79, 90, 29.2f);
    }
}
