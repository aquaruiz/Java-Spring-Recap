CREATE DATABASE factory;

USE factory;

-- CREATE TABLES

CREATE TABLE product(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	name varchar(255) NOT NULL,
	shortDescription text DEFAULT 'none',
	PRIMARY KEY (id)
);
