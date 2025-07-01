package com.example.practice_weather_dashboard_Corbin_P.controllers;

import com.example.practice_weather_dashboard_Corbin_P.models.City;
import com.example.practice_weather_dashboard_Corbin_P.models.Main;
import com.example.practice_weather_dashboard_Corbin_P.models.Weather;
import com.example.practice_weather_dashboard_Corbin_P.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    // CRUD METHODS
    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityRepository.save(city);
    }
    @GetMapping
    public List<City> getCities() {
        return cityRepository.findAll();
    }
    @GetMapping("/{id}")
    public City getCity(@PathVariable int id) {
        return cityRepository.findById(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable int id) {
        cityRepository.deleteById(id);
    }

    // set RestTemplate
    public static RestTemplate restTemplate = new RestTemplate();
    public static String apiKey = System.getenv("API_KEY");

    public static void getWeatherByZip(int zipCode) {
        String locationAPI = "http://api.openweathermap.org/geo/1.0/zip?zip=" + zipCode + "US&appid=" + apiKey;
        City city = restTemplate.getForObject(locationAPI, City.class);
        String weatherAPI = "https://api.openweathermap.org/data/2.5/weather?lat=" + city.getLat() + "&lon=" + city.getLon() + "&units=imperial&appid=" + apiKey;
        Weather weather = restTemplate.getForObject(weatherAPI, Weather.class);
        Main main = restTemplate.getForObject(weatherAPI, Main.class);
        System.out.println(city);
        System.out.println(weather.toString());
        System.out.println(main.toString());
    }
    // get weather by name
    public static void getWeatherByName(String name, String state) {
        String locationAPI = "http://api.openweathermap.org/geo/1.0/direct?q=" + name + "," + state + "US&appid=" + apiKey;
        City city = restTemplate.getForObject(locationAPI, City.class);
        String weatherAPI = "https://api.openweathermap.org/data/2.5/weather?lat=" + city.getLat() + "&lon=" + city.getLon() + "&units=imperial&appid=" + apiKey;
        Weather weather = restTemplate.getForObject(weatherAPI, Weather.class);
        Main main = restTemplate.getForObject(weatherAPI, Main.class);
        System.out.println(city);
        System.out.println(weather.toString());
        System.out.println(main.toString());
    }
}
