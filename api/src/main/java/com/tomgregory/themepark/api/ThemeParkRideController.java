package com.tomgregory.themepark.api;

import com.tomgregory.themepark.db.entity.ThemeParkRide;
import com.tomgregory.themepark.db.repository.ThemeParkRideRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThemeParkRideController {

    private final ThemeParkRideRepository themeParkRideRepository;

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {

        this.themeParkRideRepository = themeParkRideRepository;
    }

    @GetMapping(path = "/rides")
    public List<ThemeParkRide> getRides() {
return null;
//        return themeParkRideRepository.findAll();
    }
}
