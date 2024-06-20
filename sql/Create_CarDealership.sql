create database Car_Dealership;

use Car_Dealership;

CREATE TABLE CarBrand (
    BrandID INT PRIMARY KEY,
    Name VARCHAR(255),
    CountryOfOrigin VARCHAR(255),
    Established DATE
);


CREATE TABLE CarModel (
    ModelID INT PRIMARY KEY,
    BrandID INT,
    Name VARCHAR(255) NOT NULL,
    Generation INT CHECK (Generation >= 1),
    FOREIGN KEY (BrandID) REFERENCES CarBrand(BrandID) ON DELETE CASCADE,
    AvgMileage FLOAT
);

CREATE TABLE Car (
    CarID INT PRIMARY KEY,
    ModelID INT,
    VIN VARCHAR(255) NOT NULL UNIQUE,
    Color VARCHAR(255),
    ManufactureDate DATE,
    FOREIGN KEY (ModelID) REFERENCES CarModel(ModelID) ON DELETE CASCADE
);

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255),
    CarCount INT DEFAULT 0,
    Email VARCHAR(255),
    Phone VARCHAR(255) NOT NULL
);

CREATE TABLE CustomerCar (
    TransactionID INT PRIMARY KEY,
    CarID INT,
    CustomerID INT,
    SaleDate DATE NOT NULL,
    Price INT,
    FOREIGN KEY (CarID) REFERENCES Car(CarID) ON DELETE CASCADE,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE
);