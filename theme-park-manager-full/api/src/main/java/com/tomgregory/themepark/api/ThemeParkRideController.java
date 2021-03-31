package com.tomgregory.themepark.api;

import com.tomgregory.themepark.db.entity.ThemeParkRide;
import com.tomgregory.themepark.db.repository.ThemeParkRideRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@CrossOrigin(origins = "*")
public class ThemeParkRideController {

    private final ThemeParkRideRepository themeParkRideRepository;

    public ThemeParkRideController(ThemeParkRideRepository themeParkRideRepository) {

        this.themeParkRideRepository = themeParkRideRepository;
    }

    @GetMapping(path = "/rides")
    public Iterator<ThemeParkRide> getRides() {
        return themeParkRideRepository.findAll().iterator();
    }
}
