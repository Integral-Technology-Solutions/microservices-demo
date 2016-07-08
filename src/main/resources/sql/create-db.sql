CREATE SCHEMA company;

CREATE TABLE company.person (
  id VARCHAR(30) NOT NULL PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  email  VARCHAR(50)
);

CREATE TABLE company.position (
  id VARCHAR(30) NOT NULL PRIMARY KEY,
  title VARCHAR(30),
  level VARCHAR(30),
  salary  DOUBLE
);

CREATE TABLE company.person_position (
  id VARCHAR(30) NOT NULL PRIMARY KEY,
  position_id  VARCHAR(30),
  person_id VARCHAR(30),
  start_date datetime NOT NULL,
  end_date datetime NOT NULL,
  FOREIGN KEY (position_id) REFERENCES position(id),
  FOREIGN KEY (person_id) REFERENCES person(id)
);

