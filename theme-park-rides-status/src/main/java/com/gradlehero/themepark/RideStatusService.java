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
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("A single ride name must be passed");
            System.exit(1);
        }

        String rideName = args[0];
        Pair<String, String> rideStatus = getRideStatus(rideName);

        System.out.printf("Current status of %s is '%s'%n", rideStatus.getLeft(), rideStatus.getRight());
    }

    public static Pair<String, String> getRideStatus(String ride) {
        Random random = new Random();
        String trimmedRideName = StringUtils.trim(ride);
        List<String> rideStatuses = readFile(String.format("%s.txt", trimmedRideName));
        return ImmutablePair.of(trimmedRideName, rideStatuses.get(random.nextInt(rideStatuses.size())));
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
