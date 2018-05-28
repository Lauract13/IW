INSERT INTO user(login,coducm,dir, is_player, isucm, name, password, phone, roles) VALUES ('admin@gmail.com', '0098-567898', 'C/La Milagrosa 12, 3B', 0, 1, 'Administrador', 'admin', '915468796', 'USER,ADMIN');
INSERT INTO admin(dni, enabled, job, workplace, login) VALUES ('05950045D', 1, 'Supervisor', 'normal', 'admin@gmail.com');
INSERT INTO user(login,coducm,dir, is_player, isucm, name, password, phone, roles) VALUES ('milagros@gmail.com', '0098-554896', 'C/Pintor Lucio 13, 2A', 1, 1, 'Milagros Peña', 'milagros', '915468796', 'USER');
INSERT INTO player(is_captain, team, login) VALUES (0, 'Informatica', 'milagros@gmail.com');
ALTER TABLE court ALTER COLUMN photo BLOB;
insert into court (id, description, dir, extras, name, phone, photo, price) VALUES (default, 'Pista de voleibol exterior con medidas de pista reglamentaria y red adaptada para categoría adulta femenina.', 
'Av. Juan Herrera 1, Madrid',
'En caso de necesitar luces por poca visibilidad, el coste aumenta 5€/hora.
Vestuarios (por persona): 1,75 €.
Todas estas tarifas son solo vigentes para la disputa de entrenamientos y partidos, no para la
impartición de cursos, jornadas, clinics, etc…
Las personas con discapacidad tendrán una reducción del 50% en el precio de las tarifas. Si en el
certificado de discapacidad se especifica que necesitan acompañante, éste accederá gratis a la
instalación.', 
'Pista voleibol femenina - PARANINFO SUR',
'91 258 365', NULL,
12);