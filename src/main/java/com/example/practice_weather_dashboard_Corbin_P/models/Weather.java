package com.example.practice_weather_dashboard_Corbin_P.models;

import jakarta.persistence.Entity;

@Entity
public class Weather {
    private String description;

    public Weather(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Conditions: " + description;
    }
}
