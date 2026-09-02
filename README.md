```markdown

\# ✈️ Flight Data Processor

\## Real-Time Aerial Surveying System



\[!\[Java](https://img.shields.io/badge/Java-26-orange?style=flat-square\&logo=java)](https://adoptium.net/)

\[!\[Gradle](https://img.shields.io/badge/Gradle-9.7-blue?style=flat-square\&logo=gradle)](https://gradle.org/)

\[!\[JUnit](https://img.shields.io/badge/JUnit-5.10-green?style=flat-square\&logo=junit5)](https://junit.org/junit5/)

\[!\[License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)](LICENSE)



\---



\## 📋 Overview



\*\*Flight Data Processor\*\* is a production-grade, real-time flight simulation and data processing system designed for \*\*aerial surveying applications\*\*. It simulates multiple concurrent flights with realistic flight phases, validates all data against aviation standards, exports to CSV, and provides comprehensive per-flight statistics.



> 🎯 \*\*Built for:\*\* Software Engineer for Aerial Surveying Systems role at Aerodata AG



\---



\## ✨ Key Features



| Feature | Description |

|---------|-------------|

| ✈️ \*\*Multi-Flight Simulation\*\* | Run 3+ concurrent flights with realistic behavior |

| 📈 \*\*Realistic Flight Phases\*\* | TAKEOFF → CLIMB → CRUISE → DESCENT → LANDING |

| 🔍 \*\*Data Validation\*\* | Automatic validation of altitude (0-60,000 ft) and speed (100-700 knots) |

| 💾 \*\*CSV Export\*\* | All data saved to CSV for post-flight analysis |

| 📊 \*\*Per-Flight Statistics\*\* | Detailed stats for each individual flight |

| 🧪 \*\*Unit Testing\*\* | 9 passing JUnit tests with 100% pass rate |

| ⚙️ \*\*Gradle Build\*\* | Modern build automation with dependency management |

| 🏗️ \*\*Clean Architecture\*\* | Modular, testable, maintainable code |



\---



\## 🏗️ Architecture



```

┌─────────────────────────────────────────────────────────────────────────────┐

│                         FLIGHT DATA PROCESSOR                              │

│                          System Architecture                               │

├─────────────────────────────────────────────────────────────────────────────┤

│                                                                             │

│   ┌─────────────────────────────────────────────────────────────────────┐   │

│   │                         MAIN APP                                    │   │

│   │                    (Orchestrator)                                   │   │

│   └───────────────┬─────────────────────────┬─────────────────────────┘   │

│                   │                         │                             │

│                   ▼                         ▼                             │

│   ┌───────────────────────────┐   ┌───────────────────────────┐          │

│   │    Flight Simulator       │   │    Flight Simulator       │          │

│   │         AA101            │   │         UA202             │          │

│   └───────────┬───────────────┘   └───────────┬───────────────┘          │

│               │                               │                          │

│               └───────────────┬───────────────┘                          │

│                               ▼                                          │

│               ┌───────────────────────────────┐                          │

│               │      Flight Processor         │                          │

│               │    (Data Processing)          │                          │

│               └───────────────┬───────────────┘                          │

│                               │                                          │

│               ┌───────────────┼───────────────┐                          │

│               ▼               ▼               ▼                          │

│   ┌───────────────┐ ┌───────────────┐ ┌───────────────┐                 │

│   │   Data        │ │   File        │ │   Validation  │                 │

│   │   Validator   │ │   Logger      │ │   Summary     │                 │

│   └───────────────┘ └───────────────┘ └───────────────┘                 │

│                                                                             │

└─────────────────────────────────────────────────────────────────────────────┘

```



\### Component Details



| Component | Responsibility | Key Methods |

|-----------|---------------|-------------|

| \*\*MainApp\*\* | Orchestrates the entire system | `main()`, starts threads, manages shutdown |

| \*\*FlightSimulator\*\* | Simulates one flight with realistic phases | `run()`, `generateRealisticData()`, `advancePhase()` |

| \*\*FlightProcessor\*\* | Processes data, stores history, calculates stats | `processData()`, `getAverageAltitude()`, `printSummary()` |

| \*\*FlightData\*\* | POJO representing one flight data point | Getters, `toString()` |

| \*\*DataValidator\*\* | Validates all data against realistic parameters | `validate()`, `printValidationSummary()` |

| \*\*FileLogger\*\* | Exports all data to CSV files | `logData()`, `close()` |



\---



\## 📁 Project Structure



```

flight-data-processor/

├── src/

│   ├── main/

│   │   └── java/

│   │       └── com/

│   │           └── myproject/

│   │               └── flight/

│   │                   ├── FlightData.java          # Data POJO

│   │                   ├── FlightSimulator.java     # Flight simulation

│   │                   ├── FlightProcessor.java     # Data processing

│   │                   ├── DataValidator.java       # Validation

│   │                   ├── FileLogger.java          # CSV export

│   │                   └── MainApp.java             # Application entry point

│   └── test/

│       └── java/

│           └── com/

│               └── myproject/

│                   └── flight/

│                       ├── FlightDataTest.java      # 5 tests

│                       ├── FlightSimulatorTest.java # 2 tests

│                       └── MainAppTest.java         # 2 tests

├── build.gradle                                      # Gradle build configuration

├── settings.gradle                                   # Project settings

├── .gitignore                                        # Git ignore rules

└── README.md                                         # This file

```



\---



\## 🚀 Getting Started



\### Prerequisites



| Requirement | Version |

|-------------|---------|

| \*\*Java\*\* | 26 or higher |

| \*\*Gradle\*\* | 9.7 or higher |

| \*\*Git\*\* | Latest version |



\### Installation



```bash

\# Clone the repository

git clone https://github.com/rkumar49/flight-data-processor-Real-Time-Aerial-Surveying-System-with-Java-Multi-threading-and-Gradle-

cd flight-data-processor-Real-Time-Aerial-Surveying-System-with-Java-Multi-threading-and-Gradle-



\# Build the project

gradle build



\# Run the application

gradle run

```



\---



\## 📊 Sample Output



```

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



\[PROCESSED] AA101 | Alt: 157 ft | Speed: 193 knots | Status: TAKEOFF | Total Records: 1

\[PROCESSED] UA202 | Alt: 128 ft | Speed: 167 knots | Status: TAKEOFF | Total Records: 2

\[PROCESSED] DL303 | Alt: 145 ft | Speed: 161 knots | Status: TAKEOFF | Total Records: 3

\[PHASE] DL303 -> CLIMB

\[PROCESSED] DL303 | Alt: 2789 ft | Speed: 294 knots | Status: CLIMB | Total Records: 20

\[PHASE] AA101 -> CLIMB

\[PROCESSED] AA101 | Alt: 2824 ft | Speed: 267 knots | Status: CLIMB | Total Records: 21

... (30 seconds of data) ...



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



✈️ UA202

&#x20; Records     : 21

&#x20; Avg Alt     : 13,506 ft

&#x20; Alt Range   : 128 - 33,960 ft

&#x20; Avg Speed   : 339 knots

&#x20; Speed Range : 167 - 528 knots



✈️ DL303

&#x20; Records     : 24

&#x20; Avg Alt     : 15,369 ft

&#x20; Alt Range   : 145 - 33,421 ft

&#x20; Avg Speed   : 342 knots

&#x20; Speed Range : 161 - 544 knots

========================================



========================================

&#x20;       VALIDATION SUMMARY

========================================

Valid Records   : 68

Invalid Records : 0

Total Records   : 68

========================================



\[LOGGER] Closed file: flight\_data\_1234567890.csv

\[SYSTEM] Mission complete. Goodbye!

```



\---



\## 🧪 Testing



```bash

\# Run all tests

gradle test



\# Run with detailed output

gradle test --info

```



\### Test Results



```

FlightDataTest > testFlightDataTimestamp() PASSED

FlightDataTest > testFlightDataWithLargeValues() PASSED

FlightDataTest > testFlightDataWithZeroValues() PASSED

FlightDataTest > testFlightDataCreation() PASSED

FlightDataTest > testFlightDataToString() PASSED

FlightSimulatorTest > testSimulatorCreation() PASSED

FlightSimulatorTest > testSimulatorStop() PASSED

MainAppTest > testMainAppStarts() PASSED

MainAppTest > testMainAppHasMainMethod() PASSED



BUILD SUCCESSFUL ✅

```



\---



\## 📈 Sample CSV Output



```csv

Timestamp,FlightId,Altitude,Speed,Status,RecordTime

2026-09-01T12:34:56.789,AA101,157,193,TAKEOFF,1788314128757

2026-09-01T12:34:57.123,UA202,128,167,TAKEOFF,1788314128758

2026-09-01T12:34:57.456,DL303,145,161,TAKEOFF,1788314128759

2026-09-01T12:34:58.789,DL303,327,213,TAKEOFF,1788314128760

2026-09-01T12:34:59.123,AA101,290,231,TAKEOFF,1788314128761

2026-09-01T12:34:59.456,UA202,276,238,TAKEOFF,1788314128762

```



\---



\## 🛠️ Commands Reference



| Command | Description |

|---------|-------------|

| `gradle build` | Compile code and run tests |

| `gradle run` | Run the flight simulator |

| `gradle test` | Run all unit tests |

| `gradle clean` | Clean build directory |

| `gradle build --refresh-dependencies` | Refresh dependencies |

| `gradle test --info` | Run tests with detailed output |



\---



\## 💡 Skills Demonstrated



| Skill | Evidence |

|-------|----------|

| \*\*Java SE\*\* | Complete Java application with OOP principles |

| \*\*Multi-threading\*\* | 3 concurrent flights with synchronized processing |

| \*\*Real-time processing\*\* | 30-second mission with real-time data flow |

| \*\*Data validation\*\* | Comprehensive validation with summary |

| \*\*File I/O\*\* | CSV export with timestamps |

| \*\*Gradle\*\* | Build automation with dependency management |

| \*\*JUnit\*\* | 9 unit tests with 100% pass rate |

| \*\*Aerospace domain\*\* | Realistic flight phases and parameters |

| \*\*System design\*\* | Modular, testable, maintainable architecture |

| \*\*Clean code\*\* | Well-organized, documented, production-ready |



\---



\## 🎯 Future Enhancements



| Feature | Status | Description |

|---------|--------|-------------|

| JSON Export | 🔜 Planned | Export data as JSON format |

| HTML Report | 🔜 Planned | Generate formatted HTML report |

| Configuration File | 🔜 Planned | Load settings from config.properties |

| Real-Time Dashboard | 🔜 Planned | Text-based cockpit display |

| Performance Metrics | 🔜 Planned | Track data rate, memory usage |



\---



\## 📝 License



This project is licensed under the MIT License - see the \[LICENSE](LICENSE) file for details.



\---











