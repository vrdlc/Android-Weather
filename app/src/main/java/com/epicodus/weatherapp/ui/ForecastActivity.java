package com.epicodus.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.models.Forecast;
import com.epicodus.weatherapp.services.WeatherService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ForecastActivity extends AppCompatActivity {
    public static final String TAG = ForecastActivity.class.getSimpleName();
    public ArrayList<Forecast> mForecasts = new ArrayList<>();
    @Bind(R.id.forecastListView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        getForecast(city);
    }

    private void getForecast(String city) {
        final WeatherService weatherService = new WeatherService();

        WeatherService.findWeather(city, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mForecasts = weatherService.processResults(response);

                ForecastActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] dailyForecast = new String[mForecasts.size()];
                        for (int i = 0; i < dailyForecast.length; i++) {
                            dailyForecast[i] = mForecasts.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(ForecastActivity.this, android.R.layout.simple_list_item_1, dailyForecast);
                        mListView.setAdapter(adapter);

                        for(Forecast forecast : mForecasts) {
                            Log.d(TAG, "Name: " + forecast.getName());
                            Log.d(TAG, "Country: " + forecast.getCountry());
                            Log.d(TAG, "Date: " + forecast.getDate());
                            Log.d(TAG, "High: " + forecast.getHighTemp());
                            Log.d(TAG, "Low: " + forecast.getLowTemp());
                            Log.d(TAG, forecast.getIcon());
                        }

                    }

                });
            }
        });
    }
}
