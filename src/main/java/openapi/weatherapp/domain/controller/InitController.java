package openapi.weatherapp.domain.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import openapi.weatherapp.domain.dto.ResponseVo;
import openapi.weatherapp.domain.dto.WeatherRequestVo;
import openapi.weatherapp.domain.dto.WeatherResponseVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InitController {

    @GetMapping("/")
    public String index() {
        return "";
    }

    @GetMapping("/hello")
    public ResponseEntity<ResponseVo> initApi(@RequestParam(value="input") String input) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setUcd("00");
        responseVo.setMessage("수신된 값 : " + input);
        return ResponseEntity.ok(responseVo);
    }
}
