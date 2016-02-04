package com.example.elmedin.kirchheim.weatherWidget.reader;

import com.example.elmedin.kirchheim.weatherWidget.feeds.WeatherFeed;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

/**
 * Created by Michael on 04.02.2016.
 */
public class RSSFeedReader implements Reader {
    private static final String CONDITION = "condition";
    private static final String FORECAST = "forecast";
    public static WeatherFeed retrieveWeatherFeed(InputStream is) throws Exception {
        XmlPullParserFactory xmlFactoryObject = XmlPullParserFactory.newInstance();
        XmlPullParser myParser = xmlFactoryObject.newPullParser();
        myParser.setInput(is, null);

        //Init WeatherFeed
        WeatherFeed weatherFeed = new WeatherFeed();
        //Read RSSFeed
        int event = myParser.getEventType();
        while(event != XmlPullParser.END_DOCUMENT) {
            String name = myParser.getName();
            switch(name) {
                case CONDITION: {
                    weatherFeed.setCurrentTemperature(myParser.getAttributeValue(null, "temp"));
                    break;
                }
                case FORECAST: {
                    String extractedDate = myParser.getAttributeValue(null, "date");
                    String[] splitDate = extractedDate.split(" ");
                    splitDate[1] = mapMonth(splitDate[1]);
                    String transformDate = splitDate[0] + "." + splitDate[1] + "." + splitDate[2];
                    String[] temperatureRange = new String[2];
                    temperatureRange[0] = myParser.getAttributeValue(null, "low");
                    temperatureRange[1] = myParser.getAttributeValue(null, "high");
                    weatherFeed.addToForecast(transformDate, temperatureRange);
                    break;
                }
            }
        }
        return weatherFeed;
    }


    private static String mapMonth(String month) {
        if(month.equals("Jan")) {
            return "01";
        }
        if(month.equals("Feb")) {
            return "02";
        }
        if(month.equals("Mar")) {
            return "03";
        }
        if(month.equals("Apr")) {
            return "04";
        }
        if(month.equals("May")) {
            return "05";
        }
        if(month.equals("Jun")) {
            return "06";
        }
        if(month.equals("Jul")) {
            return "07";
        }
        if(month.equals("Aug")) {
            return "08";
        }
        if(month.equals("Sep")) {
            return "09";
        }
        if(month.equals("Okt")) {
            return "10";
        }
        if(month.equals("Nov")) {
            return "11";
        }
        if(month.equals("Dez")) {
            return "12";
        }
        return "ERROR";
    }

    private static String mapWeekDay(String weekDay) {
        if(weekDay.equals("Tue")) {
            return "Die";
        }
        if(weekDay.equals("Wed")) {
            return "Wed";
        }
        if(weekDay.equals("Thu")) {
            return "Thu";
        }
        if(weekDay.equals("Fri")) {
            return "Fre";
        }
        if(weekDay.equals("Sat")) {
            return "Sat";
        }
        if(weekDay.equals("Sun")) {
            return "Sun";
        }
        return weekDay;
    }
}
