INSERT INTO CarBrand VALUES
    (101, 'Toyota', 'Japan', '1937-08-28'),
    (105, 'Ford', 'United States', '1903-06-16'),
    (189, 'BMW', 'Germany', '1916-03-07'),
    (574, 'Mercedes-Benz', 'Germany', '1926-06-28'),
    (383, 'Tata Motors', 'India', '1945-01-01'),
    (586, 'Mahindra & Mahindra', 'India', '1945-10-02'),
    (284, 'Maruti Suzuki', 'India', '1981-01-01'),
    (375, 'Force Motors', 'India', '1958-01-01');

INSERT INTO CarModel VALUES
    (130, 189, '3 Series', 7, 28),
    (159, 189, '7 Series', 7, 29),
    (181, 586, 'Scorpio', 3, 20),
    (307, 574, 'S-Class', 7, 24.5),
    (320, 189, '5 Series', 8, 30),
    (417, 383, 'Nano', 1, 22),
    (423, 101, 'Corolla', 12, 32),
    (429, 101, 'Camry', 7, 30.5),
    (457, 284, 'Swift', 2, 23.5),
    (466, 586, 'XUV500', 3, 22.5),
    (478, 383, 'Tiago', 2, 24),
    (484, 105, 'Mustang', 6, 25),
    (596, 105, 'Explorer', 6, 21.5),
    (678, 375, 'Gurkha', 2, 18),
    (698, 105, 'F-150', 14, 18.5),
    (710, 574, 'C-Class', 6, 28),
    (739, 375, 'Traveller', 4, 15),
    (795, 284, 'Baleno', 2, 21),
    (902, 574, 'E-Class', 5, 26.5),
    (906, 101, 'RAV4', 5, 27.5);

INSERT INTO Car VALUES
    (1, 429, '1HGBH41JXMN109186', 'Red', '2023-01-15'),
    (2, 320, '3KBBB41JXMN123456', 'Blue', '2022-11-28'),
    (3, 902, '5LBBB41JXMN654321', 'Black', '2023-02-20'),
    (4, 710, '2SGBH41JXMN987654', 'White', '2022-09-10'),
    (5, 596, '9HGBH41JXMN654320', 'Silver', '2023-03-05'),
    (6, 159, '6YGBH41JXMN456789', 'Gray', '2022-12-30'),
    (7, 181, '4DGBH41JXMN987650', 'Green', '2023-01-05'),
    (8, 678, '8TGBH41JXMN234567', 'Blue', '2022-11-20'),
    (9, 698, '2JGBH41JXMN765432', 'Red', '2023-02-10'),
    (10, 457, '1AGBH41JXMN987653', 'Black', '2023-03-15'),
    (11, 795, '2DGBH41JXMN345678', 'Black', '2023-02-25'),
    (12, 130, '3AGBH41JXMN987652', 'Green', '2023-03-30'),
    (13, 478, '2AGBH41JXMN987651', 'White', '2023-04-01'),
    (14, 159, '3AGBH41JXMN987650', 'Silver', '2023-04-02'),
    (15, 423, '4AGBH41JXMN987649', 'Gray', '2023-04-03'),
    (16, 698, '5AGBH41JXMN987648', 'Red', '2023-04-04'),
    (17, 902, '6AGBH41JXMN987647', 'Blue', '2023-04-05'),
    (18, 596, '7AGBH41JXMN987646', 'Green', '2023-04-06'),
    (19, 902, '8AGBH41JXMN987645', 'Black', '2023-04-07'),
    (20, 710, '9AGBH41JXMN987644', 'White', '2023-04-08'),
    (21, 429, '1BGBH41JXMN987643', 'Silver', '2023-04-09'),
    (22, 320, '2BGBH41JXMN987642', 'Gray', '2023-04-10'),
    (23, 902, '3BGBH41JXMN987641', 'Red', '2023-04-11'),
    (24, 710, '4BGBH41JXMN987640', 'Blue', '2023-04-12'),
    (25, 596, '5BGBH41JXMN987639', 'Green', '2023-04-13'),
    (26, 159, '6BGBH41JXMN987638', 'Black', '2023-04-14'),
    (27, 181, '7BGBH41JXMN987637', 'White', '2023-04-15'),
    (28, 678, '8BGBH41JXMN987636', 'Silver', '2023-04-16'),
    (29, 698, '9BGBH41JXMN987635', 'Gray', '2023-04-17'),
    (30, 457, '1CGBH41JXMN987634', 'Red', '2023-04-18'),
    (31, 795, '2CGBH41JXMN987633', 'Blue', '2023-04-19'),
    (32, 130, '3CGBH41JXMN987632', 'Green', '2023-04-20'),
    (33, 457, '4CGBH41JXMN987631', 'Black', '2023-04-21'),
    (34, 457, '5CGBH41JXMN987630', 'White', '2023-04-22'),
    (35, 320, '6CGBH41JXMN987629', 'Silver', '2023-04-23'),
    (36, 417, '7CGBH41JXMN987628', 'Gray', '2023-04-24');


INSERT INTO Customer VALUES
    (1000, 'John', 'Doe', 'john.doe@example.com', '1234567890'),
    (1001, 'Jane', 'Smith', 'jane.smith@example.com', '2345678901'),
    (1002, 'Alice', 'Johnson', 'alice.johnson@example.com', '3456789012'),
    (1003, 'Bob', 'Brown', 'bob.brown@example.com', '4567890123'),
    (1004, 'Carol', 'Davis', 'carol.davis@example.com', '5678901234'),
    (1005, 'David', 'Martinez', 'david.martinez@example.com', '6789012345'),
    (1006, 'Eve', 'Garcia', 'eve.garcia@example.com', '7890123456'),
    (1007, 'Frank', 'Rodriguez', 'frank.rodriguez@example.com', '8901234567'),
    (1008, 'Grace', 'Wilson', 'grace.wilson@example.com', '9012345678'),
    (1009, 'Harry', 'Lee', 'harry.lee@example.com', '0123456789');

INSERT INTO CustomerCar VALUES
    (2001, 1, 1000, '2023-01-01', 25000),
    (2002, 11, 1001, '2023-01-02', 30000),
    (2003, 36, 1002, '2023-01-03', 35000),
    (2004, 25, 1003, '2023-01-04', 40000),
    (2005, 17, 1004, '2023-01-05', 45000),
    (2006, 23, 1005, '2023-01-06', 50000),
    (2007, 34, 1006, '2023-01-07', 55000),
    (2008, 19, 1007, '2023-01-08', 60000),
    (2009, 9, 1008, '2023-01-09', 65000),
    (2010, 4, 1009, '2023-01-10', 70000),
    (2011, 15, 1000, '2023-01-11', 75000),
    (2012, 12, 1001, '2023-01-12', 80000),
    (2013, 30, 1002, '2023-01-13', 85000),
    (2014, 14, 1003, '2023-01-14', 90000),
    (2015, 29, 1004, '2023-01-15', 95000);
