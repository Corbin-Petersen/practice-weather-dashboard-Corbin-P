package com.example.practice_weather_dashboard_Corbin_P.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int zip;
    private String name;
    private int lat;
    private int lon;
    private String country;
    private String state;

    // CONSTRUCTORS
    public City(){}

    public City(int zip, String name, int lat, int lon, String country) {
        this.zip = zip;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.state = null;
    }

    public City(String name, int lat, int lon, String country, String state) {
        this.zip = 0;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.state = state;
    }

    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City: " + name;
    }
}
