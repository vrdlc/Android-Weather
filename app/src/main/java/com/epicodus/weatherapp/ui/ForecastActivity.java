package com.epicodus.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.adapters.ForecastListAdapter;
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
    @Bind(R.id.forecastRecyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.tvCityName) TextView mTVCityName;
    private ForecastListAdapter mAdapter;

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
                        mTVCityName.setText(mForecasts.get(0).getName() + ", " + mForecasts.get(0).getCountry());
                        mAdapter = new ForecastListAdapter(getApplicationContext(), mForecasts);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ForecastActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }

                });
            }
        });
    }
}
