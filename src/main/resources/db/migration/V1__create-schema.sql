CREATE TABLE IF NOT EXISTS posts(id INT PRIMARY KEY AUTO_INCREMENT, message VARCHAR(400), dt VARCHAR(20));
CREATE TABLE IF NOT EXISTS contributor(id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(16));

CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(16), encoded_password VARCHAR(255));
CREATE TABLE contributor(id INT PRIMARY KEY AUTO_INCREMENT, post_user VARCHAR(16), user_id INT);
CREATE TABLE posts(id INT PRIMARY KEY AUTO_INCREMENT, contributor_id INT, message VARCHAR(400), dt VARCHAR(20), topic_id INT);
CREATE TABLE topic(id INT PRIMARY KEY AUTO_INCREMENT, title VARCHAR(16), contents VARCHAR(32), post_num INT, category_id INT);
CREATE TABLE category(id INT PRIMARY KEY AUTO_INCREMENT, category_name VARCHAR(10));

INSERT INTO topic(title, contents, post_num, category_id) VALUES("好きなお菓子は何ですか", "あなたの好きなお菓子を教えてください", 0, 1);
INSERT INTO category(id, category_name)VALUES (1, "#雑談");

INSERT INTO topic(title, contents, post_num, category_id) VALUES("ステイホームの過ごし方", "緊急事態宣言中なにをして過ごしましたか", 0, 2);
INSERT INTO category(id, category_name)VALUES (2, "#コロナ");
