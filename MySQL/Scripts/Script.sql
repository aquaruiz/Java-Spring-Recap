CREATE DATABASE factory;

USE factory;

-- CREATE TABLES

CREATE TABLE product(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	name VARCHAR(255) NOT NULL,
	shortDescription TEXT,
	PRIMARY KEY (id)
);

CREATE TABLE productDetail(
	productId INT NOT NULL UNIQUE,
	weight FLOAT DEFAULT 0.00,
	barcodeNumber VARCHAR(15),
	price DECIMAL(5, 2),
	PRIMARY KEY (productId),
	FOREIGN KEY (productId) REFERENCES product(id)
);

CREATE TABLE customer (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	financialId VARCHAR(255),
	isVatRegistered BOOLEAN DEFAULT FALSE,
	vatNumber VARCHAR(255),
	PRIMARY KEY (id)
);

CREATE TABLE customerDetail (
	customerId INT NOT NULL UNIQUE,
	name VARCHAR(255) NOT NULL,
	address TEXT NOT NULL,
	contactPerson VARCHAR(255),
	PRIMARY KEY (customerId),
	FOREIGN KEY (customerId) REFERENCES customer(id)
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

CREATE TABLE activityLog (
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	username VARCHAR(255) DEFAULT 'Anonymous',
	description TEXT,
	editedCustomerId INT DEFAULT NULL,
	editedProductId INT DEFAULT NULL,
	editedOrderId INT DEFAULT NULL,
	dateTime DATETIME DEFAULT CURRENT_TIMESTAMP(),
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

INSERT INTO productDetail (id, weight, barcodeNumber, price)
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

INSERT INTO customerDetail (id, name, address, contactPerson)
VALUES 
	(11, 'Flowers LLC', 'Pleven, ul. Skopie 56', 'Jane Doe'),
	(12, 'IBM LTD', 'Sofia, ul. Tsarigradsko shose 256', 'Anna Georgieva'),
	(13, 'Evil Corp.', 'New York, bul. Bulgaria 001', NULL);

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

INSERT INTO activityLog (description, editedCustomerId, dateTime)
VALUES 
	('nothing happened', 12, CURRENT_TIMESTAMP());

-- CREATE some Views

CREATE VIEW v_get_products_data AS
	SELECT p.id, p.name, p.shortDescription, pd.weight, pd.price, pd.barcodeNumber 
		FROM product AS p
		JOIN productDetail AS pd
		ON p.id = pd.id;

SELECT * FROM v_get_products_data; 

CREATE VIEW v_get_customers_data AS
	SELECT c.id, cd.name, c.financialId, c.vatNumber, cd.address, cd.contactPerson 
		FROM customer AS c 
		JOIN customerDetail AS cd 
		ON c.id = cd.id;

SELECT * FROM v_get_customers_data; 

-- CREATE  search queries

DROP PROCEDURE IF EXISTS sp_get_product_info_by_part_product_name;

DELIMITER $$
CREATE PROCEDURE sp_get_product_info_by_part_product_name
(
   productName VARCHAR(255)
) 
BEGIN 
   SELECT * FROM get_products_data 
   WHERE name LIKE CONCAT('%', productName, '%'); 
end$$
DELIMITER;

CALL get_product_info_by_part_product_name('hai'); 

-- DROP PROCEDURE sp_get_product_info_by_part_product_name;

CREATE PROCEDURE sp_get_order_info_by_order_number
(
   orderNumber INT
) 
BEGIN  
	SELECT po.orderId, c.vatNumber, cd.name, p.name, po.productQuantity, pd.price AS 'price per unit', pd.price * po.productQuantity AS 'total price' 
		FROM productOrder AS po
		JOIN product AS p
		ON p.id = po.productId 
		JOIN productDetail AS pd
		ON p.id = pd.id 
		JOIN customerOrder AS o
		ON o.id = po.orderId 
		JOIN customer AS c
		ON c.id = o.customerId
		JOIN customerDetail AS cd
		ON cd.id  = c.id
		WHERE po.orderId = orderNumber;
END; 

CALL sp_get_order_info_by_order_number(101);
  
-- DROP PROCEDURE sp_get_order_info_by_orderNumber;

CREATE PROCEDURE sp_get_orders_for_last_month_by_customer_name
(
   customerName VARCHAR(255)
) 
BEGIN
	SELECT o.id AS 'ORDER id', o.totalPrice, o.orderDate, cd.name AS 'customer name'
		FROM customerOrder AS o 
		JOIN customerDetail AS cd
		ON cd.id = o.customerId
		WHERE cd.name LIKE CONCAT('%', customerName, '%') 
		AND DATE_ADD(o.orderDate, INTERVAL 1 MONTH) > current_date();
END;

CALL sp_get_orders_for_last_month_by_customer_name('Flower');

-- DROP PROCEDURE sp_get_orders_for_last_month_by_customer_name;

CREATE VIEW sp_get_products_sold_last_month AS
	SELECT p.name AS 'product.name', sum(po.productQuantity) AS 'total quantity sold last month' 
		FROM productOrder AS po 
		JOIN productDetail AS pd
		ON pd.id = po.productId 
		JOIN product AS p
		ON p.id = pd.id 
		JOIN customerOrder AS o
		ON o.id = po.orderId 
		WHERE DATE_ADD(o.orderDate, INTERVAL 1 Month) > current_date()
		GROUP BY pd.id 
		ORDER BY p.name;

SELECT * FROM sp_get_products_sold_last_month; 

-- DROP view sp_get_products_sold_last_month;

-- add indices

CREATE INDEX index_product
ON productDetail (id);

CREATE INDEX indexOrder
ON productOrder (orderId, productId);

-- Log info in logs table

CREATE PROCEDURE sp_insert_in_log_table(msg TEXT, customerId INT, productId INT, orderId INT)
BEGIN
	IF customerId IS NOT NULL THEN 
		IF (SELECT COUNT(*) FROM customer	
				WHERE customer.id = customerId) > 0 THEN 
        	INSERT INTO activityLog (description, editedCustomerId) VALUES (msg, customerId);
        END IF;
    END IF;
   
	IF productId IS NOT NULL THEN 
		IF (SELECT COUNT(*) FROM product	
				WHERE product.id = productId) > 0 THEN 
       		INSERT INTO activityLog (description, editedProductId) VALUES (msg, productId);
       END IF;
    END IF;
   
	IF orderId IS NOT NULL THEN 
		IF (SELECT COUNT(*) FROM customerOrder
				WHERE customerOrder.id = orderId) > 0 THEN 
	        INSERT INTO activityLog (description, editedOrderId) VALUES (msg, orderId);
       END IF;
    END IF;
END;

-- DROP PROCEDURE sp_insert_in_log_table;

CALL sp_insert_in_log_table('log edited', 00000, 1, 00000);

-- insert product with transaction

START TRANSACTION;
	INSERT INTO product (id, name, shortDescription)
	VALUES 
		(10, 'desk', 'a simple desk');
	
	INSERT INTO productDetail (id, weight, barcodeNumber, price)
	VALUES 
		(10, 8.000, '012356745650', 140.50);
COMMIT;

-- DROP TABLE product;

-- DROP TABLE customer;

-- DROP TABLE customerOrder;

-- DROP TABLE productOrder;

-- DROP TABLE activityLog;

-- DROP DATABASE factory; 
