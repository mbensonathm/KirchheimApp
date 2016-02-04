package com.example.elmedin.kirchheim.weatherWidget.feeds;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michael on 04.02.2016.
 */
public class WeatherFeed implements com.example.elmedin.kirchheim.weatherWidget.feeds.Feed {
public String title;
public String currentTemperature;
public Map<String, String[]> forecast;

    public WeatherFeed() {
    }

    public void addToForecast(String date, String[] tempRange) {
        if(forecast != null) {
            forecast.put(date, tempRange);
        }
        else {
            forecast = new HashMap<>();
            forecast.put(date, tempRange);
        }
    }

    public void setCurrentTemperature(String currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public String getTitle() {
        return title;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public Map<String, String[]> getForecast() {
        return forecast;
    }
}