package com.epicodus.weatherapp.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.weatherapp.R;
import com.epicodus.weatherapp.models.Forecast;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastDetailFragment extends Fragment {
    @Bind(R.id.iconImageView) ImageView mIconDetail;
    @Bind(R.id.cityNameDetailTextView) TextView mCityNameDetail;
    @Bind(R.id.tempDetailTextView) TextView mTempDetail;
    @Bind(R.id.friendlyForecastTextView) TextView mFriendlyForecastDetail;
    @Bind(R.id.rainTextView) TextView mRainDetail;
    @Bind(R.id.snowTextView) TextView mSnowDetail;
    @Bind(R.id.humidityTextView) TextView mHumidityDetail;
    @Bind(R.id.pressureTextView) TextView mPressureDetail;
    @Bind(R.id.cloudsTextView) TextView mCloudDetail;
    @Bind(R.id.windTextView) TextView mWindDetail;

    private Forecast mForecast;

    public ForecastDetailFragment() {
        // Required empty public constructor
    }

    public static ForecastDetailFragment newInstance(Forecast forecast){
        ForecastDetailFragment forecastDetailFragment = new ForecastDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("forecast", Parcels.wrap(forecast));
        forecastDetailFragment.setArguments(args);
        return forecastDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mForecast = Parcels.unwrap(getArguments().getParcelable("forecast"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mForecast.getIcon()).into(mIconDetail);
        mCityNameDetail.setText(mForecast.getLocation());
        mTempDetail.setText(mForecast.getTempRange());
        mFriendlyForecastDetail.setText(mForecast.getDescription());
        mRainDetail.setText(mForecast.getRainDescription());
        mSnowDetail.setText(mForecast.getSnowDescription());
        mHumidityDetail.setText(mForecast.getHumidity());
        mPressureDetail.setText(mForecast.getPressure());
        mCloudDetail.setText(mForecast.getCloudPercentage());
        mWindDetail.setText(mForecast.getWindDescription());
        return view;
    }

}
