package weatherstack.apis;

public final class Endpoints {

    private Endpoints() {
        throw new RuntimeException("Class" + getClass() + "must not be instantiated");
    }

    public static final class WeatherStack {
        private static final String BASE_PATH = "http://api.weatherstack.com";
        public static final String CURRENT_WEATHER = BASE_PATH + "/current";
    }
}
