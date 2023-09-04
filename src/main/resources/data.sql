INSERT INTO user (email, first_name, last_name, password, username)
VALUES ('admin@admin.com', 'admin', 'admin', '$2a$04$rnzyO9iouYFLRMfeFFl.8eJs3XbBdxtl6N.bN5l9k.ef8OqhJB2xm', 'admin');
INSERT INTO role (description, name) VALUES ('ROLE_ADMIN', 'ADMIN');
INSERT INTO role (description, name) VALUES ('ROLE_USER', 'USER');
INSERT INTO role (description, name) VALUES ('ROLE_SUPERVISOR', 'SUPERVISOR');
INSERT INTO user_roles (user_id, role_id) VALUES ('1', '1');
INSERT INTO clientes (apellidos, email, nombres, telefono, ciudades_id)
VALUES ('Salinas', 'javier161@gmail.com', 'Javier', '0992-462-576', '1');
INSERT INTO ciudades (id, ciudad) VALUES ('1','2', 'San Antonio', 'Villa Elisa');