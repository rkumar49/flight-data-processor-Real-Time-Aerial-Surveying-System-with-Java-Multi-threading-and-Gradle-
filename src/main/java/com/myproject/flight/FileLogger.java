package com.myproject.flight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private String filename;
    private PrintWriter writer;
    
    public FileLogger(String filename) {
        this.filename = filename;
        try {
            // Create file with header
            writer = new PrintWriter(new FileWriter(filename));
            writer.println("Timestamp,FlightId,Altitude,Speed,Status,RecordTime");
            writer.flush();
            System.out.println("[LOGGER] Created file: " + filename);
        } catch (IOException e) {
            System.err.println("[ERROR] Could not create log file: " + e.getMessage());
        }
    }
    
    public void logData(FlightData data) {
        if (writer == null) return;
        
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        writer.printf("%s,%s,%.0f,%.0f,%s,%d%n",
            timestamp,
            data.getFlightId(),
            data.getAltitude(),
            data.getSpeed(),
            data.getStatus(),
            data.getTimestamp()
        );
        writer.flush(); // Write immediately (real-time logging)
    }
    
    public void close() {
        if (writer != null) {
            writer.close();
            System.out.println("[LOGGER] Closed file: " + filename);
        }
    }
}