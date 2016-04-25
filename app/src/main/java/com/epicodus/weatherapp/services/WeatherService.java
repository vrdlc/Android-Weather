package com.epicodus.weatherapp.services;

import android.util.Log;

import com.epicodus.weatherapp.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 4/25/16.
 */
public class WeatherService {
    public static final String TAG = WeatherService.class.getSimpleName();

    public static void findWeather(String city, Callback callback){
        String WEATHER_API_KEY = Constants.WEATHER_API_KEY;


        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.WEATHER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.WEATHER_LOCATION_QUERY_PARAMETER, city);
        urlBuilder.addQueryParameter(Constants.WEATHER_API_QUERY_PARAMETER, WEATHER_API_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Log.v(TAG, "URL: " + request);
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
