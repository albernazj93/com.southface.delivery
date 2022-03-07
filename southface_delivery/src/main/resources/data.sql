INSERT INTO PRODUCTS (id, name, quantity) values (1, 'Chair', 50);
INSERT INTO PRODUCTS(id, name, quantity) values (2, 'Table', 15);
INSERT INTO PRODUCTS(id, name, quantity) values (3, 'Monitor', 150);
INSERT INTO PRODUCTS(id, name, quantity) values (4, 'Keyboard', 300);

INSERT INTO DELIVERIES(id, address, eircode) values (1, '2 The Avenue', 'F87K987');
INSERT INTO DELIVERIES(id, address, eircode) values (2, '39 The Walk', 'F36F675');
INSERT INTO DELIVERIES(id, address, eircode) values (3, '12 The Bridge', 'G459P87');
INSERT INTO DELIVERIES(id, address, eircode) values (4, '6 The Drive', 'F78R342');

INSERT INTO DELIVERY_PRODUCTS(delivery_id, product_id) values (1, 1);
INSERT INTO DELIVERY_PRODUCTS(delivery_id, product_id) values (1, 2);
INSERT INTO DELIVERY_PRODUCTS(delivery_id, product_id) values (2, 3);
INSERT INTO DELIVERY_PRODUCTS(delivery_id, product_id) values (2, 4);
INSERT INTO DELIVERY_PRODUCTS(delivery_id, product_id) values (3, 4);
INSERT INTO DELIVERY_PRODUCTS(delivery_id, product_id) values (4, 2);