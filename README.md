# ✈️ Flight Data Processor

### Real-Time Aerial Surveying System

[![Java](https://img.shields.io/badge/Java-26-orange?style=flat-square&logo=java)](https://adoptium.net/)
[![Gradle](https://img.shields.io/badge/Gradle-9.7-blue?style=flat-square&logo=gradle)](https://gradle.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5.10-green?style=flat-square&logo=junit5)](https://junit.org/junit5/)
[![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)](LICENSE)

> A production-grade Java application that simulates concurrent aircraft missions, processes flight telemetry in real time, validates flight data, calculates statistics, and exports results to CSV.

---

## 📋 Overview

**Flight Data Processor** is a real-time flight simulation and data processing system designed for **aerial surveying applications**.

The application simulates multiple concurrent flights using realistic flight phases:

**TAKEOFF → CLIMB → CRUISE → DESCENT → LANDING**

During the mission, flight telemetry is continuously generated, processed, validated, logged, and summarized.

### 🎯 Built for

**Software Engineer – Aerial Surveying Systems**
---

## ✨ Key Features

| Feature | Description |
|---|---|
| ✈️ **Multi-Flight Simulation** | Runs 3+ concurrent flights with realistic behavior |
| 📈 **Realistic Flight Phases** | TAKEOFF → CLIMB → CRUISE → DESCENT → LANDING |
| 🔍 **Data Validation** | Validates altitude (0–60,000 ft) and speed (100–700 knots) |
| 💾 **CSV Export** | Saves flight telemetry for post-flight analysis |
| 📊 **Per-Flight Statistics** | Calculates detailed statistics for every flight |
| 🧪 **Unit Testing** | 9 JUnit tests with 100% pass rate |
| ⚙️ **Gradle Build** | Modern build automation and dependency management |
| 🏗️ **Clean Architecture** | Modular, testable, and maintainable design |

---

## 🏗️ Architecture

```text
┌─────────────────────────────────────────────────────────────┐
│                    FLIGHT DATA PROCESSOR                    │
│                   Real-Time Flight System                   │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│                         ┌───────────┐                       │
│                         │  MainApp  │                       │
│                         │Orchestrator│                      │
│                         └─────┬─────┘                       │
│                               │                             │
│              ┌────────────────┼────────────────┐            │
│              ▼                ▼                ▼            │
│        ┌───────────┐    ┌───────────┐    ┌───────────┐      │
│        │  AA101    │    │  UA202    │    │  DL303    │      │
│        │ Simulator │    │ Simulator │    │ Simulator │      │
│        └─────┬─────┘    └─────┬─────┘    └─────┬─────┘      │
│              └────────────────┼────────────────┘            │
│                               ▼                             │
│                    ┌──────────────────┐                     │
│                    │ FlightProcessor  │                     │
│                    │ Data Processing   │                     │
│                    └────────┬─────────┘                     │
│                             │                               │
│             ┌───────────────┼───────────────┐               │
│             ▼               ▼               ▼               │
│      ┌─────────────┐ ┌─────────────┐ ┌──────────────┐      │
│      │    Data     │ │    File     │ │  Validation  │      │
│      │  Validator  │ │   Logger    │ │   Summary    │      │
│      └─────────────┘ └─────────────┘ └──────────────┘      │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

### Component Responsibilities

| Component | Responsibility | Key Methods |
|---|---|---|
| **MainApp** | Orchestrates the complete system | `main()`, starts threads, manages shutdown |
| **FlightSimulator** | Simulates one flight and its phases | `run()`, `generateRealisticData()`, `advancePhase()` |
| **FlightProcessor** | Processes telemetry, stores history, calculates statistics | `processData()`, `getAverageAltitude()`, `printSummary()` |
| **FlightData** | POJO representing one telemetry data point | Getters, `toString()` |
| **DataValidator** | Validates flight data against realistic parameters | `validate()`, `printValidationSummary()` |
| **FileLogger** | Exports flight data to CSV | `logData()`, `close()` |

---

## 📁 Project Structure

```text
flight-data-processor/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── myproject/
│   │               └── flight/
│   │                   ├── FlightData.java
│   │                   ├── FlightSimulator.java
│   │                   ├── FlightProcessor.java
│   │                   ├── DataValidator.java
│   │                   ├── FileLogger.java
│   │                   └── MainApp.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── myproject/
│                   └── flight/
│                       ├── FlightDataTest.java
│                       ├── FlightSimulatorTest.java
│                       └── MainAppTest.java
│
├── build.gradle
├── settings.gradle
├── .gitignore
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

| Requirement | Version |
|---|---|
| **Java** | 26 or higher |
| **Gradle** | 9.7 or higher |
| **Git** | Latest version |

### 1. Clone the Repository

```bash
git clone https://github.com/rkumar49/flight-data-processor-Real-Time-Aerial-Surveying-System-with-Java-Multi-threading-and-Gradle-
cd flight-data-processor-Real-Time-Aerial-Surveying-System-with-Java-Multi-threading-and-Gradle-
```

### 2. Build the Project

```bash
gradle build
```

### 3. Run the Application

```bash
gradle run
```

---

## 📊 Sample Output

```text
========================================
     FLIGHT DATA PROCESSOR v1.0
     Aerial Surveying System
========================================

[LOGGER] Created file: flight_data_1234567890.csv

[SYSTEM] Starting 3 flights...
[STARTED] AA101
[STARTED] UA202
[STARTED] DL303

[SYSTEM] All flights started! Running for 30 seconds...

[PROCESSED] AA101 | Alt: 157 ft | Speed: 193 knots | Status: TAKEOFF | Total Records: 1
[PROCESSED] UA202 | Alt: 128 ft | Speed: 167 knots | Status: TAKEOFF | Total Records: 2
[PROCESSED] DL303 | Alt: 145 ft | Speed: 161 knots | Status: TAKEOFF | Total Records: 3

[PHASE] DL303 -> CLIMB
[PROCESSED] DL303 | Alt: 2789 ft | Speed: 294 knots | Status: CLIMB | Total Records: 20

[PHASE] AA101 -> CLIMB
[PROCESSED] AA101 | Alt: 2824 ft | Speed: 267 knots | Status: CLIMB | Total Records: 21

... (30 seconds of data) ...

[SYSTEM] Mission complete! Stopping all flights...

========================================
       FLIGHT DATA SUMMARY
========================================

Total Records     : 68
Average Altitude  : 14,820 ft
Average Speed     : 344 knots

========================================
       PER-FLIGHT STATISTICS
========================================

✈️ AA101
   Records     : 23
   Avg Alt     : 15,446 ft
   Alt Range   : 157 - 33,703 ft
   Avg Speed   : 350 knots
   Speed Range : 193 - 523 knots

✈️ UA202
   Records     : 21
   Avg Alt     : 13,506 ft
   Alt Range   : 128 - 33,960 ft
   Avg Speed   : 339 knots
   Speed Range : 167 - 528 knots

✈️ DL303
   Records     : 24
   Avg Alt     : 15,369 ft
   Alt Range   : 145 - 33,421 ft
   Avg Speed   : 342 knots
   Speed Range : 161 - 544 knots

========================================

========================================
       VALIDATION SUMMARY
========================================

Valid Records   : 68
Invalid Records : 0
Total Records   : 68

========================================

[LOGGER] Closed file: flight_data_1234567890.csv
[SYSTEM] Mission complete. Goodbye!
```

---

## 🧪 Testing

Run the complete test suite:

```bash
gradle test
```

For detailed Gradle output:

```bash
gradle test --info
```

### Test Results

```text
FlightDataTest > testFlightDataTimestamp() PASSED
FlightDataTest > testFlightDataWithLargeValues() PASSED
FlightDataTest > testFlightDataWithZeroValues() PASSED
FlightDataTest > testFlightDataCreation() PASSED
FlightDataTest > testFlightDataToString() PASSED

FlightSimulatorTest > testSimulatorCreation() PASSED
FlightSimulatorTest > testSimulatorStop() PASSED

MainAppTest > testMainAppStarts() PASSED
MainAppTest > testMainAppHasMainMethod() PASSED

BUILD SUCCESSFUL
```

**Result: 9/9 tests passed — 100% pass rate.**

---

## 📈 Sample CSV Output

The application exports flight telemetry in CSV format:

```csv
Timestamp,FlightId,Altitude,Speed,Status,RecordTime
2026-09-01T12:34:56.789,AA101,157,193,TAKEOFF,1788314128757
2026-09-01T12:34:57.123,UA202,128,167,TAKEOFF,1788314128758
2026-09-01T12:34:57.456,DL303,145,161,TAKEOFF,1788314128759
2026-09-01T12:34:58.789,DL303,327,213,TAKEOFF,1788314128760
2026-09-01T12:34:59.123,AA101,290,231,TAKEOFF,1788314128761
2026-09-01T12:34:59.456,UA202,276,238,TAKEOFF,1788314128762
```

---

## 🛠️ Commands Reference

| Command | Description |
|---|---|
| `gradle build` | Compile the project and run tests |
| `gradle run` | Run the flight simulator |
| `gradle test` | Run all unit tests |
| `gradle clean` | Clean the build directory |
| `gradle build --refresh-dependencies` | Refresh Gradle dependencies |
| `gradle test --info` | Run tests with detailed output |

---

## 💡 Skills Demonstrated

| Skill | Evidence |
|---|---|
| **Java SE** | Complete Java application using OOP principles |
| **Multi-threading** | 3 concurrent flights with synchronized processing |
| **Real-time Processing** | 30-second mission with real-time data flow |
| **Data Validation** | Comprehensive telemetry validation and summary |
| **File I/O** | CSV export with timestamps |
| **Gradle** | Build automation and dependency management |
| **JUnit** | 9 unit tests with 100% pass rate |
| **Aerospace Domain** | Realistic flight phases and flight parameters |
| **System Design** | Modular, testable, maintainable architecture |
| **Clean Code** | Well-organized, documented, production-ready implementation |

---

## 🎯 Future Enhancements

| Feature | Status | Description |
|---|---|---|
| JSON Export | 🔜 Planned | Export flight data as JSON |
| HTML Report | 🔜 Planned | Generate a formatted HTML report |
| Configuration File | 🔜 Planned | Load settings from `config.properties` |
| Real-Time Dashboard | 🔜 Planned | Add a text-based cockpit display |
| Performance Metrics | 🔜 Planned | Track data rate and memory usage |

---

## 📝 License

This project is licensed under the **MIT License**.

See the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Project

**Flight Data Processor — Real-Time Aerial Surveying System**

Built with **Java 26**, **Gradle 9.7**, **JUnit 5**, and Java multi-threading.
