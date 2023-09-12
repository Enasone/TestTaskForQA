package weatherstack.models.currentweather.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {
    private String type;
    private String query;
    private String language;
    private String unit;
}
