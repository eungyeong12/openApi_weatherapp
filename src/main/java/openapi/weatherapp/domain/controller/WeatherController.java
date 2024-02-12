package openapi.weatherapp.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import openapi.weatherapp.domain.dto.ResponseVo;
import openapi.weatherapp.domain.dto.WeatherDetailVo;
import openapi.weatherapp.domain.dto.WeatherRequestVo;
import openapi.weatherapp.domain.dto.WeatherResponseVo;
import openapi.weatherapp.domain.service.WeatherService;
import openapi.weatherapp.util.DateUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/weather/findAll")
    public ResponseEntity<List<WeatherDetailVo>> testOpenApi() {

        // requestVo 정의
        WeatherRequestVo weatherRequestVo = new WeatherRequestVo();
        weatherRequestVo.setKey("");
        weatherRequestVo.setType("json");
        weatherRequestVo.setSdate(DateUtil.getCurrentDate());
        weatherRequestVo.setStdHour(DateUtil.getBeforeTime(6));

        // API 호출을 통해 전국 휴게소 날씨 LIST 가져오기
        WeatherResponseVo weatherResponse = weatherService.getWeatherInfoList(weatherRequestVo);
        log.info("weatherResponse VO count : " + weatherResponse.getCount());

        // 전국 휴게소 날씨 리턴
        return ResponseEntity.ok(weatherResponse.getList());
    }
}
