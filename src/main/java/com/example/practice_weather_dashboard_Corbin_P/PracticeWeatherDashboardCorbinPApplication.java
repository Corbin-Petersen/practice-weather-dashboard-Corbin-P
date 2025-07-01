package com.example.practice_weather_dashboard_Corbin_P;

import com.example.practice_weather_dashboard_Corbin_P.controllers.CityController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PracticeWeatherDashboardCorbinPApplication {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(PracticeWeatherDashboardCorbinPApplication.class, args);
		System.out.println("----------------------------------------");
		System.out.println(" Welcome to the Weather App for Console!");
		System.out.println("----------------------------------------");

		mainMenu();
	}

	public static void mainMenu() {
		while(true) {
			System.out.println("1. Current Weather by zip");
			System.out.println("2. View Current Weather Elsewhere");
			System.out.println("3. Exit");

			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				getZipCode();
			} else if (choice.equals("2")) {
				getCityAndState();
			} else if (choice.equals("3")) {
				break;
			} else {
				System.out.println("Invalid choice");
			}
		}
	}

	public static void getZipCode() {
		System.out.println("Please enter a zip code: ");
		int zipCode = scanner.nextInt();
		CityController.getWeatherByZip(zipCode);
	}

	public static void getCityAndState() {
		System.out.println("Please enter a city name: ");
		String cityName = scanner.nextLine();
		System.out.println("Please enter the state initials: ");
		String stateInit = scanner.nextLine();
		CityController.getWeatherByName(cityName, stateInit);
	}
}
