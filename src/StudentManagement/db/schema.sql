CREATE DATABASE IF NOT EXISTS StudentSystem;
USE StudentSystem;

CREATE TABLE IF NOT EXISTS STUDENTS (
    roll_no INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    grade INT NOT NULL
);
