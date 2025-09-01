# EaseMyTrip Hackathon Automation Project

## Overview
This project automates key flows on EaseMyTrip using Selenium, Java, TestNG, Cucumber (BDD), and Page Object Model. It supports data-driven testing (Excel, JSON, Properties), reporting (Allure, Log4j), screenshots, Selenium Grid, Jenkins/Git integration, and robust error handling.

## Structure
- `src/main/java/com/emt/base/` — WebDriver setup
- `src/main/java/com/emt/pages/` — Page classes (PageFactory)
- `src/main/java/com/emt/utils/` — Utilities (Excel, JSON, Properties, Screenshot, Waits, Logger)
- `src/main/java/com/emt/config/` — Config reader
- `src/test/java/com/emt/stepdefinitions/` — Cucumber step definitions
- `src/test/java/com/emt/runners/` — Test runner classes
- `src/test/java/com/emt/hooks/` — Cucumber hooks
- `src/test/resources/features/` — Feature files
- `src/test/resources/testdata/` — Test data (Excel, JSON, XML)
- `src/test/resources/config/` — Browser/Grid config
- `logs/`, `screenshots/`, `reports/` — Output folders

## How to Run
1. Install dependencies: `mvn clean install`
2. Run tests: `mvn test`
3. View reports: `reports/` (Allure, Cucumber)

## Key Features
- BDD with Cucumber + TestNG
- Page Object Model (PageFactory)
- Data-driven (Excel, JSON, Properties)
- Allure & Log4j reporting
- Screenshots on validation/error
- Selenium Grid & multi-browser
- Jenkins/Git integration
- Retry logic & waits

## Test Scenarios
- Outstation Cabs (One-way/Round-trip)
- Airport Cabs (Pickup/Drop)
- Hourly Cabs
- Hotels
- Activities
- Gift Cards

## Contribution
Fork, clone, and submit PRs. For issues, open a ticket.
