package com.tomgregory.themepark;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RideStatusServiceTest {
    @ParameterizedTest(name = "{index} gets {0} ride status")
    @EnumSource(ThemeParkRide.class)
    public void getsRideStatus(ThemeParkRide ride) {
        RideStatusService rideStatusService = new RideStatusService();
        String rideStatus = rideStatusService.getRideStatus(ride);
        assertNotNull(rideStatus);
    }
}