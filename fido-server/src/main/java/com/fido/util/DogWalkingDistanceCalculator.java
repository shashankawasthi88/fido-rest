package com.fido.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DogWalkingDistanceCalculator {

    // Represents a GPS coordinate with timestamp
    public static class GPSPoint {
        double latitude;
        double longitude;
        LocalDateTime timestamp;

        public GPSPoint(double lat, double lon, String timestampStr) {
            this.latitude = lat;
            this.longitude = lon;
            this.timestamp = LocalDateTime.parse(timestampStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }

    // Haversine formula to calculate distance between two GPS points in meters
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371000; // Radius of the Earth in meters
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                 + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                 * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }

    public static double calculateTotalWalkedDistance(List<GPSPoint> points, double vehicleSpeedThresholdKmph) {
        double totalDistance = 0.0;

        for (int i = 1; i < points.size(); i++) {
            GPSPoint p1 = points.get(i - 1);
            GPSPoint p2 = points.get(i);

            double distance = haversine(p1.latitude, p1.longitude, p2.latitude, p2.longitude); // in meters
            long timeDiffSeconds = Duration.between(p1.timestamp, p2.timestamp).getSeconds();

            if (timeDiffSeconds <= 0) continue;

            double speedMps = distance / timeDiffSeconds;
            double speedKmph = speedMps * 3.6;

            if (speedKmph <= vehicleSpeedThresholdKmph) {
                totalDistance += distance;
            }
        }

        return totalDistance;
    }
}
