package com.epicodus.weatherapp.models;



import org.parceler.Parcel;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Guest on 4/25/16.
 */
@Parcel
public class Forecast {
    public String mCityName;
    public int mCityId;
    public String mCountry;
    public Date mDate; // JAVA DATE
    public int mDayTemperature;
    public int mMaxDayTemperature;
    public int mMinDayTemperature;
    public int mNightTemperature;
    public int mEveningTemperature;
    public int mMorningTemperature;
    public double mPressure;
    public int mHumidity;
    public int mWeatherId;
    public String mWeatherMain;
    public String mDescription;
    public String mIconUrl;
    public double mWindSpeed;
    public int mWindDirection;
    public int mCloudPercentage;
    public double mRainAmount;
    public double mSnowAmount;

    public Forecast(){

    }

    public Forecast(String cityName, int cityId, String country, long dateLong, int dayTemp, int maxTemp, int minTemp, int nightTemp, int eveTemp, int mornTemp, double pressure, int humidity, int weatherId, String weatherMain, String description, String icon,  double windSpeed, int windDirection, int clouds, double rainAmount, double snowAmount){
        this.mCityName = cityName;
        this.mCityId = cityId;
        this.mCountry = country;
        this.mDate = new Date(dateLong);
        this.mDayTemperature = dayTemp;
        this.mMaxDayTemperature = maxTemp;
        this.mMinDayTemperature = minTemp;
        this.mNightTemperature = nightTemp;
        this.mEveningTemperature = eveTemp;
        this.mMorningTemperature = mornTemp;
        this.mPressure = pressure;
        this.mHumidity = humidity;
        this.mWeatherId = weatherId;
        this.mWeatherMain = weatherMain;
        this.mDescription = description;
        this.mIconUrl = "http://openweathermap.org/img/w/" + icon + ".png";
        this.mWindSpeed = windSpeed;
        this.mWindDirection = windDirection;
        this.mCloudPercentage = clouds;
        this.mRainAmount = rainAmount;
        this.mSnowAmount = snowAmount;
    }

    public String getName(){
        return mCityName;
    }

    public String getLocation(){
        return mCityName + ", " + mCountry;
    }

    public String getTempRange(){
        return mMinDayTemperature + "° F/" + mMaxDayTemperature + "° F";
    }

    public String getCountry() {
        return mCountry;
    }

    public String getDate() {
        return DateFormat.getDateInstance().format(mDate);
    }

    public int getHighTemp() {
        return mMaxDayTemperature;
    }

    public int getLowTemp() {
        return mMinDayTemperature;
    }

    public String getHumidity() {
        return mHumidity + "% humidity";
    }

    public String getWeatherMain() {
        return mWeatherMain;
    }

    public String getDescription () {
        return "The weather is expected to include " + mDescription;
    }

    public String getIcon() {
        return mIconUrl;
    }

    public String getRainDescription() {
        return mRainAmount + " inches of rain expected";
    }

    public String getSnowDescription() {
        return mSnowAmount + " inches of snow expected";
    }

    public String getPressure(){
        return mPressure + " millibars of pressure";
    }

    public String getCloudPercentage(){
        return mCloudPercentage + "% cloud cover";
    }

    public String getWindDescription(){
        return "Wind at " + mWindSpeed + " somethings from " + mWindDirection; // refactor when we know units and direction - ie nne
    }

}
