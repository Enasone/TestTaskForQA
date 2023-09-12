package weatherstack.models.currentweather.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LocationData {
    private String name;
    private String country;
    private String region;
    private String lat;
    private String lon;
    private String timezone_id;
    private String localtime;
    private int localtime_epoch;
    private String utc_offset;
}
