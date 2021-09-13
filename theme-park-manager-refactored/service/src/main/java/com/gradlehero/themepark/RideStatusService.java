package com.gradlehero.themepark;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RideStatusService {
    public static String getRideStatus(String ride) {
        Random random = new Random();
        String trimmedRideName = StringUtils.trim(ride);
        List<String> rideStatuses = readFile(String.format("%s.txt", trimmedRideName));
        return rideStatuses.get(random.nextInt(rideStatuses.size()));
    }

    private static List<String> readFile(String filename) {
        InputStream resourceStream = RideStatusService.class.getClassLoader().getResourceAsStream(filename);
        if (resourceStream == null) {
            throw new IllegalArgumentException("Ride not found");
        }

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
