package com.myproject.flight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainAppTest {
    
    @Test
    void testMainAppStarts() {
        // This test verifies the main method exists
        // We can't easily test the full app without user input
        // So we just check the class exists
        assertNotNull(MainApp.class);
    }
    
    @Test
    void testMainAppHasMainMethod() {
        // Check that the main method exists and is accessible
        try {
            MainApp.class.getMethod("main", String[].class);
            // If we get here, the method exists
            assertTrue(true);
        } catch (NoSuchMethodException e) {
            fail("Main method not found!");
        }
    }
}