INSERT INTO user(login,coducm,dir, is_player, isucm, name, password, phone, roles) VALUES ('milagros@gmail.com', '0098-554896', 'C/Pintor Lucio 13, 2A', 1, 1, 'Milagros Peña', 'milagros', '915468796', 'USER')
INSERT INTO player(is_captain, team, login) VALUES (0, 'Informatica', 'milagros@gmail.com')
INSERT INTO USER VALUES('admin@gmail.com','0098-55596','C/La Toledana 13, 2A',FALSE,TRUE,'Administrador','admin','916547893','ADMIN,USER')
INSERT INTO ADMIN VALUES('05950045D',1,'Supervisor','normal','admin@gmail.com')
ALTER TABLE court ALTER COLUMN photo BLOB
