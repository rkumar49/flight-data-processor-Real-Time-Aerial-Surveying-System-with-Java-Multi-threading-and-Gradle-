package com.myproject.flight;

import java.util.ArrayList;
import java.util.List;

public class FlightProcessor {
    private List<FlightData> dataHistory = new ArrayList<>();
    private FileLogger logger;
    private DataValidator validator;
    
    // Constructor with logger and validator
    public FlightProcessor(FileLogger logger, DataValidator validator) {
        this.logger = logger;
        this.validator = validator;
    }
    
    // Default constructor (for backward compatibility)
    public FlightProcessor() {
        this(null, null);
    }
    
    // Constructor with just logger
    public FlightProcessor(FileLogger logger) {
        this(logger, null);
    }
    
    /**
     * Process a new data point
     * Validates data, logs to file, and stores in history
     */
    public synchronized void processData(FlightData data) {
        if (data == null) {
            System.out.println("[ERROR] Received null data!");
            return;
        }
        
        // Validate data
        if (validator != null && !validator.validate(data)) {
            System.out.println("[REJECTED] Invalid data for " + data.getFlightId());
            return;
        }
        
        // Add to history
        dataHistory.add(data);
        
        // Log to file
        if (logger != null) {
            logger.logData(data);
        }
        
        // Display processing info
        System.out.println("[PROCESSED] " + data.getFlightId() + 
                          " | Alt: " + String.format("%.0f", data.getAltitude()) +
                          " ft | Speed: " + String.format("%.0f", data.getSpeed()) +
                          " knots | Status: " + data.getStatus() +
                          " | Total Records: " + dataHistory.size());
    }
    
    /**
     * Calculate average altitude of all flights
     */
    public synchronized double getAverageAltitude() {
        if (dataHistory.isEmpty()) {
            return 0;
        }
        double sum = 0;
        int count = 0;
        for (FlightData d : dataHistory) {
            if (d != null) {
                sum += d.getAltitude();
                count++;
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }
    
    /**
     * Calculate average speed of all flights
     */
    public synchronized double getAverageSpeed() {
        if (dataHistory.isEmpty()) {
            return 0;
        }
        double sum = 0;
        int count = 0;
        for (FlightData d : dataHistory) {
            if (d != null) {
                sum += d.getSpeed();
                count++;
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }
    
    /**
     * Get total number of records
     */
    public synchronized int getTotalRecords() {
        return dataHistory.size();
    }
    
    /**
     * Get all data for a specific flight
     */
    public synchronized List<FlightData> getFlightHistory(String flightId) {
        List<FlightData> result = new ArrayList<>();
        for (FlightData d : dataHistory) {
            if (d != null && d.getFlightId().equals(flightId)) {
                result.add(d);
            }
        }
        return result;
    }
    
    /**
     * Get all data history
     */
    public synchronized List<FlightData> getAllData() {
        return new ArrayList<>(dataHistory);
    }
    
    /**
     * Get statistics per flight
     */
    public synchronized void printPerFlightStats() {
        System.out.println("\n========================================");
        System.out.println("        PER-FLIGHT STATISTICS");
        System.out.println("========================================");
        
        // Get unique flight IDs
        List<String> flightIds = new ArrayList<>();
        for (FlightData d : dataHistory) {
            if (d != null && !flightIds.contains(d.getFlightId())) {
                flightIds.add(d.getFlightId());
            }
        }
        
        for (String id : flightIds) {
            List<FlightData> flightData = getFlightHistory(id);
            if (flightData.isEmpty()) continue;
            
            double sumAlt = 0, sumSpeed = 0;
            int minAlt = Integer.MAX_VALUE, maxAlt = 0;
            int minSpeed = Integer.MAX_VALUE, maxSpeed = 0;
            
            for (FlightData d : flightData) {
                sumAlt += d.getAltitude();
                sumSpeed += d.getSpeed();
                minAlt = (int) Math.min(minAlt, d.getAltitude());
                maxAlt = (int) Math.max(maxAlt, d.getAltitude());
                minSpeed = (int) Math.min(minSpeed, d.getSpeed());
                maxSpeed = (int) Math.max(maxSpeed, d.getSpeed());
            }
            
            System.out.println("\n✈️ " + id);
            System.out.println("  Records     : " + flightData.size());
            System.out.println("  Avg Alt     : " + String.format("%.0f", sumAlt / flightData.size()) + " ft");
            System.out.println("  Alt Range   : " + minAlt + " - " + maxAlt + " ft");
            System.out.println("  Avg Speed   : " + String.format("%.0f", sumSpeed / flightData.size()) + " knots");
            System.out.println("  Speed Range : " + minSpeed + " - " + maxSpeed + " knots");
        }
        System.out.println("========================================\n");
    }
    
    /**
     * Print summary of all data
     */
    public synchronized void printSummary() {
        System.out.println("\n========================================");
        System.out.println("        FLIGHT DATA SUMMARY");
        System.out.println("========================================");
        System.out.println("Total Records     : " + getTotalRecords());
        System.out.println("Average Altitude  : " + String.format("%.0f", getAverageAltitude()) + " ft");
        System.out.println("Average Speed     : " + String.format("%.0f", getAverageSpeed()) + " knots");
        System.out.println("========================================\n");
        
        // Print per-flight stats
        printPerFlightStats();
    }
    
    /**
     * Clear all data
     */
    public synchronized void clearData() {
        dataHistory.clear();
        System.out.println("[CLEARED] All data removed from memory");
    }
}