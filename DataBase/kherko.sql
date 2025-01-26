-- Create DataBase
CREATE DATABASE IF NOT EXISTS Kherko;

-- Using DataBase
USE Kherko ;

-- Status Table
CREATE TABLE IF NOT EXISTS Status(
	id INT AUTO_INCREMENT PRIMARY KEY,
	stat_name VARCHAR(50) NOT NULL
);

-- People table
CREATE TABLE IF NOT EXISTS People (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL,
    nickname VARCHAR(50),
    city VARCHAR(50),
    street VARCHAR(100),
    phone VARCHAR(15),
    gender CHAR(1) NOT NULL,   
    gid CHAR(14),
    notes TEXT,
    joindate Date DEFAULT CURRENT_TIMESTAMP
);


-- People status table

CREATE TABLE IF NOT EXISTS People_Status (
    people_ID INT,
    stat_ID INT,
	FOREIGN KEY (people_ID) REFERENCES People(id) ON DELETE CASCADE,
    FOREIGN KEY (stat_ID) REFERENCES Status(id) ON DELETE CASCADE,
    PRIMARY KEY (people_ID, stat_ID)
);

--  Type of helping taple
CREATE TABLE IF NOT EXISTS Type_of_helping(
	id INT AUTO_INCREMENT PRIMARY KEY,
    helping_name character(250)
);


-- Assistance table
CREATE TABLE IF NOT EXISTS Assistances(
	id INT AUTO_INCREMENT PRIMARY KEY,
    people_ID INT NOT NULL,
    helping_ID INT NOT NULL,
    notes TEXT,
    Assistance_date Date DEFAULT CURRENT_TIMESTAMP,
    value character(100) NOT NULL,
    FOREIGN KEY (people_ID) REFERENCES People(id) ON DELETE CASCADE,
    FOREIGN KEY (helping_ID) REFERENCES Type_of_helping(id) ON DELETE CASCADE
);
