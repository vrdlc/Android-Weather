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
    public double mLatitude;
    public double mLongitude;

    public Forecast(){

    }

    public Forecast(String cityName, int cityId, String country, long dateLong, int dayTemp, int maxTemp, int minTemp, int nightTemp, int eveTemp, int mornTemp, double pressure, int humidity, int weatherId, String weatherMain, String description, String icon,  double windSpeed, int windDirection, int clouds, double rainAmount, double snowAmount, double latitude, double longitude){
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
        this.mLongitude = longitude;
        this.mLatitude = latitude;
    }

    public double getLat() {
        return mLatitude;
    }

    public double getLon() {
        return mLongitude;
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
        return mRainAmount + " millimeters of rain expected";
    }

    public String getSnowDescription() {
        return mSnowAmount + " millimeters of snow expected";
    }

    public String getPressure(){
        return mPressure + " millibars of pressure";
    }

    public String getCloudPercentage(){
        return mCloudPercentage + "% cloud cover";
    }

    public String getWindDescription(){
        Double speed = mWindSpeed / 0.44704;
        String speedFormatted = String.format("%.2f%n", speed);
        return "Wind at " + speedFormatted + " mph from " + getWindCompassDirection(mWindDirection);
    }

    public static String getWindCompassDirection(int windDirection){
        String direction = "";
        if(windDirection <= 11 || windDirection >= 349){
            direction = "N";
        } else if (windDirection <= 33) {
            direction = "NNE";
        } else if (windDirection <= 56){
            direction = "NE";
        } else if (windDirection <= 78){
            direction = "ENE";
        } else if (windDirection <= 101){
            direction = "E";
        } else if (windDirection <= 123){
            direction = "ESE";
        } else if (windDirection <= 146){
            direction = "SE";
        } else if (windDirection <= 168){
            direction = "SSE";
        } else if (windDirection <= 191){
            direction = "S";
        } else if (windDirection <= 213){
            direction = "SSW";
        } else if (windDirection <= 236){
            direction = "SW";
        } else if (windDirection <= 258){
            direction = "WSW";
        } else if (windDirection <= 281){
            direction = "W";
        } else if (windDirection <= 303){
            direction = "WNW";
        } else if (windDirection <= 326){
            direction = "NW";
        } else if (windDirection <= 348){
            direction = "NNW";
        }

        return direction;
    }

}
