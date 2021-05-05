package Weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    private static WeatherService instance = null;
    private static final String BASE_URL = "http://api.openweathermap.org";

    static WeatherService getInstance() { // 싱글톤으로 생성
        if (instance == null) {
            instance = new Retrofit.Builder() // rest-api 호출 retrofit
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // from Json
                    .build()
                    .create(WeatherService.class);
        }
        return instance;
    }
}