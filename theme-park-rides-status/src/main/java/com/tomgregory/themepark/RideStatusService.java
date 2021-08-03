package com.tomgregory.themepark;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.util.Arrays.asList;

public class RideStatusService {

    private Map<ThemeParkRide, List<String>> possibleRideStatuses = new HashMap<>();

    private List<String> rollercoasterStatuses = asList("at the station", "climbing to the top", "on the precipice", "generating screams");
    private List<String> logFlumeStatuses = asList("at the station", "climbing to the top", "on the precipice", "soaking passengers");
    private List<String> teacupStatuses = asList("not spinning", "spinning", "super-spin vomit mode");

    public RideStatusService() {
        possibleRideStatuses.put(ThemeParkRide.ROLLERCOASTER, rollercoasterStatuses);
        possibleRideStatuses.put(ThemeParkRide.LOGFLUME, logFlumeStatuses);
        possibleRideStatuses.put(ThemeParkRide.TEACUPS, teacupStatuses);
    }

    public String getRideStatus(ThemeParkRide ride) {
        Random random = new Random();
        List<String> rideStatuses = possibleRideStatuses.get(ride);
        return rideStatuses.get(random.nextInt(rideStatuses.size()));
    }
}
