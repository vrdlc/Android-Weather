package com.epicodus.weatherapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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

public class ForecastListActivity extends AppCompatActivity {
    public static final String TAG = ForecastListActivity.class.getSimpleName();
    public ArrayList<Forecast> mForecasts = new ArrayList<>();
    @Bind(R.id.forecastRecyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.tvCityName) TextView mTVCityName;
    @Bind(R.id.buttonMap) Button mMapButton;
    private ForecastListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        getForecast(city);

        mMapButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ForecastListActivity.this, ForecastMapsActivity.class);
                startActivity(intent);
            }
        });
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

                ForecastListActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTVCityName.setText(mForecasts.get(0).getLocation());
                        mAdapter = new ForecastListAdapter(getApplicationContext(), mForecasts);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ForecastListActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }

                });
            }
        });
    }
}
