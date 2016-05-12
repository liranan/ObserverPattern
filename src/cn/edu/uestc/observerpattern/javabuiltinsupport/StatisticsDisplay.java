/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.uestc.observerpattern.javabuiltinsupport;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Liranan
 */
public class StatisticsDisplay implements Observer, DisplayElement {

    private float temperatureSum = 0.0f;
    private float temperatureMax = 0.0f;
    private float temperatureMin = 200.0f;
    private int notifyNum = 0;

    public StatisticsDisplay(Observable weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            float temperature = weatherData.getTemperature();
            temperatureSum += temperature;
            temperatureMax = getMax(temperatureMax, temperature);
            temperatureMin = getMin(temperatureMin, temperature);
            notifyNum++;
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = "
                + (temperatureSum / notifyNum) + "/" + temperatureMax + "/" + temperatureMin);
    }

    private float getMax(float temperatureMax, float temperature) {
        return (temperatureMax > temperature) ? temperatureMax : temperature;
    }

    private float getMin(float temperatureMin, float temperature) {
        return (temperatureMin < temperature) ? temperatureMin : temperature;
    }

}
