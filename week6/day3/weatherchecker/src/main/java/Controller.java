import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class Controller {

  private static final String USAGE_FILE_PATH = "src/main/resources/usageInfo.csv";

  static WeatherChecker createWeatherService() {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://simple-weather.p.mashape.com/")
            .build();
    return retrofit.create(WeatherChecker.class);
  }

  static void printWeatherAtLocation(WeatherChecker weatherChecker, String latitude, String longitude) {
    Call<ResponseBody> weatherResponse = weatherChecker.getWeather(latitude, longitude);
    try {
      System.out.println(weatherResponse.execute().body().string());
        } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void printUsage() {
    for (String[] whatEver : FileHandler.fileReader(USAGE_FILE_PATH)) {
      for (int i = 0; i < whatEver.length; i++) {
        System.out.print(whatEver[i] + " ");
      }
      System.out.println();
    }
  }
}

