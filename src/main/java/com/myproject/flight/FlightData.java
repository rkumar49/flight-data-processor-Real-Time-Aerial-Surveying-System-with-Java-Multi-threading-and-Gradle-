package com.myproject.flight;

public class FlightData {
    private String flightId;
    private double altitude;
    private double speed;
    private String status;
    private long timestamp;
    
    public FlightData(String flightId, double altitude, double speed, String status) {
        this.flightId = flightId;
        this.altitude = altitude;
        this.speed = speed;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }
    
    public String getFlightId() { return flightId; }
    public double getAltitude() { return altitude; }
    public double getSpeed() { return speed; }
    public String getStatus() { return status; }
    public long getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        return String.format("Flight %s | Alt: %.0f ft | Speed: %.0f knots | Status: %s | Time: %d",
                flightId, altitude, speed, status, timestamp);
    }
}