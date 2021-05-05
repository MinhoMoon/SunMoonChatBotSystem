package Weather;

import java.io.IOException;
import me.sungbin.myapplication.weather.model.Response;

public class Weather { // retrofit 데이터 호출
    public static Response get(String locate) throws IOException { // 위치 대입
        return WeatherClient.getInstance().getData(locate).execute().body();
    }

    public static Response get() throws IOException { // 위치 기본값(천안) 대입
        return WeatherClient.getInstance().getData("Seoul").execute().body();
    }
}
