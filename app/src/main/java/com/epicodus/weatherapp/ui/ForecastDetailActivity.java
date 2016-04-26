package com.epicodus.weatherapp.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.adapters.ForecastPagerAdapter;
import com.epicodus.weatherapp.models.Forecast;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ForecastDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ForecastPagerAdapter adapterViewPager;
    ArrayList<Forecast> mForecasts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_detail);
        ButterKnife.bind(this);
        mForecasts = Parcels.unwrap(getIntent().getParcelableExtra("forecasts"));
        int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
        adapterViewPager = new ForecastPagerAdapter(getSupportFragmentManager(), mForecasts);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);

    }
}
