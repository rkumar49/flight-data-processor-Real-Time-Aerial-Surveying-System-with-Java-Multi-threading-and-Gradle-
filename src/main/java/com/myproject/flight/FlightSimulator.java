package com.myproject.flight;

import java.util.Random;

public class FlightSimulator implements Runnable {
    private String flightId;
    private boolean isRunning = true;
    private Random random = new Random();
    private FlightProcessor processor;
    private int recordCount = 0;
    
    // Flight phase tracking
    private enum Phase { TAKEOFF, CLIMB, CRUISE, DESCENT, LANDING }
    private Phase currentPhase = Phase.TAKEOFF;
    private double currentAltitude = 0;
    private double currentSpeed = 0;
    private int phaseStep = 0;
    
    public FlightSimulator(String flightId, FlightProcessor processor) {
        this.flightId = flightId;
        this.processor = processor;
    }
    
    @Override
    public void run() {
        System.out.println("[STARTED] " + flightId);
        
        while (isRunning) {
            try {
                // Generate realistic flight data
                FlightData data = generateRealisticData();
                
                if (processor != null) {
                    processor.processData(data);
                    recordCount++;
                }
                
                Thread.sleep(800 + random.nextInt(1200)); // 0.8-2.0 seconds
                
            } catch (InterruptedException e) {
                System.out.println("[STOPPED] " + flightId + " (sent " + recordCount + " records)");
                break;
            }
        }
    }
    
    private FlightData generateRealisticData() {
        phaseStep++;
        
        // Advance phase every 5-8 steps
        if (phaseStep > 5 + random.nextInt(4)) {
            advancePhase();
            phaseStep = 0;
        }
        
        // Generate realistic values based on phase
        switch (currentPhase) {
            case TAKEOFF:
                currentAltitude = 100 + (currentAltitude * 0.2) + random.nextInt(200);
                currentSpeed = 150 + (currentSpeed * 0.3) + random.nextInt(50);
                break;
            case CLIMB:
                currentAltitude += 1500 + random.nextInt(2000);
                currentSpeed = 250 + random.nextInt(100);
                break;
            case CRUISE:
                currentAltitude = 30000 + random.nextInt(8000) - 4000;
                currentSpeed = 450 + random.nextInt(100);
                break;
            case DESCENT:
                currentAltitude -= 1500 + random.nextInt(2000);
                currentSpeed = 300 + random.nextInt(100);
                break;
            case LANDING:
                currentAltitude = Math.max(0, currentAltitude - 200 - random.nextInt(300));
                currentSpeed = Math.max(100, currentSpeed - 20 - random.nextInt(30));
                break;
        }
        
        // Clamp values to realistic ranges
        currentAltitude = Math.max(0, Math.min(45000, currentAltitude));
        currentSpeed = Math.max(100, Math.min(600, currentSpeed));
        
        String status = currentPhase.toString();
        return new FlightData(flightId, currentAltitude, currentSpeed, status);
    }
    
    private void advancePhase() {
        Phase[] phases = Phase.values();
        int nextIndex = (currentPhase.ordinal() + 1) % phases.length;
        currentPhase = phases[nextIndex];
        
        System.out.println("[PHASE] " + flightId + " -> " + currentPhase);
    }
    
    public void stop() {
        isRunning = false;
    }
}