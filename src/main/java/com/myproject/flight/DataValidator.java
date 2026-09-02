package com.myproject.flight;

import java.util.ArrayList;
import java.util.List;

public class DataValidator {
    private List<String> errors = new ArrayList<>();
    private List<String> warnings = new ArrayList<>();
    private int validCount = 0;
    private int invalidCount = 0;
    
    public boolean validate(FlightData data) {
        errors.clear();
        warnings.clear();
        boolean isValid = true;
        
        // Check flight ID
        if (data.getFlightId() == null || data.getFlightId().isEmpty()) {
            errors.add("Flight ID is null or empty");
            isValid = false;
        }
        
        // Check altitude (0 to 60,000 ft)
        if (data.getAltitude() < 0) {
            errors.add("Altitude cannot be negative: " + data.getAltitude());
            isValid = false;
        } else if (data.getAltitude() > 60000) {
            warnings.add("Altitude exceeds maximum (60,000 ft): " + data.getAltitude());
        }
        
        // Check speed (100 to 700 knots)
        if (data.getSpeed() < 0) {
            errors.add("Speed cannot be negative: " + data.getSpeed());
            isValid = false;
        } else if (data.getSpeed() < 100) {
            warnings.add("Speed below minimum (100 knots): " + data.getSpeed());
        } else if (data.getSpeed() > 700) {
            warnings.add("Speed exceeds maximum (700 knots): " + data.getSpeed());
        }
        
        // Check status
        if (data.getStatus() == null || data.getStatus().isEmpty()) {
            errors.add("Status is null or empty");
            isValid = false;
        }
        
        // Check timestamp
        if (data.getTimestamp() <= 0) {
            errors.add("Invalid timestamp: " + data.getTimestamp());
            isValid = false;
        }
        
        if (isValid) {
            validCount++;
        } else {
            invalidCount++;
        }
        
        return isValid;
    }
    
    public void printValidationSummary() {
        System.out.println("\n========================================");
        System.out.println("        VALIDATION SUMMARY");
        System.out.println("========================================");
        System.out.println("Valid Records   : " + validCount);
        System.out.println("Invalid Records : " + invalidCount);
        System.out.println("Total Records   : " + (validCount + invalidCount));
        
        if (!errors.isEmpty()) {
            System.out.println("\n❌ ERRORS:");
            for (String error : errors) {
                System.out.println("  - " + error);
            }
        }
        
        if (!warnings.isEmpty()) {
            System.out.println("\n⚠️ WARNINGS:");
            for (String warning : warnings) {
                System.out.println("  - " + warning);
            }
        }
        System.out.println("========================================\n");
    }
}