package com.gradlehero.themepark;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RideStatusServiceTest {
    @ParameterizedTest(name = "{index} gets {0} ride status")
    @ValueSource(strings = {"rollercoaster", "logflume", "teacups"})
    public void getsRideStatus(String ride) {
        String rideStatus = RideStatusService.getRideStatus(ride);
        assertNotNull(rideStatus);
    }

    @Test
    public void unknownRideCausesFailure() {
        assertThrows(IllegalArgumentException.class, () -> RideStatusService.getRideStatus("dodgems"));
    }
}