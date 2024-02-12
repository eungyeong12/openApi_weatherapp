package openapi.weatherapp.domain.service;

import openapi.weatherapp.domain.dto.WeatherRequestVo;
import openapi.weatherapp.domain.dto.WeatherResponseVo;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    public WeatherResponseVo getWeatherInfoList(WeatherRequestVo weatherRequestVo) {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://data.ex.co.kr/openapi/restinfo")
                .build();

        String apiUrl = "/restWeatherList?key={apiKey}&type={type}&sdate={sdate}&stdHour={stdHour}";
        WeatherResponseVo weatherResponse = webClient.get()
                .uri(apiUrl, weatherRequestVo.getKey(), weatherRequestVo.getType(), weatherRequestVo.getSdate(), weatherRequestVo.getStdHour())
                .retrieve()
                .bodyToMono(WeatherResponseVo.class)
                .block();

        return weatherResponse;
    }
}
