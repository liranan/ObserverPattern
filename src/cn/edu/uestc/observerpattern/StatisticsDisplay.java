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

    private float temperatureSum = 0.0f;
    static float temperatureMax = 0.0f;
    static float temperatureMin = 200.0f;
    static int notifyNum = 0;

    public StatisticsDisplay(Subject weatherData) {
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
