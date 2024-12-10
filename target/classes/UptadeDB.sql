DROP DATABASE IF EXISTS authServer;
CREATE DATABASE IF NOT EXISTS authServer;
USE authServer;

CREATE USER IF NOT EXISTS 'authUser'@'localhost' IDENTIFIED BY 'admin';
GRANT SELECT, UPDATE, INSERT, ALTER, CREATE ON authServer.* TO 'authUser'@'localhost';

CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    CONSTRAINT PRIMARY KEY pk_user_id USING BTREE (id)
);

CREATE TABLE IF NOT EXISTS user_2fa_rel (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    fk_user_id VARCHAR(255) NOT NULL,
    2fa_key VARCHAR(255) NOT NULL,
    CONSTRAINT FOREIGN KEY (fk_user_id) REFERENCES users(id)
);

INSERT INTO users (id, email, username) VALUES ('test', 'test', 'Basement man');