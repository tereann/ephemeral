INSERT INTO users (username,password,enabled)
VALUES ('admin','{bcrypt}$2a$10$wY9T45SRAkZy1zGKaBRDhecgBHgUG8IXqgdCcuvUnxzwhNn4i4jsK',1);

INSERT INTO authorities (username,authority) VALUES ('admin','ROLE_ADMIN');