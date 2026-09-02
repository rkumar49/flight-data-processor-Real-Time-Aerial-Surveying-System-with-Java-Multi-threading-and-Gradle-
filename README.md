\# ✈️ Flight Data Processor

\### Real-Time Aerial Surveying System



\[!\[Java](https://img.shields.io/badge/Java-26-orange.svg)](https://adoptium.net/)

\[!\[Gradle](https://img.shields.io/badge/Gradle-9.7-blue.svg)](https://gradle.org/)

\[!\[JUnit](https://img.shields.io/badge/JUnit-5.10-green.svg)](https://junit.org/junit5/)

\[!\[License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)



\---



\## 📋 Overview



\*\*Flight Data Processor\*\* is a real-time flight simulation and data processing system designed for aerial surveying applications. It simulates multiple concurrent flights with realistic flight phases, validates all data, exports to CSV, and provides comprehensive statistics.



\### 🎯 Key Features



\- ✈️ \*\*Multi-Flight Simulation\*\* - Run 3+ concurrent flights with realistic behavior

\- 📈 \*\*Realistic Flight Phases\*\* - TAKEOFF → CLIMB → CRUISE → DESCENT → LANDING

\- 🔍 \*\*Data Validation\*\* - Automatic validation of altitude, speed, and status

\- 💾 \*\*CSV Export\*\* - All data saved to CSV for post-flight analysis

\- 📊 \*\*Per-Flight Statistics\*\* - Detailed stats for each individual flight

\- 🧪 \*\*Unit Testing\*\* - 9 passing JUnit tests

\- ⚙️ \*\*Gradle Build\*\* - Modern build automation



\---



\## 🏗️ Architecture



┌─────────────────────────────────────────────────────────────────┐

│ FLIGHT DATA PROCESSOR │

├─────────────────────────────────────────────────────────────────┤

│ │

│ ┌──────────────┐ ┌──────────────┐ ┌──────────────┐ │

│ │ MainApp │───▶│ Flight │ │ Data │ │

│ │ (Orchestrator) │ Simulator │ │ Validator │ │

│ └──────────────┘ └──────┬───────┘ └──────┬───────┘ │

│ │ │ │ │

│ │ ▼ ▼ │

│ │ ┌──────────────┐ ┌──────────────┐ │

│ └──────────▶│ Flight │ │ File │ │

│ │ Processor │───▶│ Logger │ │

│ └──────┬───────┘ └──────────────┘ │

│ │ │

│ ▼ │

│ ┌──────────────┐ │

│ │ Flight │ │

│ │ Data │ │

│ │ (POJO) │ │

│ └──────────────┘ │

│ │

└─────────────────────────────────────────────────────────────────┘





\### Component Breakdown



| Component | Responsibility |

|-----------|---------------|

| \*\*MainApp\*\* | Orchestrates the entire system - starts flights, manages threads, handles shutdown |

| \*\*FlightSimulator\*\* | Simulates one flight with realistic phases (TAKEOFF → CLIMB → CRUISE → DESCENT → LANDING) |

| \*\*FlightProcessor\*\* | Processes data, stores history, calculates statistics |

| \*\*FlightData\*\* | POJO representing one flight data point (ID, altitude, speed, status, timestamp) |

| \*\*DataValidator\*\* | Validates all data against realistic parameters (altitude 0-60,000 ft, speed 100-700 knots) |

| \*\*FileLogger\*\* | Exports all data to CSV files with timestamps |



\---



\## 📁 Project Structure



flight-data-processor/

├── src/

│ ├── main/

│ │ └── java/

│ │ └── com/

│ │ └── myproject/

│ │ └── flight/

│ │ ├── FlightData.java # Data POJO

│ │ ├── FlightSimulator.java # Flight simulation

│ │ ├── FlightProcessor.java # Data processing

│ │ ├── DataValidator.java # Validation

│ │ ├── FileLogger.java # CSV export

│ │ └── MainApp.java # Application entry point

│ └── test/

│ └── java/

│ └── com/

│ └── myproject/

│ └── flight/

│ ├── FlightDataTest.java # 5 tests

│ ├── FlightSimulatorTest.java # 2 tests

│ └── MainAppTest.java # 2 tests

├── build.gradle # Gradle build configuration

├── settings.gradle # Project settings

├── .gitignore # Git ignore rules

└── README.md # This file



\## 🚀 Getting Started



\### Prerequisites



\- \*\*Java 26\*\* or higher

\- \*\*Gradle 9.7\*\* or higher



\### Installation



1\. \*\*Clone the repository\*\*

&#x20;  ```bash

&#x20;  git clone https://github.com/yourusername/flight-data-processor.git

&#x20;  cd flight-data-processor

Build the project



bash

gradle build

Run the application



bash

gradle run

What Happens When You Run

text

========================================

&#x20;    FLIGHT DATA PROCESSOR v1.0

&#x20;    Aerial Surveying System

========================================



\[LOGGER] Created file: flight\_data\_1234567890.csv

\[SYSTEM] Starting 3 flights...

\[STARTED] AA101

\[STARTED] UA202

\[STARTED] DL303



\[SYSTEM] All flights started! Running for 30 seconds...



... (Real-time flight data flowing) ...



\[SYSTEM] Mission complete! Stopping all flights...



========================================

&#x20;       FLIGHT DATA SUMMARY

========================================

Total Records     : 68

Average Altitude  : 14,820 ft

Average Speed     : 344 knots

========================================



========================================

&#x20;       PER-FLIGHT STATISTICS

========================================



✈️ AA101

&#x20; Records     : 23

&#x20; Avg Alt     : 15,446 ft

&#x20; Alt Range   : 157 - 33,703 ft

&#x20; Avg Speed   : 350 knots

&#x20; Speed Range : 193 - 523 knots



... (More stats for each flight) ...



========================================

&#x20;       VALIDATION SUMMARY

========================================

Valid Records   : 68

Invalid Records : 0

Total Records   : 68

========================================



\[LOGGER] Closed file: flight\_data\_1234567890.csv

\[SYSTEM] Mission complete. Goodbye!





📊 Data Flow

text

┌─────────────────────────────────────────────────────────────────────────────┐

│                           DATA FLOW DIAGRAM                                │

├─────────────────────────────────────────────────────────────────────────────┤

│                                                                             │

│  1. MainApp starts 3 FlightSimulator threads                               │

│         │                                                                   │

│         ▼                                                                   │

│  2. Each FlightSimulator generates realistic flight data                   │

│     (TAKEOFF → CLIMB → CRUISE → DESCENT → LANDING)                       │

│         │                                                                   │

│         ▼                                                                   │

│  3. Data is sent to FlightProcessor for processing                        │

│         │                                                                   │

│         ▼                                                                   │

│  4. DataValidator checks:                                                  │

│     - Altitude: 0 - 60,000 ft                                             │

│     - Speed: 100 - 700 knots                                              │

│     - Status: Must be valid                                               │

│     - Timestamp: Must be > 0                                              │

│         │                                                                   │

│         ▼                                                                   │

│  5. If valid:                                                              │

│     - Stored in memory (dataHistory)                                      │

│     - Written to CSV file (FileLogger)                                    │

│     - Statistics updated                                                  │

│         │                                                                   │

│         ▼                                                                   │

│  6. After 30 seconds:                                                      │

│     - All flights stop                                                    │

│     - Summary printed                                                     │

│     - Per-flight stats printed                                            │

│     - Validation summary printed                                          │

│     - CSV file closed                                                     │

│                                                                             │

└─────────────────────────────────────────────────────────────────────────────┘



🧪 Testing

Run all tests:



bash

gradle test

Test Results (9/9 Passing):



text

FlightDataTest > testFlightDataTimestamp() PASSED

FlightDataTest > testFlightDataWithLargeValues() PASSED

FlightDataTest > testFlightDataWithZeroValues() PASSED

FlightDataTest > testFlightDataCreation() PASSED

FlightDataTest > testFlightDataToString() PASSED

FlightSimulatorTest > testSimulatorCreation() PASSED

FlightSimulatorTest > testSimulatorStop() PASSED

MainAppTest > testMainAppStarts() PASSED

MainAppTest > testMainAppHasMainMethod() PASSED





📈 Sample CSV Output

csv

Timestamp,FlightId,Altitude,Speed,Status,RecordTime

2026-09-01T12:34:56.789,AA101,157,193,TAKEOFF,1788314128757

2026-09-01T12:34:57.123,UA202,128,167,TAKEOFF,1788314128758

2026-09-01T12:34:57.456,DL303,145,161,TAKEOFF,1788314128759

2026-09-01T12:34:58.789,DL303,327,213,TAKEOFF,1788314128760

2026-09-01T12:34:59.123,AA101,290,231,TAKEOFF,1788314128761

... (More data)





🛠️ Commands

Command	Description

gradle build	Compile code and run tests

gradle run	Run the flight simulator

gradle test	Run all unit tests

gradle clean	Clean build directory

gradle build --refresh-dependencies	Refresh dependencies





💡 Skills Demonstrated



Skill	Evidence

Java SE	Complete Java application

Multi-threading	3 concurrent flights

Real-time processing	30-second mission

Data validation	Validation summary

File I/O	CSV export

Gradle	Build automation

JUnit	9 unit tests

Aerospace domain	Realistic flight phases

System design	Modular architecture

Clean code	Well-organized, documented





📝 License

This project is licensed under the MIT License - see the LICENSE file for details.





🙏 Acknowledgments

Built as part of learning real-time aerial surveying systems





