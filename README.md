# CarDealership-Manager

**CarDealership-Manager** is a Java-based application that integrates with SQL databases using the JDBC API. It provides functionalities to manage a car dealership's operations, including handling cars, car models, and customer information.

## Features

The Car Dealership Manager can perform the following operations:

1. Add or remove a car, car model, or customer.
2. Add a customer's car.
3. View details of a car or customer.
4. View a customer's cars.
5. Retrieve the latest car models of a brand.
6. Update a car model's generation and mileage.
7. Change a car's color.
8. Update customer contact information.

## Technologies Used

* **Java**: Core programming language.
* **JDBC API**: For database connectivity.
* **SQL**: For database operations.([GitHub Docs][1])

## Project Structure

* `src/`: Contains the Java source code.
* `sql/`: Contains SQL scripts for database setup.
* `class/`: Compiled `.class` files.

## Getting Started

### Prerequisites

* Java Development Kit (JDK) installed.
* A relational database system (e.g., MySQL, PostgreSQL).
* JDBC driver for your chosen database.

### Setup Instructions

1. Clone the repository:([GitHub Docs][2])

   ```bash
   git clone https://github.com/nathanmathewv/CarDealership-Manager.git
   ```



2. Set up the database:

   * Navigate to the `sql/` directory.
   * Execute the provided SQL scripts to create the necessary tables and relationships.([GitHub Docs][2])

3. Configure database connection:

   * Update the database URL, username, and password in the Java source code to match your database configuration.

4. Compile and run the application:

   * Navigate to the `src/` directory.
   * Compile the Java files:

     ```bash
     javac CarDealership.java
     ```
   * Run the application:

     ```bash
     java CarDealership
     ```

---

[1]: https://docs.github.com/en/account-and-profile/setting-up-and-managing-your-github-profile/customizing-your-profile/managing-your-profile-readme?utm_source=chatgpt.com "Managing your profile README - GitHub Docs"
[2]: https://docs.github.com/articles/about-readmes?utm_source=chatgpt.com "About READMEs - GitHub Docs"
