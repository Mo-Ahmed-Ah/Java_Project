CREATE DATABASE IF NOT EXISTS kherko;

USE kherko;

CREATE TABLE IF NOT EXISTS People (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(100) NOT NULL,
    LastName VARCHAR(100),
    GID VARCHAR(50) NOT NULL,
    City VARCHAR(100),
    Street VARCHAR(100),
    MaleChild INT DEFAULT 0,
    FemaleChild INT DEFAULT 0,
    Status ENUM(
        'أعزب',
        'مخطوب',
        'متزوج',
        'متزوج ويعول',
        'مطلق',
        'مطلق ويعول',
        'أرمل',
        'أرمل ويعول',
        'منفصل'
    ) NOT NULL DEFAULT 'أعزب',
    Notes TEXT,
    JoinDate DATE
);

CREATE TABLE IF NOT EXISTS HelpingTypes (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    HelpingName VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Helpings (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    PeopleID INT,
    HelpingID INT,
    Value DECIMAL(10,2),
    Notes TEXT,
    Date DATE,
    FOREIGN KEY (PeopleID) REFERENCES People(ID) ON DELETE CASCADE,
    FOREIGN KEY (HelpingID) REFERENCES HelpingTypes(ID) ON DELETE CASCADE
);
