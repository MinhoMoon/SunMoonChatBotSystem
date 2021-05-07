package Weather;

import com.google.gson.annotations.SerializedName;

public class Main{

    @SerializedName("temp")
    private double temp;

    @SerializedName("temp_min")
    private double tempMin;

    @SerializedName("humidity")
    private int humidity;

    @SerializedName("pressure")
    private int pressure;

    @SerializedName("feels_like")
    private double feelsLike;

    @SerializedName("temp_max")
    private double tempMax;

    public double getTemp(){
        return temp;
    }

    public double getTempMin(){
        return tempMin;
    }

    public int getHumidity(){
        return humidity;
    }

    public int getPressure(){
        return pressure;
    }

    public double getFeelsLike(){
        return feelsLike;
    }

    public double getTempMax(){
        return tempMax;
    }
}