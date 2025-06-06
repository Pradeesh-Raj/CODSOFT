-- Create database
CREATE DATABASE IF NOT EXISTS ATM;
USE ATM;

-- Create users table
CREATE TABLE IF NOT EXISTS USERS (
    acc_num INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    balance DOUBLE DEFAULT 0
);

-- Insert sample data
INSERT INTO USERS (acc_num, name, balance) VALUES 
(12345678, 'Alice', 1000.0),
(87654321, 'Bob', 500.0);
