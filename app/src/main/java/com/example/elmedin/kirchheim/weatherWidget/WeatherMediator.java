package com.example.elmedin.kirchheim.weatherWidget;

import com.example.elmedin.kirchheim.HttpRequestBuilder;
import com.example.elmedin.kirchheim.weatherWidget.feeds.WeatherFeed;
import com.example.elmedin.kirchheim.weatherWidget.reader.RSSFeedReader;

/**
 * Created by Michael on 04.02.2016.
 */
public class WeatherMediator {
    public static void main(String[] args) {
        constructWeatherWidget();
    }
    public static void constructWeatherWidget() {
        try {
            WeatherFeed weatherFeed = RSSFeedReader.retrieveWeatherFeed(HttpRequestBuilder.retrieveInputStreamFromGet("http://weather.yahooapis.com/forecastrss?w=12837072&u=c"));

            //TODO: Insert filled widget construction

        }
        catch (Exception e) {
            //TODO: Insert empty widget construction
        }
    }
}
