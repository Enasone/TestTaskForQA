package weatherstack.models.currentweather.providers;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import weatherstack.models.currentweather.CurrentWeatherResponse;
import weatherstack.models.currentweather.data.CurrentData;
import weatherstack.models.currentweather.data.LocationData;
import weatherstack.models.currentweather.data.RequestData;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public class CurrentWeatherProvider {

    private CurrentWeatherProvider() {
        throw new RuntimeException("Class" + getClass() + "must not be instantiated");
    }

    public static CurrentWeatherResponse expectedCurrentWeatherNewYork() {
        LocationData locationData = new LocationData()
                .name("New York")
                .country("United States of America")
                .region("New York")
                .lat("40.714")
                .lon("-74.006")
                .timezone_id("America/New_York")
                .localtime(LocalDateTime.now(ZoneId.of("America/New_York")).toString())
                .localtime_epoch(1694408220)
                .utc_offset(ZoneId.of("America/New_York").toString());

        RequestData requestData = new RequestData()
                .type("City")
                .query("New York, United States of America")
                .language("en")
                .unit("m");


        return new CurrentWeatherResponse()
                .current(randomCurrentData())
                .location(locationData)
                .request(requestData);
    }

    private static CurrentData randomCurrentData() {
        return new CurrentData()
                .observation_time(RandomStringUtils.random(5))
                .temperature(RandomUtils.nextInt(1, 30))
                .weather_code(RandomUtils.nextInt(1, 1000))
                .weather_icons(new ArrayList<>())
                .weather_descriptions(new ArrayList<>())
                .wind_speed(RandomUtils.nextInt(1, 30))
                .wind_degree(RandomUtils.nextInt(1, 100))
                .wind_dir("NE")
                .pressure(RandomUtils.nextInt(1, 30))
                .precip(RandomUtils.nextInt(1, 30))
                .humidity(RandomUtils.nextInt(1, 30))
                .cloudcover(RandomUtils.nextInt(1, 30))
                .feelslike(RandomUtils.nextInt(1, 30))
                .uv_index(RandomUtils.nextInt(1, 30))
                .visibility(RandomUtils.nextInt(1, 30));
    }
}
