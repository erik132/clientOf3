DROP TABLE IF EXISTS clients;


CREATE TABLE clients(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    country_id INT NOT NULL
);

INSERT INTO CLIENTS (firstname, lastname, username, country_id) VALUES
('Peter', 'Strasser', 'HerrStrasser', 6),
('Jonne', 'Järvela', 'KorpinMetsään', 4);

CREATE TABLE COUNTRIES(
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO COUNTRIES (id, name) VALUES
    (1, 'Estonia'),
    (2, 'Latvia'),
    (3, 'Lithuania'),
    (4, 'Finland'),
    (5, 'Sweden'),
    (6, 'Germany');

CREATE TABLE client_handlers(
    user_id INT NOT NULL,
    client_id INT NOT NULL,
    PRIMARY KEY (user_id, client_id)
);

INSERT INTO client_handlers (user_id, client_id) VALUES
    (1,1),
    (1,2);