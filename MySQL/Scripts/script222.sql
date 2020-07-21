CREATE schema factory;

USE factory;

-- CREATE TABLES

CREATE TABLE product(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	name varchar(255) NOT NULL,
	shortDescription text DEFAULT 'none',
	PRIMARY KEY (id)
);

CREATE TABLE product_detail(
	id int NOT NULL UNIQUE,
	weight float DEFAULT 0.00,
	barcodeNumber varchar(20),
	price decimal(5, 2),
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES products(id)
);

CREATE TABLE customer (
	id int NOT NULL AUTO_INCREMENT UNIQUE,
	financialId varchar(255),
	vatNumber varchar(255),
	PRIMARY KEY (id)
);

CREATE TABLE customer_detail (
	id int NOT NULL UNIQUE,
	name varchar(255) NOT NULL,
	address text NOT NULL,
	contactPerson varchar(255),
	PRIMARY KEY (id),
	FOREIGN KEY (id) REFERENCES customers(id)
);

CREATE TABLE orders (
	id int NOT NULL AUTO_INCREMENT UNIQUE,
	orderDate date NOT NULL,
	totalPrice decimal(5, 2) NOT NULL,
	customerId int NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (customerId) REFERENCES customers(id)
);

CREATE TABLE product_order (
	productId int NOT NULL,
	orderId int NOT NULL,
	productQuantity int NOT NULL DEFAULT 0,
	PRIMARY KEY (productId, orderId),
	FOREIGN KEY (productId) REFERENCES products(id),
	FOREIGN KEY (orderId) REFERENCES orders(id)
);

CREATE TABLE activity_log (
	id int NOT NULL AUTO_INCREMENT UNIQUE,
	username varchar(255) DEFAULT 'Anonymous',
	description text,
	editedCustomerId int DEFAULT NULL,
	editedProductId int DEFAULT NULL,
	editedOrderId int DEFAULT NULL,
	date_time Datetime DEFAULT CURRENT_TIMESTAMP(),
	PRIMARY KEY (id),
	FOREIGN KEY (editedCustomerId) REFERENCES customers(id),
	FOREIGN KEY (editedProductId) REFERENCES products(id),
	FOREIGN KEY (editedOrderId) REFERENCES orders(id)
);

-- populate data in Tables

INSERT INTO products (id, name, shortDescription)
VALUES 
	(1, 'chair', 'one very nice chair'),
	(2, 'table', 'very nice kitchen table'),
	(3, 'wardrobe', 'really large wardrobe'),
	(4, 'sofa', 'a comforTABLE sofa'),
	(5, 'bed', 'one premium size bed');

INSERT INTO products_details (id, weight, barcodeNumber, price)
VALUES 
	(1, 4.850, '012356745650', 25.50),
	(2, 10.360, '012345675650', 225.50),
	(3, 32.100, '012345674650', 485.50),
	(4, 15.685, '012346745650', 350.99),
	(5, 50.950, '012345674565', 860.99);


INSERT INTO customers (id, financialId, vatNumber)
VALUES 
	(11, '', NULL),
	(12, '000459797', NULL),
	(13, NULL, '584635416');

INSERT INTO customers_details (id, name, address, contactPerson)
VALUES 
	(11, 'Flowers LLC', 'Pleven, ul. Skopie 56', 'Jane Doe'),
	(12, 'IBM LTD', 'Sofia, ul. Tsarigradsko shose 256', 'Anna Georgieva'),
	(13, 'Evil Corp.', 'New York, bul. Bulgaria 001', NULL);

INSERT INTO orders (id,	orderDate, totalPrice, customerId)
VALUES 
	(101, '2020-03-02', 0.2, 11),
	(102, '2020-03-20', 2500, 12);

INSERT INTO products_orders (productId, orderId, productQuantity)
VALUES 
	(1, 101, 36),
	(2, 101, 6),
	(5, 101, 1),
	(1, 102, 36),
	(2, 102, 6),
	(4, 102, 1);

INSERT INTO activity_log (description, editedCustomerId, date_time)
VALUES 
	('nothing happened', 12, CURRENT_TIMESTAMP());

-- CREATE some Views

CREATE VIEW get_products_data AS
SELECT p.id, p.name, p.shortDescription, pd.weight, pd.price, pd.barcodeNumber FROM products AS p
JOIN products_details AS pd
ON p.id = pd.id;

SELECT * FROM get_products_data; 

CREATE VIEW get_customers_data AS
SELECT c.id, cd.name, c.financialId, c.vatNumber, cd.address, cd.contactPerson FROM customers c 
JOIN customers_details cd 
ON c.id = cd.id;

SELECT * FROM get_customers_data; 

-- CREATE  search queries
USE factory;
DROP PROCEDURE IF EXISTS get_product_info_by_part_product_name;

DELIMITER $$
CREATE PROCEDURE get_product_info_by_part_product_name
(
   product_name varchar(255)
) 
BEGIN 
   SELECT * FROM get_products_data 
   WHERE name LIKE concat('%', product_name, '%'); 
end$$
DELIMITER ;

CALL get_product_info_by_part_product_name('hai'); 

-- DROP PROCEDURE get_product_info_by_part_product_name;

CREATE PROCEDURE get_order_info_by_order_number
(
   order_number int
) 
BEGIN  
	SELECT po.orderId, c.vatNumber, cd.name, p.name, po.productQuantity, pd.price AS 'price per unit', pd.price * po.productQuantity AS 'total price' FROM products_orders po
	JOIN products p
	ON p.id = po.productId 
	JOIN products_details pd
	ON p.id = pd.id 
	JOIN orders o
	ON o.id = po.orderId 
	JOIN customers c
	ON c.id = o.customerId
	JOIN customers_details cd
	ON cd.id  = c.id
	WHERE po.orderId = order_number;
END; 

CALL get_order_info_by_order_number(101);
  
-- DROP PROCEDURE get_order_info_by_order_number;

CREATE PROCEDURE get_orders_for_last_month_by_customer_name
(
   customer_name varchar(255)
) 
BEGIN
	SELECT o.id AS 'ORDER id', o.totalPrice, o.orderDate, cd.name AS 'customer name' FROM orders o 
	JOIN customers_details cd
	ON cd.id = o.customerId
	WHERE cd.name LIKE concat('%', customer_name, '%') 
	AND DATE_ADD(o.orderDate, INTERVAL 1 Month) > current_date();
END;

CALL get_orders_for_last_month_by_customer_name('flower');

-- DROP PROCEDURE get_orders_for_last_month_by_customer_name;

CREATE VIEW get_products_sold_last_month AS
	SELECT p.name AS 'product.name', sum(po.productQuantity) AS 'total quantity sold last month' FROM products_orders po 
	JOIN products_details pd
	ON pd.id = po.productId 
	JOIN products p
	ON p.id = pd.id 
	JOIN orders o
	ON o.id = po.orderId 
	WHERE DATE_ADD(o.orderDate, INTERVAL 1 Month) > current_date()
	GROUP BY pd.id 
	ORDER BY p.name;

-- DROP view get_products_sold_last_month;

SELECT * FROM get_products_sold_last_month; 

-- creade indices

CREATE INDEX index_products
ON products_details (id);

CREATE INDEX index_orders
ON products_orders (orderId);

-- log info in logs table

CREATE PROCEDURE insert_in_log_table(msg text, customerId int, productId int, orderId int)
BEGIN
	IF customerId IS NOT NULL THEN 
		IF (SELECT count(*) FROM customers	
			WHERE customers.id = customerId) > 0 THEN 
        	INSERT INTO activity_log (description, editedCustomerId) VALUES (msg, customerId);
        END IF;
    END IF;
   
	IF productId IS NOT NULL THEN 
		IF (SELECT count(*) FROM products	
			WHERE products.id = productId) > 0 THEN 
       		INSERT INTO activity_log (description, editedProductId) VALUES (msg, productId);
       END IF;
    END IF;
   
	IF orderId IS NOT NULL THEN 
		IF (SELECT count(*) FROM orders	
			WHERE orders.id = orderId) > 0 THEN 
	        INSERT INTO activity_log (description, editedOrderId) VALUES (msg, orderId);
       END IF;
    END IF;
END;

-- DROP PROCEDURE insert_in_log_table;

CALL insert_in_log_table('log edited', 00000, 1, 00000);

-- DROP DATABASE factory; 

-- DROP TABLE products;

-- DROP TABLE customers;

-- DROP TABLE orders;

-- DROP TABLE products_orders;

-- DROP TABLE activity_log;