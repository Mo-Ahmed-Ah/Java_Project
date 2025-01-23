CREATE DATABASE IF NOT EXISTS kherko;

USE kherko;

CREATE TABLE IF NOT EXISTS people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    nickname VARCHAR(30) NULL,
    birthdate DATE NULL,
    location VARCHAR(100) NULL,
    phone VARCHAR(15) NULL,
    gender CHAR(1) NOT NULL,
    gid CHAR(14) NULL,
    notes TEXT NULL,
    joindate DATE NULL
);

CREATE TABLE IF NOT EXISTS family_numbers (
    people_id INT NOT NULL,
    male INT NULL,
    female INT NULL,
    FOREIGN KEY (people_id) REFERENCES people(id)
);

CREATE TABLE IF NOT EXISTS types_status (
    id INT PRIMARY KEY AUTO_INCREMENT,
    statustitle VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS statue (
    id INT PRIMARY KEY AUTO_INCREMENT,
    typestatus_id INT NOT NULL,
    people_id INT NOT NULL,
    FOREIGN KEY (typestatus_id) REFERENCES types_status(id),
    FOREIGN KEY (people_id) REFERENCES people(id)
);
