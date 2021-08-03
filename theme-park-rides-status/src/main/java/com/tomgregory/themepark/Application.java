package com.tomgregory.themepark;

public class Application {
    public static void main(String[] args) {
        RideStatusService rideStatusService = new RideStatusService();

        if (args.length != 1) {
            System.out.println("A single ride name must be passed");
            System.exit(1);
        }

        String rideName = args[0];

        String rideStatus = rideStatusService.getRideStatus(ThemeParkRide.valueOf(rideName.toUpperCase()));

        System.out.println(String.format("Current status of %s is '%s'", rideName, rideStatus));
    }
}
