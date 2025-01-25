-- إنشاء قاعدة البيانات
CREATE DATABASE KherkoDB;

-- استخدام قاعدة البيانات
USE KherkoDB;

-- 1. إنشاء جدول people
CREATE TABLE people (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    nickname VARCHAR(30),
    birthdate DATE,
    location VARCHAR(100),
    phone VARCHAR(15),
    gender CHAR(1) NOT NULL,   -- F = Female, M = Male
    gid CHAR(14),
    notes TEXT,
    joindate DATE
);

-- 2. إنشاء جدول family_numbers
CREATE TABLE family_numbers (
    people_id INT,
    male INT,
    female INT,
    FOREIGN KEY (people_id) REFERENCES people(id) 
    ON DELETE CASCADE ON UPDATE CASCADE
);

-- 3. إنشاء جدول types_status
CREATE TABLE types_status (
    id INT AUTO_INCREMENT PRIMARY KEY,
    statustitle VARCHAR(30) NOT NULL
);

-- 4. إنشاء جدول statue
CREATE TABLE statue (
    id INT AUTO_INCREMENT PRIMARY KEY,
    typestatus_id INT,
    people_id INT,
    FOREIGN KEY (typestatus_id) REFERENCES types_status(id) 
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (people_id) REFERENCES people(id) 
    ON DELETE CASCADE ON UPDATE CASCADE
);