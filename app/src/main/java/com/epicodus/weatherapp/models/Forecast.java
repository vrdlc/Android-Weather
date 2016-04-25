package com.epicodus.weatherapp.models;



import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Guest on 4/25/16.
 */
public class Forecast {
    private String mCityName;
    private int mCityId;
    private String mCountry;
    private Date mDate; // JAVA DATE
    private double mDayTemperature;
    private double mMaxDayTemperature;
    private double mMinDayTemperature;
    private double mNightTemperature;
    private double mEveningTemperature;
    private double mMorningTemperature;
    private double mPressure;
    private int mHumidity;
    private int mWeatherId;
    private String mWeatherMain;
    private String mDescription;
    private String mIconUrl;
    private double mWindSpeed;
    private int mWindDirection;
    private int mCloudPercentage;
    private double mRainPercentage;
    private double mSnowPercentage;

    public Forecast(String cityName, int cityId, String country, long dateLong, double dayTemp, double maxTemp, double minTemp, double nightTemp, double eveTemp, double mornTemp, double pressure, int humidity, int weatherId, String weatherMain, String description, String icon,  double windSpeed, int windDirection, int clouds, double rainPercentage, double snowPercentage){
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
        this.mRainPercentage = rainPercentage;
        this.mSnowPercentage = snowPercentage;
    }

    public String getName(){
        return mCityName;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getDate() {
        return DateFormat.getDateInstance().format(mDate);
    }

    public double getHighTemp() {
        return mMaxDayTemperature;
    }

    public double getLowTemp() {
        return mMinDayTemperature;
    }

    public String getHumidity() {
        return mHumidity + "%";
    }

    public String getWeatherMain() {
        return mWeatherMain;
    }

    public String getDescription () {
        return mDescription;
    }

    public String getIcon() {
        return mIconUrl;
    }
}
