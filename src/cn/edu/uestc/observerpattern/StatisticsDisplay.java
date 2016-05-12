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
public class StatisticsDisplay implements Observer, DisplayElement {

    static float temperatureSum = 0;
    static float temperatureMax = 0;
    static float temperatureMin = 100;
    static int notifyNum = 0;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperatureSum += temperature;
        this.temperatureMax = getMax(this.temperatureMax, temperature);
        this.temperatureMin = getMin(this.temperatureMin, temperature);
        this.notifyNum++;
        display();
    }

    public void display() {
        System.out.println("Avg/Max/Min temperature = " + temperatureSum / notifyNum + "/" + temperatureMax + "/" + temperatureMin);
    }

    public float getMax(float tempA, float tempB) {
        return (tempA > tempB) ? tempA : tempB;
    }

    public float getMin(float tempA, float tempB) {
        return (tempA < tempB) ? tempA : tempB;
    }
}
