package com.myproject.flight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FlightSimulatorTest {
    
    @Test
    void testSimulatorCreation() {
        // Create a simulator
        FlightSimulator simulator = new FlightSimulator("TEST123");
        
        // Check that it was created with correct flight ID
        assertNotNull(simulator);  // Should not be null
        
        // We can't directly test private fields, but we can run it briefly
        // This test just verifies the simulator can be created
    }
    
    @Test
    void testSimulatorStop() {
        // Create and start a simulator
        FlightSimulator simulator = new FlightSimulator("TEST456");
        Thread thread = new Thread(simulator);
        thread.start();
        
        // Let it run for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Stop the simulator
        simulator.stop();
        
        // Wait for thread to finish
        try {
            thread.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Check if thread is no longer alive
        assertFalse(thread.isAlive());
    }
}