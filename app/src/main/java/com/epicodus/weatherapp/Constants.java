package com.epicodus.weatherapp;

/**
 * Created by Guest on 4/25/16.
 */

public class Constants {
    public static final String WEATHER_API_KEY = BuildConfig.WEATHER_API_KEY;

    public static final String WEATHER_BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=imperial&cnt=7";
    public static final String WEATHER_LOCATION_QUERY_PARAMETER = "q";
    public static final String WEATHER_API_QUERY_PARAMETER = "appid";
}
