# Car Rental System

A console-based Car Rental System developed in Java. This project simulates a simple car rental service, allowing users to rent and return cars, manage customer information, and calculate rental costs.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features
- **Car Management:** Add new cars to the system, check availability, and manage car information.
- **Customer Management:** Create and store customer profiles with unique IDs.
- **Rental Management:** Rent cars for a specified number of days, calculate total rental costs, and handle car returns.
- **Menu-Driven Interface:** Interactive console-based user interface for easy navigation.
- **Error Handling:** Validates inputs and manages scenarios like unavailable cars or invalid car IDs.

## Technologies Used
- **Java**: The primary programming language used for this project.
- **Object-Oriented Programming (OOP)**: The design pattern used to organize the code and model the system entities.

## Installation
1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/car-rental-system.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd car-rental-system
   ```
3. **Compile the Java files**:
   ```bash
   javac main.java
   ```
4. **Run the application**:
   ```bash
   java main
   ```

## Usage
Once the application is running, follow the on-screen menu options to:
- Rent a car by selecting an available car and specifying the rental period.
- Return a car by entering the car's ID.
- Exit the application.

The system will handle the rental process, calculate costs, and update car availability accordingly.

## Project Structure
```
|-- src
    |-- Car.java          # Defines the Car class
    |-- Customer.java     # Defines the Customer class
    |-- Rental.java       # Defines the Rental class
    |-- CarRentalSystem.java # Contains the main logic of the system
    |-- main.java         # Entry point for the application
```

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.



---
