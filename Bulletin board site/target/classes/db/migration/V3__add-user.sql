CREATE TABLE IF NOT EXISTS users(username VARCHAR(16) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255));

INSERT INTO users(username, encoded_password) VALUES ('user1', 'ce5f8d0c5790bf82e9b253d362feb51ba02853301ae24149b260bd30acb00f1b2a0d8b18bbff97a9');
INSERT INTO users(username, encoded_password) VALUES ('user2', 'ce5f8d0c5790bf82e9b253d362feb51ba02853301ae24149b260bd30acb00f1b2a0d8b18bbff97a9');
INSERT INTO users(username, encoded_password) VALUES ('user3', 'ce5f8d0c5790bf82e9b253d362feb51ba02853301ae24149b260bd30acb00f1b2a0d8b18bbff97a9');
