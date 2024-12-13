DROP DATABASE IF EXISTS authServer;
CREATE DATABASE IF NOT EXISTS authServer;
USE authServer;

CREATE USER IF NOT EXISTS 'authUser'@'localhost' IDENTIFIED BY 'admin';
GRANT SELECT, UPDATE, INSERT, ALTER, CREATE ON authServer.* TO 'authUser'@'localhost';

CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255),
    CONSTRAINT PRIMARY KEY pk_user_id USING BTREE (id)
);

INSERT INTO users (id, email, username, password) VALUES ('test', 'test', 'Basement man', 'test');
INSERT INTO users (id, email, username, password) VALUES ('test2', 'test2', 'Basement man2', 'test');