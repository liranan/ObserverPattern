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
public class ForecastDisplay implements Observer, DisplayElement {

    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }

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
