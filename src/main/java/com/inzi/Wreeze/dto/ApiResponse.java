package com.inzi.Wreeze.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int status;
    private String message;
    private int device_type;

    LocalityWeatherData locality_weather_data;

    @Override
    public String toString() {
        return "ApiResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", deviceType=" + device_type +
                ", localityWeatherData=" + locality_weather_data +
                '}';
    }
}

