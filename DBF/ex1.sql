drop database if exists sql_ex_1;

create database sql_ex_1;

use sql_ex_1;

CREATE TABLE BRANDS (
  ID INT(11) PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(50) DEFAULT NULL
);

CREATE TABLE CATEGORIES (
  ID INT(11) PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(50) DEFAULT NULL
);

CREATE TABLE PRODUCTS (
  ID INT(11) PRIMARY KEY AUTO_INCREMENT,
  CATEGORY_ID INT(11) DEFAULT NULL,
  NAME VARCHAR(50) DEFAULT NULL,
  BRAND_ID INT(11) DEFAULT NULL,
  DESCRIPTION VARCHAR(255) DEFAULT NULL,
  QUANTITY_PER_UNIT VARCHAR(255) DEFAULT NULL,
  UNIT_PRICE DOUBLE DEFAULT NULL,
  PICTURE VARCHAR(255) DEFAULT NULL,
  DISCOUNT DOUBLE DEFAULT NULL
) ;

CREATE TABLE CUSTOMERS (
	ID INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(50),
	EMAIL VARCHAR(50) UNIQUE,
	PASSWORD VARCHAR(255),
	PHONE VARCHAR(50) UNIQUE,
	ADDRESS VARCHAR(50),
	CITY VARCHAR(50),
	STATE VARCHAR(50),
	COUNTRY VARCHAR(50)
);

CREATE TABLE ORDERS(
	ID INT PRIMARY KEY AUTO_INCREMENT,
	CUSTOMER_ID INT,
	ORDER_DATE DATETIME,
	STATUS VARCHAR(10) DEFAULT 'PENDING'
);

CREATE TABLE LINE_ITEMS (
	ORDER_ID INT NOT NULL,
	PRODUCT_ID INT NOT NULL,
	QUANTITY INT,
	UNIT_PRICE DOUBLE,
	PRIMARY KEY(ORDER_ID, PRODUCT_ID),
	FOREIGN KEY(ORDER_ID) REFERENCES ORDERS(ID),
	FOREIGN KEY(PRODUCT_ID) REFERENCES PRODUCTS(ID)
);

INSERT INTO brands (id, name) VALUES(1, 'Fresho');
INSERT INTO brands (id, name) VALUES(2, 'Malnad');
INSERT INTO brands (id, name) VALUES(3, 'Zespri');

INSERT INTO categories (id, name) VALUES(1, 'Vegitables');
INSERT INTO categories (id, name) VALUES(2, 'Fruits');

INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (1, 1, 'Onion', 1, 'Onion - Medium', '1 KG, approx. 10 to 12 nos', 45, '10000148_13-fresho-onion-medium.jpg', 22);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (2, 1, 'Potato', 1, 'Potato', '1 KG, approx. 9 to 10 nos', 25, '10000159_14-fresho-potato.jpg', 2);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (3, 1, 'Tomato', 2, 'Hybrid tomato', '500 GM, approx. 6 to 7 nos', 28, '10000201_12-fresho-tomato-hybrid.jpg', 12);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (4, 1, 'Ladies finger', 1, 'Ladies Finger', '250 GM', 18, '10000143_13-fresho-ladies-finger.jpg', 24);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (5, 1, 'Carrot', 2, 'Carrot local', '500 GM, approx. 7 to 8 nos', 36, '10000071_13-fresho-carrot-local.jpg', 16);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (6, 2, 'Apple', 2, 'Apple shimla', 'Half dozen, 6 nos', 110, '20001477_15-fresho-apple-shimla.jpg', 1);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (7, 2, 'Banana', 2, 'Banana Yelakki', '500 GM, approx 8 to 9 nos', 29, '10000033_19-fresho-banana-yelakki.jpg', 18);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (8, 2, 'Pomegranate', 1, 'Pomegranate - Kesar', '1 KG, approx. 4 to 5 nos', 141, '10000269_12-fresho-pomegranate-kesar.jpg', 1);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (9, 1, 'Capsicum', 2, 'Capsicum Hybrid Green', '250 GM, approx. 2 to 3 nos', 13, '10000068_17-fresho-capsicum-hybrid-green.jpg', 5);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (10, 1, 'Ginger', 2, 'Fresh Ginger - Grade A', '100 GM', 9, '10000117_14-fresho-fresh-ginger-grade-a.jpg', 3);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (11, 1, 'Cauliflower', 2, 'Cauliflower medium', '1 Pc, approx. 400 to 600 GM', 39, '10000074_14-fresho-cauliflower-medium.jpg', 18);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (12, 1, 'Chillies', 2, 'Green Chillies big - Grade A', '100 GM', 5, '10000081_15-fresho-chilli-green-big-grade-a.jpg', 16);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (13, 1, 'Cucumber', 2, 'Cucumber local', '500 GM, approx. 2 to 3 nos', 11, '10000103_14-fresho-cucumber.jpg', 5);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (14, 1, 'Lemon', 2, 'Fresh lemon', '100 GM, approx. 3 to 4 nos', 16, '10000126_13-fresho-lemon.jpg', 1);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (15, 1, 'Coconut', 2, 'Coconut medium', '1 Pc, approx. 400 to 600 GM', 20, '10000093_15-fresho-coconut-medium.jpg', 9);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (16, 1, 'Cabbage', 2, 'Cabbage small - Grade A', '1 Pc, approx. 700 to 800 GM', 20, '10000066_21-fresho-cabbage-small-grade-a.jpg', 18);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (17, 1, 'Beans', 2, 'Fresh beans - french ring', '250 GM', 31, '10000043_31-fresho-beans-french-ring.jpg', 1);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (18, 1, 'Garlic', 2, 'Fresh garlic - white', '100 GM', 20, '10000114_14-fresho-fresh-garlic.jpg', 3);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (19, 1, 'Brinjal', 1, 'Brinjal - bottle shaped', '500 GM, approx. 2 to 3 nos', 24, '10000054_14-fresho-brinjal-bottle-shape.jpg', 19);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (20, 2, 'Water melon', 1, 'Water melon Kiran', '1 Pc, approx. 1.5 to 2 KG', 34, '10000207_13-fresho-water-melon-kiran.jpg', 11);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (21, 2, 'Mosambi', 1, 'Mosambi', '1 KG, approx. 5 to 6 nos', 60, '10000192_13-fresho-mosambi.jpg', 12);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (22, 1, 'Ridge Gourd', 1, 'Ridge Gourd - Medium', '500 GM, approx. 3 to 4 nos', 27, '10000176_13-fresho-ridge-gourd.jpg', 9);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (23, 1, 'Beetroot', 1, 'Beetroot - Grade A', '250 GM, approx. 2 to 3 nos', 11, '10000047_18-fresho-beetroot-grade-a.jpg', 12);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (24, 2, 'Kiwi', 3, 'Kiwi, Green', '1 Pc', 34, '40024625_2-zespri-kiwi-green.jpg', 19);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (25, 2, 'Orange', 1, 'Orange - Nagpur', '500 GM, approx. 2 to 3 nos', 16, '10000267-2_8-fresho-orange-nagpur.jpg', 13);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (26, 1, 'Methi', 2, 'Fresh methi', '200 GM', 29, '10000388_9-fresho-methi.jpg', 17);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (27, 1, 'Spring onion', 1, 'Spring Onion', '1 Pc', 13, '10000377_13-fresho-spring-onion.jpg', 9);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (28, 2, 'Banana', 3, 'Banana - Robusta', '500 GM, approx. 3 to 4 nos', 14, '10000027_19-fresho-banana-robusta.jpg', 22);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (29, 2, 'Guava', 1, 'Guava', '500 GM, approx. 4 to 5 nos', 39, '10000370_11-fresho-guava.jpg', 21);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (30, 1, 'Curry Leaves', 2, 'Curry Leaves - Grade A', '100 GM', 8, '10000104_15-fresho-curry-leaves-grade-a.jpg', 25);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (31, 1, 'Carrot', 1, 'Carrot English', '250 GM', 19, '10000270_12-fresho-carrot-english.jpg', 11);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (32, 1, 'Raw Banana', 1, 'Raw Banana - Green', '250 GM, approx. 2 to 3 nos', 13, '10000169_12-fresho-raw-banana-green.jpg', 0);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (33, 1, 'Bitter Gourd', 1, 'Bitter Gourd', '250 GM, approx. 1 to 2 nos', 11, '10000050_16-fresho-bitter-gourd.jpg', 21);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (34, 1, 'Sweet Corn', 1, 'Sweet Corn - Grade A', '2 Pc pouch', 23, '40004992_13-fresho-sweet-corn-grade-a.jpg', 15);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (35, 2, 'Pomegranate', 1, 'Pomegranate - pealed', '200 GM tray', 45, '40005823_6-fresho-pomegranate-peeled.jpg', 10);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (36, 1, 'Tomato', 1, 'Tomato Local - Organically grown', '500 GM', 37, '40022638_3-fresho-tomato-local-organically-grown.jpg', 21);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (37, 1, 'Pumpkin', 1, 'Pumpkin Green - Grade A', '500 GM', 23, '10000163_14-fresho-pumpkin-green-grade-a.jpg', 3);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (38, 1, 'Colocasia', 1, 'Colocasia - Grade A', '250 GM', 13, '10000095_15-fresho-colocasia-grade-a.jpg', 18);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (39, 2, 'Avocado', 3, 'Avocado', '500 GM, approx. 1 to 2 nos', 54, '10000013_18-fresho-avocado.jpg', 10);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (40, 1, 'Sweet Potato', 1, 'Sweet Potato', '500 GM, approx. 4 to 5 nos', 29, '10000195_12-fresho-sweet-potato.jpg', 21);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (41, 1, 'Karamani', 1, 'Karamani - White', '200 GM', 35, '40021630_1-fresho-karamani-white.jpg', 0);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (42, 1, 'Carrot', 1, 'Carrot - Sliced', '200 GM tray', 25, '40005782_4-fresho-carrot-sliced.jpg', 11);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (43, 1, 'Chutney Mix', 1, 'Chutney Mix', '150 GM', 20, '40025988_2-fresho-chutney-mix.jpg', 22);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (44, 1, 'Corn', 3, 'Corn kernels', '150 GM pouch', 51, '40023465_4-supa-corn-kernels.jpg', 0);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (45, 1, 'Chow Chow', 1, 'Chow Chow - Diced', '300 GM tray', 15, '40005795_2-fresho-chow-chow-diced.jpg', 21);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (46, 1, 'Chillies', 1, 'Green Chillies - chopped', '100 GM tray', 15, '40005802_7-fresho-green-chilly-chopped.jpg', 12);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (47, 1, 'Korma Pack', 1, 'Korma Pack for 2', '1 nos', 70, '40005888_5-fresho-korma-pack-for-2.jpg', 19);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (48, 1, 'Snake gourd', 1, 'Snake gourd - Diced', '300 GM tray', 22, '20004773_2-fresho-snake-gourd-diced.jpg', 4);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (49, 1, 'Potato', 1, 'Potato - Organically grown', '1 KG', 28, '40023476_3-fresho-potato-organically-grown.jpg', 13);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (50, 1, 'Onion', 1, 'Sambhar Onion - Grade A', '250 GM', 35, '10000178_10-fresho-sambhar-onion-grade-a.jpg', 4);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (51, 2, 'Apple', 1, 'Apple Fuji', 'Half dozen, 6 nos', 226, '40033815_2-fresho-apple-fuji.jpg', 7);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (52, 2, 'Pineapple', 1, 'Pineapple - Grade A', '1 Pc', 30, '10000156_13-fresho-pineapple-grade-a.jpg', 11);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (53, 2, 'Custard Apple', 1, 'Custard Apple', '500 GM, approx. 2 to 3 nos', 39, '10000349_13-fresho-custard-apple.jpg', 10);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (54, 2, 'Banana', 1, 'Banana - Nendran', '500 GM, approx. 2 to 3 nos', 38, '10000345_15-fresho-banana-nendran.jpg', 23);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (55, 2, 'Apple', 1, 'Apple - Washinton', 'Half dozen, 6 nos', 163, '40033824-2_1-fresho-apple-washington.jpg', 20);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (56, 1, 'Garlic', 1, 'Garlic - Pealed', '100 GM', 29, '40010687_2-fresho-garlic-peeled.jpg', 24);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (57, 1, 'Lemon', 1, 'Lemon - Organically grown', '4 Pcs', 13, '40023481_3-fresho-lemon-organically-grown.jpg', 11);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (58, 2, 'Kiwi', 3, 'Kiwi - Green', '3 Pcs', 101, '40025341_2-zespri-kiwi-green.jpg', 22);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (59, 1, 'Capsicum', 3, 'Capsicum - Red', '250 GM, approx. 2 to 3 nos', 32, '10000173_9-fresho-capsicum-aaa-red.jpg', 23);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (60, 1, 'Baby Corn', 1, 'Baby Corn - Pealed, Grade A', '100 GM', 20, '10000016_14-fresho-baby-corn-peeled-grade-a.jpg', 10);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (61, 1, 'Sprouts', 1, 'Sprouts - Mixed Gram', '200 GM', 25, '10000355_10-fresho-sprouts-mixed-gram.jpg', 18);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (62, 2, 'Banana', 3, 'Banana - Red, Organically growan', '4 Pcs', 75, '40051286_1-healthy-buddha-organic-banana-red.jpg', 4);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (63, 1, 'Chow Chow', 1, 'Chow Chow - Grade A', '500 GM', 10, '10000088_13-fresho-chow-chow-grade-a.jpg', 2);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (64, 1, 'Ash Gourd', 1, 'Cut - Ash Gourd', '500 GM', 15, '40050704_1-fresho-cut-ash-gourd.jpg', 24);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (65, 1, 'Pumkin', 1, 'Pumkin Green - Cut', '500 GM', 13, '40050087_1-fresho-cut-pumkin-green.jpg', 6);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (66, 1, 'Cauliflower', 1, 'Cauliflower - Florets, 1 no Tray', '500 GM tray', 39, '40005791_8-fresho-cauliflower-florets.jpg', 22);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (67, 1, 'Capsicum', 1, 'Capsicum Yellow', '250 GM, approx. 1 to 2 nos', 31, '10000209_11-fresho-capsicum-yellow.jpg', 8);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (68, 1, 'Yam', 1, 'Elephant Foot Yam', '250 GM', 16, '40004385_10-fresho-elephant-foot-yam.jpg', 11);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (69, 2, 'Plums', 3, 'Plums - Imported', '500 GM', 172, '10000577_10-fresho-plums-imported.jpg', 12);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (70, 2, 'Pear', 3, 'Ya Pear Shandong', '500 GM, approx. 2 to 3 nos', 70, '10250152_13-fresho-ya-pear-shandong.jpg', 11);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (71, 2, 'Sapota', 1, 'Sapota Round (Large) - Grade A', '500 GM, approx. 4 to 5 nos', 41, '10000181_10-fresho-sapota-round-large-grade-a.jpg', 15);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (72, 2, 'Mango', 1, 'Mango - Raw', '250 GM', 34, '40004384_10-fresho-mango-raw.jpg', 7);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (73, 2, 'Pineapple', 1, 'Pineapple - Sliced', '1 Pc', 26, '40005839_4-fresho-pineapple-sliced.jpg', 15);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (74, 1, 'Knol Khol', 1, 'Knol Khol', '250 GM', 14, '10000277_13-fresho-knol-khol.jpg', 11);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (75, 1, 'Sweet Corn', 1, 'Sweet Corn pellets', '250 GM', 16, '10000693_9-fresho-sweet-corn-pellets.jpg', 2);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (76, 2, 'Watermelon', 1, 'Watermelon - Diced', '200 GM tray', 15, '40005852_6-fresho-watermelon-diced.jpg', 16);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (77, 2, 'Papaya', 1, 'Papaya - Diced', '200 GM tray', 15, '40019380_3-fresho-diced-papaya.jpg', 17);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (78, 2, 'Sapota', 1, 'Sapota - Organically Grown', '500 GM', 41, '40022646_3-fresho-sapota-organically-grown.jpg', 8);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (79, 1, 'Cucumber', 1, 'Cucumber Color - Grade A', '500 GM, approx. 2 to 3 nos', 30, '10000101_6-fresho-cucumber-color-grade-a.jpg', 12);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (80, 2, 'Orange', 1, 'Baby Orange', '500 GM', 150, '20003956_1-fresho-baby-orange.jpg', 13);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (81, 2, 'Grapes', 3, 'Grapes Red globe', '500 GM', 208, '10000594_2-fresho-grapes-red-globe.jpg', 4);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (82, 1, 'Coconut', 1, 'Coconut - Organically Grown', '1 Pc', 19, '40023478_3-fresho-coconut-organically-grown.jpg', 7);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (83, 2, 'Pears', 3, 'Pears - Red', 'Half dozen, 6 nos', 322, '40048955_1-usa-pears-red.jpg', 7);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (84, 1, 'Mushrooms', 1, 'Mushrooms - Button', '200 GM', 45, '10000273_11-fresho-mushrooms-button.jpg', 24);
INSERT INTO products (id, category_id, name, brand_id, description, quantity_per_unit, unit_price, picture, discount) VALUES (85, 1, 'Cabbage', 1, 'Cabbage - Red', '500 GM', 41, '10000171_11-fresho-cabbage-red.jpg', 4);


insert into customers values(null, 'Vinod Kumar', 'vinod@vinod.co', 'ea847988ba59727dbf4e34ee75726dc3', '9731424784', 'ISRO layout', 'Bangalore', 'Karnataka', 'India' );
insert into customers values(null, 'John Doe', 'johndoe@mailinator.com', '71d2b7b280078f9503e5b39a93a2f137', '5551212345', NULL, 'Dallas', 'Texas', 'USA' );
