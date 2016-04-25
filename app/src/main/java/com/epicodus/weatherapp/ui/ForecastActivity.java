package com.epicodus.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.services.WeatherService;

import java.io.IOException;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ForecastActivity extends AppCompatActivity {
    public static final String TAG = ForecastActivity.class.getSimpleName();

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
        WeatherService.findWeather(city, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        Log.v("JSONDATA: ", jsonData);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
