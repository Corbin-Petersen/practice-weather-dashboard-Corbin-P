package com.example.practice_weather_dashboard_Corbin_P.models;

import jakarta.persistence.Entity;

@Entity
public class Main {
    private double temp;
    private double humidity;

    public Main() {}

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Temperature: " + temp +
                "Humidity: " + humidity;
    }
}
