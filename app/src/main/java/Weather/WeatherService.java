package Weather;

import com.example.sunmoonchatbot.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("/data/2.5/weather?appid=64e3596ae740028b9e95db0c56dc5331") // 패치 정의
    Call<Response> getData(@Query("q") String locate); // 위치 정의
}
