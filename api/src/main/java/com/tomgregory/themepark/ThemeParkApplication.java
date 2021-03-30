package com.tomgregory.themepark;

import com.tomgregory.themepark.db.entity.ThemeParkRide;
import com.tomgregory.themepark.db.repository.ThemeParkRideRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThemeParkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThemeParkApplication.class);
    }

    @Bean
    public CommandLineRunner sampleData(ThemeParkRideRepository repository) {
        return (args) -> {
            repository.save(new ThemeParkRide("Rollercoaster", "Train ride that speeds you along.", "images/rollercoaster.jpg"));
            repository.save(new ThemeParkRide("Log flume", "Boat ride with plenty of splashes.", "images/log-flume.jpg"));
            repository.save(new ThemeParkRide("Teacups", "Spinning ride in a giant tea-cup.", "images/teacups.jpg"));
        };
    }
}
