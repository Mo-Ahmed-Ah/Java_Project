CREATE DATABASE IF NOT EXISTS kherko;
USE kherko;

-- إنشاء جدول people
CREATE TABLE IF NOT EXISTS people (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  nickname VARCHAR(30) NULL,
  birthdate DATE NULL,
  location VARCHAR(100) NULL,
  phone VARCHAR(15) NULL,
  gender BOOLEAN NOT NULL,
  gid CHAR(14) NULL,
  notes TEXT NULL,
  joundate DATE NULL,
  PRIMARY KEY (id)
);

-- إنشاء جدول family_numbers
CREATE TABLE IF NOT EXISTS family_numbers (
  people_id INT NOT NULL,
  mail INT NULL,
  fmail INT NULL,
  UNIQUE INDEX status_id_UNIQUE (people_id),
  INDEX fk_family_numbers_people_idx (people_id),
  CONSTRAINT fk_family_numbers_people
    FOREIGN KEY (people_id)
    REFERENCES people (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- إنشاء جدول types_status
CREATE TABLE IF NOT EXISTS types_status (
  id INT NOT NULL AUTO_INCREMENT,
  statustitle VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
);

-- إنشاء جدول statue
CREATE TABLE IF NOT EXISTS statue (
  id INT NOT NULL AUTO_INCREMENT,
  typestatus_id INT NOT NULL,
  people_id INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_typestatus_typestatus1_idx (typestatus_id),
  INDEX fk_typestatus_status1_idx (people_id),
  CONSTRAINT fk_typestatus_typestatus1
    FOREIGN KEY (typestatus_id)
    REFERENCES types_status (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_typestatus_status1
    FOREIGN KEY (people_id)
    REFERENCES people (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
