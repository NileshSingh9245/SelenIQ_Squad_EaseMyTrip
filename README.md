# EaseMyTrip Hackathon Automation Project

🔗 **GitHub Repository**: [https://github.com/NileshSingh9245/SelenIQ_Squad_EaseMyTrip.git](https://github.com/NileshSingh9245/SelenIQ_Squad_EaseMyTrip.git)

## Overview
This project automates key flows on EaseMyTrip using Selenium, Java, TestNG, Cucumber (BDD), and Page Object Model. It supports data-driven testing (Excel, JSON, Properties), reporting (Allure, Log4j), screenshots, multi-browser execution, and robust error handling with retry mechanism.

## Project Structure
```
EaseMyTrip_Hackathon/
├── src/
│   ├── main/ (empty - only test code in this project)
│   └── test/
│       ├── java/com/emt/
│       │   ├── base/ — Base classes and configurations
│       │   ├── config/ — Configuration management
│       │   ├── hooks/ — Cucumber hooks for setup/teardown
│       │   ├── pages/ — Page Object Model classes (PageFactory)
│       │   ├── retry/ — TestNG retry mechanism implementation
│       │   ├── runners/ — TestNG + Cucumber test runners
│       │   ├── stepDefinitions/ — Cucumber step definition classes
│       │   └── utils/ — Utility classes (Excel, JSON, Screenshot, etc.)
│       └── resources/
│           ├── data/ — Test data files (Excel, JSON, Properties, XML)
│           ├── features/ — Cucumber feature files (.feature)
│           ├── allure.properties — Allure reporting configuration
│           └── log4j2.xml — Logging configuration
├── target/ — Maven build output directory
├── allure-results/ — Allure test results
├── logs/ — Application logs
├── reports/ — Test execution reports
├── Screenshots/ — Captured screenshots
├── test-output/ — TestNG reports
├── pom.xml — Maven dependencies and plugins
├── testng.xml — TestNG suite configuration
└── README.md — Project documentation

```

## Technology Stack
### Core Framework
- **Java 11** - Programming language
- **Selenium WebDriver 4.32.0** - Browser automation
- **TestNG 7.11.0** - Test execution framework
- **Cucumber 7.23.0** - BDD framework for feature files
- **Maven** - Build and dependency management

### Data Management
- **Apache POI 5.4.0** - Excel file handling (.xlsx)
- **Gson 2.13.1** - JSON data processing
- **Properties files** - Configuration management

### Reporting & Logging
- **Allure 2.29.1** - Rich HTML test reporting
- **Log4j2 2.25.0** - Comprehensive logging framework
- **WebDriverManager 5.3.0** - Automatic driver management

### Browser Support
- **Chrome** - Primary browser for testing
- **Microsoft Edge** - Secondary browser support
- **Remote WebDriver** - Grid execution capability

## How to Run

### Prerequisites
1. Java 11 or higher installed
2. Maven installed and configured
3. Chrome/Edge browsers installed
4. **Allure CLI installed** (for automated report generation)

> ⚠️ **Important Configuration**: Update the Allure binary path in `src/test/java/com/emt/utils/AllureReportOpener.java` according to your system's Allure installation location. The current path is hardcoded for the original developer's system:
> ```java
> "C:\\Users\\2421255\\Downloads\\EaseMyTrip_Hackathon\\allure-2.34.1\\bin\\allure.bat"
> ```
> Replace this with your actual Allure installation path before running tests.

### Execution Commands
```bash
# Install dependencies
mvn clean install

# Run all tests
mvn test

# Run specific browser tests
mvn test -Dtest=TestRunner -Dbrowser=chrome
mvn test -Dtest=TestRunner -Dbrowser=edge

# Generate Allure reports
mvn allure:report
mvn allure:serve
```

### Configuration
- **Browser selection**: Configured in `testng.xml`
- **Base URL**: Set in `src/test/resources/data/config.properties`
- **Execution environment**: Local/Remote configurable in config.properties

## Key Features
### Framework Architecture
- **Page Object Model (POM)** with PageFactory
- **BDD implementation** using Cucumber + TestNG
- **Data-driven testing** with Excel, JSON, and Properties
- **Multi-browser support** (Chrome, Edge)
- **Cross-platform execution** (Windows, Mac, Linux)

### Robust Test Execution
- **Automatic retry mechanism** for failed tests
- **Screenshot capture** on test failures
- **Comprehensive logging** with Log4j2
- **Parallel execution** support via TestNG
- **Allure reporting** with detailed test insights

### Data Management
- **Excel-based test data** for structured data scenarios
- **JSON data files** for complex object handling
- **XML data support** for configuration-heavy scenarios
- **Properties files** for environment configuration

## Test Scenarios Coverage
The framework automates the following EaseMyTrip workflows:

### 🚗 Cab Services
1. **Airport Cabs** (`01_AirportCabs.feature`)
   - Airport pickup booking
   - Airport drop booking
   - Sedan filtering and price comparison

2. **Outstation Cabs** (`02_OutstationCabs.feature`)
   - One-way trip booking
   - Round-trip booking
   - Multi-city travel options

3. **Hourly Cabs** (`03_HourlyCabs.feature`)
   - Hourly rental booking
   - Duration-based pricing
   - Local city travel

### 🏨 Travel Services
4. **Hotels** (`05_Hotels.feature`)
   - Hotel search and filtering
   - Date range selection
   - Room configuration
   - Price comparison

5. **Activities** (`04_Activities.feature`)
   - Local activities browsing
   - Activity booking workflow
   - Location-based filtering

6. **Gift Cards** (`06_GiftCards.feature`)
   - Gift card purchase flow
   - Different denomination options
   - Payment workflow validation

## File Structure Details

### 📁 Core Framework Files
- **`pom.xml`** - Maven configuration with all dependencies
- **`testng.xml`** - TestNG suite configuration for multi-browser execution
- **`src/test/java/com/emt/runners/TestRunner.java`** - Main Cucumber + TestNG runner
- **`src/test/java/com/emt/hooks/Hooks.java`** - Test lifecycle management

### 📁 Page Objects (`src/test/java/com/emt/pages/`)
- **`HomePage.java`** - Main navigation and header elements
- **`AirportCabPage.java`** - Airport transfer specific interactions
- **`OutstationCabPage.java`** - Outstation cab booking workflow
- **`HourlyCabPage.java`** - Hourly rental specific functions
- **`HotelsPage.java`** - Hotel search and booking
- **`ActivitiesPage.java`** - Activities browsing and booking
- **`GiftCardPage.java`** - Gift card purchase workflow

### 📁 Utilities (`src/test/java/com/emt/utils/`)
- **`DriverSetup.java`** - WebDriver initialization and configuration
- **`ExcelUtils.java`** - Excel file reading utilities
- **`ExcelWrite.java`** - Excel file writing for results
- **`JsonDataReader.java`** - JSON data file processing
- **`ScreenshotUtil.java`** - Screenshot capture functionality
- **`AllureReportOpener.java`** - Automated Allure report generation ⚠️ *Requires path update*
- **`AllureReportCleaner.java`** - Report cleanup utilities

> 📝 **Note**: The `AllureReportOpener.java` contains a hardcoded Allure binary path specific to the original developer's system. Please update the Allure installation path in this file to match your local Allure CLI installation before using automated report generation features.

### 📁 Test Data (`src/test/resources/data/`)
- **`config.properties`** - Environment and browser configuration
- **`AirportCabsData.xlsx`** - Excel-based test data for airport cabs
- **`OutstationCabsData.json`** - JSON data for outstation bookings
- **`HourlyCabs.json`** - Hourly cab test data
- **`GiftCardData.xlsx`** - Gift card scenarios data
- **`Activities&HotelsData.xml`** - XML-based data for activities/hotels

## Advanced Features

### 🔄 Retry Mechanism
- **`RetryAnalyzer.java`** - Automatic retry for failed tests
- **`RetryListener.java`** - TestNG listener for retry management
- Configurable retry count (default: 1 retry)

### 📊 Reporting Integration
- **Allure Reports** - Rich HTML reports with screenshots
- **TestNG Reports** - Built-in test execution reports
- **Log4j2 Logging** - Comprehensive logging with file rotation
- **Screenshot on Failure** - Automatic capture and attachment

### 🌐 Multi-Browser & Cross-Platform
- Chrome and Edge browser support
- Windows, Mac, Linux platform compatibility
- Local and Remote WebDriver execution
- Selenium Grid integration ready

## CI/CD Integration
The framework is designed for easy integration with:
- **Jenkins** - Automated build and test execution
- **GitHub Actions** - CI/CD pipeline support
- **Docker** - Containerized test execution
- **Allure Server** - Centralized reporting

## Best Practices Implemented
1. **Page Object Model** - Maintainable and reusable page classes
2. **Data-Driven Testing** - External data sources for test parameterization
3. **BDD Approach** - Business-readable feature files
4. **Error Handling** - Comprehensive exception management
5. **Wait Strategies** - Implicit and explicit waits for stability
6. **Logging** - Detailed execution logs for debugging
7. **Screenshot Evidence** - Visual proof of test execution
8. **Code Documentation** - Comprehensive JavaDoc comments

## Contribution Guidelines
1. **Fork** the repository from GitHub
2. **Clone** your forked repository locally
3. **Create a feature branch** for your changes
4. **Follow coding standards** - Java conventions and clean code principles
5. **Add tests** for new functionality
6. **Update documentation** as needed
7. **Submit a Pull Request** with detailed description

## Support & Issues
- **GitHub Issues** - Report bugs and feature requests
- **Documentation** - Comprehensive code comments and README
- **Examples** - Working test scenarios for reference

---

## 📋 Quick Start Checklist
- [ ] Java 11+ installed
- [ ] Maven configured
- [ ] **Allure CLI installed** and path updated in `AllureReportOpener.java`
- [ ] Clone repository: `git clone https://github.com/NileshSingh9245/SelenIQ_Squad_EaseMyTrip.git`
- [ ] **Update Allure path**: Modify the hardcoded path in `src/test/java/com/emt/utils/AllureReportOpener.java` lines 20 & 28
- [ ] Run: `mvn clean install`
- [ ] Execute tests: `mvn test`
- [ ] View Allure reports: `mvn allure:serve` (or use automated opener after path update)

**Happy Testing! 🚀**
