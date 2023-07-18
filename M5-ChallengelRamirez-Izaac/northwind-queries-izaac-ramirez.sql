Use northwind;

-- list of all the categories of products in the database
SELECT DISTINCT category 
FROM products;

-- all products made by dell
SELECT * 
FROM products 
WHERE product_name LIKE '%Dell%';

-- orders shipped from Pennsylvania
SELECt *
FROM orders
WHERE ship_state = 'Pennsylvania';

-- List of the first name and last name of all employees 
-- with last names that start with the letter W.
SELECT first_name, last_name FROM employees WHERE last_name LIKE 'W%';

-- all customers from zip codes that start with 55
SELECT * 
FROM customers 
WHERE postal_code LIKE '55%';

-- all customers from zip codes that end with 0
SELECT * 
FROM customers 
WHERE postal_code LIKE '%0';

-- the first name, last name, and email for all customers with a ".org" email address.
SELECT first_name, last_name, email 
FROM customers 
WHERE email LIKE '%.org';

-- the first name, last name, and phone number for all customers from the 202 area code.
SELECT first_name, last_name, phone 
FROM customers 
WHERE phone LIKE '1-(202)%';

-- the first name, last name, and phone number for all customers from the 202 area code, 
-- ordered by last name, first name.
SELECT first_name, last_name, phone 
FROM customers 
WHERE phone LIKE '1-(202)%' 
ORDER BY last_name, first_name;




