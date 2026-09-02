package com.myproject.flight;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     FLIGHT DATA PROCESSOR v1.0");
        System.out.println("     Aerial Surveying System");
        System.out.println("========================================\n");
        
        // Create components
        FileLogger logger = new FileLogger("flight_data_" + System.currentTimeMillis() + ".csv");
        DataValidator validator = new DataValidator();
        FlightProcessor processor = new FlightProcessor(logger, validator);
        
        List<Thread> flightThreads = new ArrayList<>();
        List<FlightSimulator> flights = new ArrayList<>();
        
        String[] flightIds = {"AA101", "UA202", "DL303"};
        
        System.out.println("[SYSTEM] Starting " + flightIds.length + " flights...");
        
        for (String id : flightIds) {
            FlightSimulator simulator = new FlightSimulator(id, processor);
            flights.add(simulator);
            
            Thread thread = new Thread(simulator);
            flightThreads.add(thread);
            thread.start();
        }
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n[SYSTEM] All flights started! Running for 30 seconds...\n");
        
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n[SYSTEM] Mission complete! Stopping all flights...");
        for (FlightSimulator flight : flights) {
            flight.stop();
        }
        
        for (Thread thread : flightThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Print final reports
        processor.printSummary();
        validator.printValidationSummary();
        
        logger.close();
        
        System.out.println("[SYSTEM] Mission complete. Goodbye!");
    }
}