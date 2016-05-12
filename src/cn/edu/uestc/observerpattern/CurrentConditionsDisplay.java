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
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
//        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Curretn conditions:" + temperature + "F degrees and " + humidity + "% humidity");
    }
}
