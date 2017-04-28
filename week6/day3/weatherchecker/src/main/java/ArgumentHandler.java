import java.lang.reflect.Array;
import java.util.Arrays;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class ArgumentHandler {

  LatLngHandler location = new LatLngHandler();

  public void handleArgs(String[] args) {
    if (args.length == 0) {
      Controller.printUsage();
    }

    OptionSet options = getOptionSetFromParser(args);

    if (options.has("c")) {
      getFirstCountryWeatherInfo(args);
    }

    if (options.has("c") && options.has("compare")) {
      String countryCode1 = options.valueOf("c").toString();
      String countryCode2 = options.valueOf("compare").toString();
      System.out.println("Weather Difference is: " + ArgumentHandler.compare(getFirstCountryWeatherInfo(args), getSecondCountryWeatherInfo(args)) + " c");
    }
  }

  private static int compare(String firstCountryWeatherInfo, String secondCountryWeatherInfo) {
    String[] firstStringArray = firstCountryWeatherInfo.split(" ");
    String[] secondStringArray = secondCountryWeatherInfo.split(" ");
    int firstNumber = Integer.parseInt(firstStringArray[0]);
    int secondNumber = Integer.parseInt(secondStringArray[0]);
    return firstNumber > secondNumber ? firstNumber - secondNumber : secondNumber - firstNumber;
  }


  void getFirstCountryWeatherInfo(String[] args) {
    LatitudeLongitudeDots coordinates = location.getDots(getOptionSetFromParser(args).valueOf("c").toString());
    Controller.printWeatherAtLocation(Controller.createWeatherService(), coordinates.getLatitude(), coordinates.getLongitude());
  }

  void getSecondCountryWeatherInfo(String[] args) {
    String returnValue;
    LatitudeLongitudeDots coordinates = location.getDots(getOptionSetFromParser(args).valueOf("compare").toString());
    Controller.printWeatherAtLocation(Controller.createWeatherService(), coordinates.getLatitude(), coordinates.getLongitude());
  }

  private static OptionSet getOptionSetFromParser(String[] args) {
    OptionParser parser = new OptionParser();
    parser.accepts("c").withRequiredArg();
    parser.accepts("compare").withRequiredArg();
    return parser.parse(args);
  }

}
