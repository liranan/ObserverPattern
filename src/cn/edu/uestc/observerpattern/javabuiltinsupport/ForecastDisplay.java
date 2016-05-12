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
 * @author Administrator
 */
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Observable weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) obs;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        StringBuffer displayStrBuf = new StringBuffer("Forecast: ");
        if (currentPressure > lastPressure) {
            displayStrBuf.append("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            displayStrBuf.append("More of the same");
        } else if (currentPressure < lastPressure) {
            displayStrBuf.append("Watch out for cooler, rainy weather");
        }
        System.out.println(displayStrBuf.toString());
    }
}
