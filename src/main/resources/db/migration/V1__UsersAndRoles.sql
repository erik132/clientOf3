DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_roles;


CREATE TABLE users(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    active int NOT NULL ,
    email VARCHAR(255) NOT NULL ,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users ( active, email, username, password) VALUES
    (1, 'tere@tali.com', 'erik', '$2a$11$uazQmzcAk9BGv.xXOfcWUujRA6La8e1Ssn9qOLi1ud7YOGPKeYdDe'),
    (2, 'rock@stone.com', 'Tormi', '$2a$11$K/AANnaFkSaYB41Pbw7DZe.DqHEJPO9Kxdxo08BtmzgG3pzExhW/W'),
    (3, 'oil@leak.com', 'Rockefeller', '$2a$11$kbXjlxyxi4m6LDqf1W1/AuBAbVnB1nyC5wmswbI.2Ql5.7kYlyp/C');

CREATE TABLE roles(
    id INT NOT NULL PRIMARY KEY ,
    role VARCHAR(255) NOT NULL
);

INSERT INTO roles (id, role) VALUES
    (1,'ADMIN'),
    (2,'STANDARD');


CREATE TABLE user_roles(
    user_id INT NOT NULL ,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO user_roles (user_id, role_id) VALUES
    (1, 2),
    (2, 2),
    (3, 2);