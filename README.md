# AutomationPractice Test Framework

A Selenium WebDriver test automation framework for testing user registration and login functionality on the AutomationPractice website.

## Project Structure

```
AutomationPracticeTest/
│
├── pom.xml
├── testng.xml
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           ├── HomePage.java
│   │           ├── LoginPage.java
│   │           └── AccountCreationPage.java
│   │
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java
│           │
│           └── tests/
│               ├── RegisterTest.java
│               └── LoginTest.java
```

## Prerequisites

- Java JDK 8+
- Apache Maven 3.6+
- ChromeDriver
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Test Cases

### Registration Tests

- **testRegisterNewUser** - Register with valid data, verify success, logout, and login
- **testVerifySuccessAndLogout** - Attempt registration with existing email
- **testRegisterWithInvalidEmailFormat** - Registration with invalid email format
- **testRegisterWithEmptyEmail** - Registration with empty email field
- **testAccountCreationWithMissingFields** - Registration with missing required fields
- **testRegisterWithWeakPassword** - Registration with weak password
- **testRegisterWithInvalidData** - Registration with invalid data

### Login Tests

Data-driven tests covering:
- Empty email and password
- Invalid email and password combinations
- Missing email or password fields
- Invalid email formats
- Weak passwords

## Page Object Model

- **HomePage.java** - Navigation and sign-in/sign-out functionality
- **LoginPage.java** - Account creation and login functionality
- **AccountCreationPage.java** - Complete user registration form

## Features

- Page Object Model design pattern
- TestNG framework with data-driven testing
- Comprehensive test coverage
- Dynamic test data generation

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven

## Target Application

http://www.automationpractice.pl/


## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/AutomationPracticeTest.git
cd AutomationPracticeTest
```

2. Install dependencies:
```bash
mvn clean install
```
