-- Create table
CREATE TABLE Person (
  id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  First_name VARCHAR(150),
  Second_name VARCHAR(150),
  Birthday DATE
);


-- Insert data
INSERT INTO Person VALUES (id, 'Poul', 'Smith', '1968-08-11');
INSERT INTO Person VALUES (id, 'Julietta', 'Kapuletti', '2002-09-28');

SELECT * FROM Person;