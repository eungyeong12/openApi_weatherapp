package openapi.weatherapp.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponseVo {
    int count;
    ArrayList<WeatherDetailVo> list;
}
