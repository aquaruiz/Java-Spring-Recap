CREATE schema factory;

USE factory;

-- CREATE TABLES

CREATE TABLE product(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	name VARCHAR(255) NOT NULL,
	shortDescription TEXT,
	PRIMARY KEY (id)
);

CREATE TABLE product_detail(
	id int NOT NULL UNIQUE,
	weight float DEFAULT 0.00,
	barcodeNumber varchar(15),
	price decimal(5, 2),
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES product(id)
);

CREATE TABLE customer (
	id int NOT NULL AUTO_INCREMENT UNIQUE,
	financialId varchar(255),
	isVatRegistered BOOLEAN DEFAULT FALSE,
	vatNumber varchar(255),
	PRIMARY KEY (id)
);

CREATE TABLE customer_detail (
	id int NOT NULL UNIQUE,
	name varchar(255) NOT NULL,
	address text NOT NULL,
	contactPerson varchar(255),
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES customer(id)
);

CREATE TABLE customerOrder (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	invoiceNumber VARCHAR(10) NOT NULL,
	orderDate DATE NOT NULL,
	totalPrice DECIMAL(5, 2) NOT NULL,
	customerId INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (customerId) REFERENCES customer(id)
);

CREATE TABLE product_order (
	productId INT NOT NULL,
	orderId INT NOT NULL,
	invoiceNumber VARCHAR(10) NOT NULL,
	productQuantity INT NOT NULL DEFAULT 0,
	PRIMARY KEY (productId, orderId),
	FOREIGN KEY (productId) REFERENCES product(id),
	FOREIGN KEY (orderId) REFERENCES customerOrder(id)
);	

CREATE TABLE activity_log (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	username VARCHAR(255) DEFAULT 'Anonymous',
	description TEXT,
	editedCustomerId INT DEFAULT NULL,
	editedProductId INT DEFAULT NULL,
	editedOrderId INT DEFAULT NULL,
	date_time DATETIME DEFAULT CURRENT_TIMESTAMP(),
	PRIMARY KEY (id),
	FOREIGN KEY (editedCustomerId) REFERENCES customer(id),
	FOREIGN KEY (editedProductId) REFERENCES product(id),
	FOREIGN KEY (editedOrderId) REFERENCES customerOrder(id)
);
