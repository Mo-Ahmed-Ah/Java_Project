CREATE DATABASE IF NOT EXISTS kherko;
USE kherko;

CREATE TABLE IF NOT EXISTS status (
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

CREATE TABLE IF NOT EXISTS family_numbers (
  status_id INT NOT NULL,
  mail INT NULL,
  fmail INT NULL,
  INDEX fk_family_numbers_status_idx (status_id),
  UNIQUE INDEX status_id_UNIQUE (status_id),
  CONSTRAINT fk_family_numbers_status
    FOREIGN KEY (status_id)
    REFERENCES status (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS types_status (
  id INT NOT NULL AUTO_INCREMENT,
  statustitle VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
  );


CREATE TABLE IF NOT EXISTS status_types (
  typestatus_id INT NOT NULL,
  status_id INT NOT NULL,
  PRIMARY KEY (typestatus_id, status_id),
  INDEX fk_typestatus_typestatus1_idx (typestatus_id),
  INDEX fk_typestatus_status1_idx (status_id),
  CONSTRAINT fk_typestatus_typestatus1
    FOREIGN KEY (typestatus_id)
    REFERENCES types_status (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT fk_typestatus_status1
    FOREIGN KEY (status_id)
    REFERENCES status (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
