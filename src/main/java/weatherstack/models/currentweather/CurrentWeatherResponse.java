package weatherstack.models.currentweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import weatherstack.models.currentweather.data.CurrentData;
import weatherstack.models.currentweather.data.LocationData;
import weatherstack.models.currentweather.data.RequestData;

@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class CurrentWeatherResponse {
    private RequestData request;
    private LocationData location;
    private CurrentData current;
}
