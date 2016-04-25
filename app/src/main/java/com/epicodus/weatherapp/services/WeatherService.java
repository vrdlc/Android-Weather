package com.epicodus.weatherapp.services;

import android.util.Log;

import com.epicodus.weatherapp.Constants;
import com.epicodus.weatherapp.models.Forecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

    public ArrayList<Forecast> processResults(Response response){
        ArrayList<Forecast> forecasts = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            if(response.isSuccessful()){
                JSONObject weatherJSON = new JSONObject(jsonData);
                JSONArray forecastsJSON = weatherJSON.getJSONArray("list");
                String city = weatherJSON.getJSONObject("city").getString("name");
                String country = weatherJSON.getJSONObject("city").getString("country");
                int cityId = weatherJSON.getJSONObject("city").getInt("id");
                for (int i = 0; i < forecastsJSON.length(); i++){
                    JSONObject dayJSON = forecastsJSON.getJSONObject(i);
                    Long dateLong = dayJSON.getLong("dt") * 1000;
                    double dayTemp = dayJSON.getJSONObject("temp").getDouble("day");
                    double maxTemp = dayJSON.getJSONObject("temp").getDouble("max");
                    double minTemp = dayJSON.getJSONObject("temp").getDouble("min");
                    double nightTemp = dayJSON.getJSONObject("temp").getDouble("night");
                    double eveTemp = dayJSON.getJSONObject("temp").getDouble("eve");
                    double mornTemp = dayJSON.getJSONObject("temp").getDouble("morn");
                    double pressure = dayJSON.getDouble("pressure");
                    int humidity = dayJSON.getInt("humidity");
                    int weatherId = dayJSON.getJSONArray("weather").getJSONObject(0).getInt("id");
                    String weatherMain = dayJSON.getJSONArray("weather").getJSONObject(0).getString("main");
                    String description = dayJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                    String icon = dayJSON.getJSONArray("weather").getJSONObject(0).getString("icon");
                    double windSpeed = dayJSON.getDouble("speed");
                    int windDirection = dayJSON.getInt("deg");
                    int clouds = dayJSON.getInt("clouds");
                    double rainPercentage = dayJSON.optDouble("rain", 0);
                    double snowPercentage = dayJSON.optDouble("snow", 0);

                    Forecast forecast = new Forecast(city, cityId, country, dateLong, dayTemp, maxTemp, minTemp, nightTemp, eveTemp, mornTemp, pressure, humidity, weatherId, weatherMain, description, icon, windSpeed, windDirection,  clouds, rainPercentage, snowPercentage);
                    forecasts.add(forecast);
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        }
        return forecasts;
    }
}
