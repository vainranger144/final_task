# EpamFinalTask
# Selenium Test Automation for SauceDemo

## Overview
This project contains automated test scripts for the login functionality on the SauceDemo website.

### Features
- Parallel Execution of Tests
- Parameterization using Data Provider
- Logging for easier debugging
- Supports Edge and Chrome browsers

### Tools & Technologies
- **Language**: Java (JDK 17.0.6)
- **Test Automation**: Selenium WebDriver
- **Build Tool**: Maven
- **Test Runner**: JUnit, TestNG
- **Assertions**: Hamcrest
- **Logging**: Log4j

### Test Cases
1. **UC-1**: Verify login with empty credentials displays "Username is required".
2. **UC-2**: Verify login without password displays "Password is required".
3. **UC-3**: Verify successful login with valid credentials.

### Setup & Run
1. Clone the repository.
2. Update `pom.xml` and install dependencies using `mvn clean install`.
3. Execute tests using `mvn test`.
