package com.tomgregory.themepark;

import com.gradlehero.themepark.RideStatusService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Iterator;

@RestController
@CrossOrigin(origins = "*")
public class ThemeParkRideController {
    @GetMapping(path = "/rides")
    public Iterator<ThemeParkRide> getRides() {
        return Arrays.asList(
                new ThemeParkRide("Rollercoaster", "Train ride that speeds you along.", RideStatusService.getRideStatus("rollercoaster"), "images/rollercoaster.jpg"),
                new ThemeParkRide("Log flume", "Boat ride with plenty of splashes.", RideStatusService.getRideStatus("logflume"), "images/logflume.jpg"),
                new ThemeParkRide("Teacups", "Spinning ride in a giant tea-cup.", RideStatusService.getRideStatus("teacups"), "images/teacups.jpg")
        ).iterator();
    }
}
