package com.inzi.Wreeze.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalityWeatherData {

    private float temperature;
    private float humidity;
    private float wind_speed;
    private float wind_direction;
    private float rain_intensity;
    private float rain_accumulation;

    @Override
    public String toString() {
        return "LocalityWeatherData{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", wind_speed=" + wind_speed +
                ", wind_direction=" + wind_direction +
                ", rain_intensity=" + rain_intensity +
                ", rain_accumulation=" + rain_accumulation +
                '}';
    }
}


