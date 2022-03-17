CREATE DATABASE red_tape_airlines;

CREATE USER 'pilot'@'localhost' IDENTIFIED BY 'boeing747';
GRANT ALL PRIVILEGES ON red_tape_airlines.* TO 'pilot'@'localhost' WITH GRANT OPTION ;