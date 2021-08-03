package com.tomgregory.themepark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RideStatusService {

    private static final Map<ThemeParkRide, List<String>> possibleRideStatuses = new HashMap<>();

    public RideStatusService() {
        possibleRideStatuses.put(ThemeParkRide.ROLLERCOASTER, readFile("rollercoaster.txt"));
        possibleRideStatuses.put(ThemeParkRide.LOGFLUME, readFile("logflume.txt"));
        possibleRideStatuses.put(ThemeParkRide.TEACUPS, readFile("teacups.txt"));
    }

    public String getRideStatus(ThemeParkRide ride) {
        Random random = new Random();
        List<String> rideStatuses = possibleRideStatuses.get(ride);
        return rideStatuses.get(random.nextInt(rideStatuses.size()));
    }

    private List<String> readFile(String filename) {
        InputStream resourceStream = RideStatusService.class.getClassLoader().getResourceAsStream(filename);
        assert resourceStream != null;

        List<String> result = new ArrayList<>();
        try (BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(resourceStream, StandardCharsets.UTF_8))) {
            while (bufferedInputStream.ready()) {
                result.add(bufferedInputStream.readLine());
            }
        } catch (IOException exception) {
            throw new RuntimeException("Couldn't read file", exception);
        }

        return result;
    }
}
