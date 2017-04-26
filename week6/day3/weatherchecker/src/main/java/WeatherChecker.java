import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface WeatherChecker {

  @Headers({
          "X-Mashape-Key: JBlG23kdAKmsh03bIdIo7xKT2Brop143NgdjsnFCkLVMEOaZx6",
          "Accept: application/json"
  })

  @GET("weather/forecast/{location}.json?lang=en")
  Call<List<WeatherChecker>> listRepos(@Path("filepath") String user);


}