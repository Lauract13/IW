INSERT INTO user(login,coducm,dir, is_player, isucm, name, password, phone, roles) VALUES ('admin@gmail.com', '0098-567898', 'C/La Milagrosa 12, 3B', 0, 1, 'Administrador', 'admin', '915468796', 'USER,ADMIN');
INSERT INTO admin(dni, enabled, job, workplace, login) VALUES ('05950045D', 1, 'Supervisor', 'normal', 'admin@gmail.com');
INSERT INTO user(login,coducm,dir, is_player, isucm, name, password, phone, roles) VALUES ('milagros@gmail.com', '0098-554896', 'C/Pintor Lucio 13, 2A', 1, 1, 'Milagros Peña', 'milagros', '915468796', 'USER');
INSERT INTO player(is_captain, team, login) VALUES (0, 'Informatica', 'milagros@gmail.com');
ALTER TABLE court ALTER COLUMN photo BLOB;