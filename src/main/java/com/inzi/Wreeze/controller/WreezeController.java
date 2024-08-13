package com.inzi.Wreeze.controller;

import com.inzi.Wreeze.dto.ApiResponse;
import com.inzi.Wreeze.dto.LocalityWeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RestController
@RequestMapping(value = "api/weather")
public class WreezeController {

    private final RestTemplate restTemplate;

    @Value("${weatherunion.api.key}")
    private String apiKey;

    public WreezeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/")
    public ResponseEntity<ApiResponse> fetchWeather(@RequestParam(defaultValue = "12.936225") float latitude,
                                                    @RequestParam(defaultValue = "77.665059") float longitude) {

        String apiUrl = "https://www.weatherunion.com/gw/weather/external/v0/get_weather_data?latitude=" + latitude + "&longitude=" + longitude;

//string.format function
        HttpHeaders headers = new HttpHeaders();
//        headers.set("Content-Type", "application/json");
        headers.set("x-zomato-api-key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(apiUrl);
        System.out.println(entity);

        ResponseEntity<ApiResponse> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, entity, ApiResponse.class);

        System.out.println(response.getBody());
        System.out.println(restTemplate.exchange(
                apiUrl, HttpMethod.GET, entity, ApiResponse.class));
//        System.out.println(response.getBody().getLocalityWeatherData().toString());
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } else {
            ApiResponse errorResponse = new ApiResponse(500, "Failed to fetch weather data", 1, null);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


//package com.inzi.Wreeze.controller;
//
//import com.inzi.Wreeze.dto.ApiResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@RestController
//@RequestMapping(value ="api/weather")
//public class WreezeController {
//
//    @GetMapping(value="/")
//    public ResponseEntity<ApiResponse> fetchWeather(@RequestParam(defaultValue = "12.936225") float latitude,
//                                                    @RequestParam(defaultValue = "77.665059") float longitude
//                                                    )
//    {
//
//        String apiUrl = "https://www.weatherunion.com/gw/weather/external/v0/get_weather_data";
//        String key = "x-zomato-api-key";
//        String value = "dd9eaf96757d0656be06cdf46a94be83";
//
//
//        return new ResponseEntity<>(ApiResponse, HttpStatus.OK);
//    }
//}

