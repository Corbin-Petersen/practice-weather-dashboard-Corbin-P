package com.example.practice_weather_dashboard_Corbin_P.repositories;

import com.example.practice_weather_dashboard_Corbin_P.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
