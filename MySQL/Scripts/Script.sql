CREATE DATABASE factory;

USE factory;

-- CREATE TABLES

CREATE TABLE product(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	name VARCHAR(255) NOT NULL,
	shortDescription TEXT,
	weight FLOAT DEFAULT 0.00,
	barcodeNumber VARCHAR(15),
	price DECIMAL(5, 2),
	PRIMARY KEY (id)
);

CREATE TABLE customer (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	financialId VARCHAR(255),
	isVatRegistered BOOLEAN DEFAULT FALSE,
	vatNumber VARCHAR(255),
	name VARCHAR(255) NOT NULL,
	address TEXT NOT NULL,
	contactPerson VARCHAR(255),
	PRIMARY KEY (id)
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

CREATE TABLE productOrder (
	productId INT NOT NULL,
	orderId INT NOT NULL,
	invoiceNumber VARCHAR(10) NOT NULL,
	productQuantity INT NOT NULL DEFAULT 0,
	PRIMARY KEY (productId, orderId),
	FOREIGN KEY (productId) REFERENCES product(id),
	FOREIGN KEY (orderId) REFERENCES customerOrder(id)
);	

CREATE TABLE customerActivityLog (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	modifiedAt DATETIME DEFAULT CURRENT_TIMESTAMP(),
	modifiedBy VARCHAR(255) DEFAULT 'Anonymous',
	eventType VARCHAR(255),
	customerId INT NOT NULL,
	description TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY (customerId) REFERENCES customer(id)
);

CREATE TABLE productActivityLog (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	modifiedAt DATETIME DEFAULT CURRENT_TIMESTAMP(),
	modifiedBy VARCHAR(255) DEFAULT 'Anonymous',
	eventType VARCHAR(255),
	productId INT DEFAULT NULL,
	description TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY (productId) REFERENCES product(id)
);

CREATE TABLE customerOrderActivityLog (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	modifiedAt DATETIME DEFAULT CURRENT_TIMESTAMP(),
	modifiedBy VARCHAR(255) DEFAULT 'Anonymous',
	eventType VARCHAR(255),
	customerOrderId INT DEFAULT NULL,
	description TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY (customerOrderId) REFERENCES customerOrder(id)
);

-- populate data in Tables

INSERT INTO product (id, name, shortDescription, weight, barcodeNumber, price)
VALUES 
	(1, 'chair', 'one very nice chair', 4.850, '012356745650', 25.50),
	(2, 'table', 'very nice kitchen table', 10.360, '012345675650', 225.50),
	(3, 'wardrobe', 'really large wardrobe', 32.100, '012345674650', 485.50),
	(4, 'sofa', 'a comforTABLE sofa', 15.685, '012346745650', 350.99),
	(5, 'bed', 'one premium size bed', 50.950, '012345674565', 860.99);

INSERT INTO customer (id, financialId, isVatRegistered, vatNumber, name, address, contactPerson)
VALUES 
	(11, '', FALSE, NULL, 'Flowers LLC', 'Pleven, ul. Skopie 56', 'Jane Doe'),
	(12, '000459797', FALSE, NULL, 'IBM LTD', 'Sofia, ul. Tsarigradsko shose 256', 'Anna Georgieva'),
	(13, NULL, TRUE, '584635416', 'Corp.', 'New York, bul. Bulgaria 001', NULL);

INSERT INTO customerOrder (id,	invoiceNumber, orderDate, totalPrice, customerId)
VALUES 
	(101, '00001', '2020-07-02', 0.2, 11),
	(102, '00005', '2020-07-20', 500, 12);

INSERT INTO productOrder (productId, orderId, invoiceNumber, productQuantity)
VALUES 
	(1, 101, '00001', 36),
	(2, 101, '00001', 6),
	(5, 101, '00001', 1),
	(1, 102, '00005', 36),
	(2, 102, '00005', 6),
	(4, 102, '00005', 1);

INSERT INTO customerOrderActivityLog (description, customerOrderId, modifiedAt, eventType)
VALUES 
	('nothing happened', 102, CURRENT_TIMESTAMP(), 'edit');

-- CREATE  search queries

DROP PROCEDURE IF EXISTS sp_get_product_info_by_part_product_name;

DELIMITER $$
CREATE PROCEDURE sp_get_product_info_by_part_product_name
(
   productName VARCHAR(255)
) 
BEGIN 
   SELECT p.id, p.name, p.shortDescription, p.weight, p.price, p.barcodeNumber 
		FROM product AS p
   		WHERE p.name LIKE CONCAT('%', productName, '%'); 
end$$
DELIMITER;

CALL sp_get_product_info_by_part_product_name('hai'); 

-- DROP PROCEDURE sp_get_product_info_by_part_product_name;

CREATE PROCEDURE sp_get_order_info_by_order_number
(
   orderNumber INT
) 
BEGIN  
	SELECT po.orderId, c.vatNumber, c.name, p.name, po.productQuantity, p.price AS 'price per unit', p.price * po.productQuantity AS 'total price' 
		FROM productOrder AS po
		JOIN product AS p
		ON p.id = po.productId 
		JOIN customerOrder AS o
		ON o.id = po.orderId 
		JOIN customer AS c
		ON c.id = o.customerId
		WHERE po.orderId = orderNumber;
END; 

CALL sp_get_order_info_by_order_number(101);

-- DROP PROCEDURE sp_get_order_info_by_orderNumber;

CREATE PROCEDURE sp_get_orders_for_last_month_by_customer_name
(
   customerName VARCHAR(255)
) 
BEGIN
	SELECT o.id AS 'ORDER id', o.totalPrice, o.orderDate, c.name AS 'customer name'
		FROM customerOrder AS o 
		JOIN customer AS c
		ON c.id = o.customerId
		WHERE c.name LIKE CONCAT('%', customerName, '%') 
		AND DATE_ADD(o.orderDate, INTERVAL 1 MONTH) > current_date();
END;

CALL sp_get_orders_for_last_month_by_customer_name('Flower');

-- DROP PROCEDURE sp_get_orders_for_last_month_by_customer_name;

CREATE VIEW sp_get_products_sold_last_month AS
	SELECT p.name AS 'product.name', sum(po.productQuantity) AS 'total quantity sold last month' 
		FROM productOrder AS po 
		JOIN product AS p
		ON po.productId = p.id 
		JOIN customerOrder AS o
		ON o.id = po.orderId 
		WHERE DATE_ADD(o.orderDate, INTERVAL 1 Month) > current_date()
		GROUP BY p.id 
		ORDER BY p.name;

SELECT * FROM sp_get_products_sold_last_month; 

-- DROP view sp_get_products_sold_last_month;

-- add indices

CREATE INDEX index_product_log
ON productActivityLog (productId);

CREATE INDEX index_customer_order_log
ON customerOrderActivityLog (customerOrderId);

CREATE INDEX index_customer_log
ON customerActivityLog (customerId);

-- Log info in logs table

CREATE PROCEDURE sp_insert_in_product_log_table(eventType VARCHAR(255), msg TEXT, productId INT)
BEGIN
	IF productId IS NOT NULL THEN 
		IF (SELECT COUNT(*) FROM product	
				WHERE product.id = productId) > 0 THEN 
       		INSERT INTO productActivityLog (eventType, description, productId) VALUES (eventType, msg, productId);
       END IF;
    END IF;   
END;


CREATE PROCEDURE sp_insert_in_customer_order_log_table(eventType VARCHAR(255), msg TEXT, customerOrderId INT)
BEGIN
	IF customerOrderId IS NOT NULL THEN 
		IF (SELECT COUNT(*) FROM customerOrder	
				WHERE customerOrderId.id = orderId) > 0 THEN 
       		INSERT INTO orderActivityLog (eventType, description, customerOrderId) VALUES (eventType, msg, customerOrderId);
       END IF;
    END IF;
END;

CREATE PROCEDURE sp_insert_in_customer_log_table(eventType VARCHAR(255), msg TEXT, customerId INT)
BEGIN	
	IF customerId IS NOT NULL THEN 
		IF (SELECT COUNT(*) FROM customer	
				WHERE customer.id = customerId) > 0 THEN 
       		INSERT INTO customerActivityLog (eventType, description, customerId) VALUES (eventType, msg, customerId);
       END IF;
    END IF;
END;

-- DROP PROCEDURE sp_insert_in_product_log_table;
-- DROP PROCEDURE sp_insert_in_order_log_table;
-- DROP PROCEDURE sp_insert_in_customer_log_table;

CALL sp_insert_in_customer_log_table('EDIT', 'customer log edited', 13);

-- insert product with transaction

START TRANSACTION;
	INSERT INTO product (id, name, shortDescription, weight, barcodeNumber, price)
	VALUES 
		(10, 'desk', 'a simple desk', 8.000, '012356745650', 140.50);

	CALL sp_insert_in_product_log_table('INSERT', "added new product", 10);
COMMIT;

-- DROP TABLE customerActivityLog;

-- DROP TABLE customerOrderActivityLog;

-- DROP TABLE productActivityLog;

-- DROP TABLE productOrder;

-- DROP TABLE customerOrder;

-- DROP TABLE product;

-- DROP TABLE customer;

-- DROP DATABASE factory; 