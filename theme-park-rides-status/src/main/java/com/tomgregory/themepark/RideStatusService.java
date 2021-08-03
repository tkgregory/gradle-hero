package com.tomgregory.themepark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RideStatusService {
    private static final Map<String, List<String>> possibleRideStatuses = new HashMap<>();

    public RideStatusService() {
        possibleRideStatuses.put("rollercoaster", readFile("rollercoaster.txt"));
        possibleRideStatuses.put("logflume", readFile("logflume.txt"));
        possibleRideStatuses.put("teacups", readFile("teacups.txt"));
    }

    public static void main(String[] args) {
        RideStatusService rideStatusService = new RideStatusService();

        if (args.length != 1) {
            System.out.println("A single ride name must be passed");
            System.exit(1);
        }
        String rideName = args[0];
        String rideStatus = rideStatusService.getRideStatus(rideName);

        System.out.printf("Current status of %s is '%s'%n", rideName, rideStatus);
    }

    public String getRideStatus(String ride) {
        Random random = new Random();
        if (!possibleRideStatuses.containsKey(ride)) {
            throw new IllegalArgumentException(String.format("Ride %s not found", ride));
        }
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
