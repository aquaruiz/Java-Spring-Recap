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

-- populate data in Tables

INSERT INTO product (id, name, shortDescription)
VALUES 
	(1, 'chair', 'one very nice chair'),
	(2, 'table', 'very nice kitchen table'),
	(3, 'wardrobe', 'really large wardrobe'),
	(4, 'sofa', 'a comforTABLE sofa'),
	(5, 'bed', 'one premium size bed');

INSERT INTO product_detail (id, weight, barcodeNumber, price)
VALUES 
	(1, 4.850, '012356745650', 25.50),
	(2, 10.360, '012345675650', 225.50),
	(3, 32.100, '012345674650', 485.50),
	(4, 15.685, '012346745650', 350.99),
	(5, 50.950, '012345674565', 860.99);

INSERT INTO customer (id, financialId, isVatRegistered, vatNumber)
VALUES 
	(11, '', FALSE, NULL),
	(12, '000459797', FALSE, NULL),
	(13, NULL, TRUE, '584635416');

INSERT INTO customer_detail (id, name, address, contactPerson)
VALUES 
	(11, 'Flowers LLC', 'Pleven, ul. Skopie 56', 'Jane Doe'),
	(12, 'IBM LTD', 'Sofia, ul. Tsarigradsko shose 256', 'Anna Georgieva'),
	(13, 'Evil Corp.', 'New York, bul. Bulgaria 001', NULL);

INSERT INTO customerOrder (id,	invoiceNumber, orderDate, totalPrice, customerId)
VALUES 
	(101, '00001', '2020-03-02', 0.2, 11),
	(102, '00005', '2020-03-20', 500, 12);

INSERT INTO product_order (productId, orderId, invoiceNumber, productQuantity)
VALUES 
	(1, 101, '00001', 36),
	(2, 101, '00001', 6),
	(5, 101, '00001', 1),
	(1, 102, '00005', 36),
	(2, 102, '00005', 6),
	(4, 102, '00005', 1);

INSERT INTO activity_log (description, editedCustomerId, date_time)
VALUES 
	('nothing happened', 12, CURRENT_TIMESTAMP());


-- DROP TABLE product;

-- DROP TABLE customer;

-- DROP TABLE customerOrder;

-- DROP TABLE product_order;

-- DROP TABLE activity_log;

-- DROP DATABASE factory; 
