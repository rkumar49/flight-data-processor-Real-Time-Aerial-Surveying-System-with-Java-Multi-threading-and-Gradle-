package com.myproject.flight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlightDataTest {
    
    @Test
    void testFlightDataCreation() {
        // Create a flight data object
        FlightData data = new FlightData("AA101", 35000, 550, "CRUISE");
        
        // Check that everything was set correctly
        assertEquals("AA101", data.getFlightId());      // Should be "AA101"
        assertEquals(35000, data.getAltitude());        // Should be 35000
        assertEquals(550, data.getSpeed());             // Should be 550
        assertEquals("CRUISE", data.getStatus());       // Should be "CRUISE"
        assertTrue(data.getTimestamp() > 0);            // Should be > 0
    }
    
    @Test
    void testFlightDataToString() {
        FlightData data = new FlightData("UA202", 10000, 300, "TAKEOFF");
        String output = data.toString();
        
        // Check that the output contains all the info
        assertTrue(output.contains("UA202"));
        assertTrue(output.contains("TAKEOFF"));
    }
       @Test
    void testFlightDataWithZeroValues() {
        // Test with zero values
        FlightData data = new FlightData("TEST", 0, 0, "GROUND");
        
        assertEquals("TEST", data.getFlightId());
        assertEquals(0, data.getAltitude());
        assertEquals(0, data.getSpeed());
        assertEquals("GROUND", data.getStatus());
    }
    
    @Test
    void testFlightDataWithLargeValues() {
        // Test with large values
        FlightData data = new FlightData("TEST", 99999, 999, "MAX");
        
        assertEquals(99999, data.getAltitude());
        assertEquals(999, data.getSpeed());
    }
    

    @Test
    void testFlightDataTimestamp() {
        // Create two objects and check timestamps
        FlightData data1 = new FlightData("TEST1", 1000, 100, "TEST");
        
        // Wait a tiny bit
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        FlightData data2 = new FlightData("TEST2", 2000, 200, "TEST");
        
        // Check that timestamps are different (time passed)
        assertTrue(data2.getTimestamp() > data1.getTimestamp());
    }
}