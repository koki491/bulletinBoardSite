CREATE TABLE IF NOT EXISTS customers(id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(16), message VARCHAR(400), dt VARCHAR(20));

CREATE TABLE IF NOT EXISTS users(username VARCHAR(16) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255));
