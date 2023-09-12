package weatherstack.models.currentweather.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class CurrentData {
   private String observation_time;
   private int temperature;
   private int weather_code;
   private ArrayList<String> weather_icons;
   private ArrayList<String> weather_descriptions;
   private int wind_speed;
   private int wind_degree;
   private String wind_dir;
   private int pressure;
   private int precip;
   private int humidity;
   private int cloudcover;
   private int feelslike;
   private int uv_index;
   private int visibility;
}
