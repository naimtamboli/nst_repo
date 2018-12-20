--CREATE TABLE user_tab
--(
--   id          VARCHAR(10)            NOT NULL AUTO_INCREMENT,
--   username  VARCHAR(255),
--   password    VARCHAR(255),
--   status   VARCHAR(255),
--   PRIMARY KEY (id)
--);
INSERT INTO user_tab(username,password,status) VALUES ('naimtamboli','pass1','activated');
INSERT INTO user_tab(username,password,status) VALUES ('jack sparrow','pass1','activated');
INSERT INTO user_tab(username,password,status) VALUES ('tony stark','pass1','deactivated');

SELECT * FROM user_tab;