package com.epicodus.weatherapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.models.Forecast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 4/25/16.
 */
public class ForecastListAdapter extends RecyclerView.Adapter<ForecastListAdapter.ForecastViewHolder> {
    private ArrayList<Forecast> mForecasts = new ArrayList<>();
    private Context mContext;

    public ForecastListAdapter(Context context, ArrayList<Forecast> forecasts){
        mContext = context;
        mForecasts = forecasts;
    }

    @Override
    public ForecastListAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_item, parent, false);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastListAdapter.ForecastViewHolder holder, int position){
        holder.bindForecast(mForecasts.get(position));
    }

    @Override
    public int getItemCount(){
        return mForecasts.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.weatherIconImageView) ImageView mWeatherIconView;
        @Bind(R.id.forecastDateTextView) TextView mForecastDateView;
        @Bind(R.id.temperatureTextView) TextView mForecastTemperatureView;
        private Context mViewContext;

        public ForecastViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mViewContext = itemView.getContext();
        }

        public void bindForecast(Forecast forecast){
            mForecastDateView.setText(forecast.getDate());
            mForecastTemperatureView.setText(forecast.getLowTemp() + "/" + forecast.getHighTemp() + "° F" );
            Picasso.with(mViewContext).load(forecast.getIcon()).into(mWeatherIconView);
        }
    }

}
