-- Usuarios
INSERT INTO user(login,coducm,dir, is_player, isucm, name, password, phone, roles) VALUES ('milagros@gmail.com', '0098-554896', 'C/Pintor Lucio 13, 2A', 1, 1, 'Milagros Peña', 'milagros', '915468796', 'USER')
INSERT INTO player(is_captain, team, login) VALUES (0, 'Informatica', 'milagros@gmail.com')
INSERT INTO USER VALUES('admin@gmail.com','0098-55596','C/La Toledana 13, 2A',FALSE,TRUE,'Administrador','admin','916547893','ADMIN,USER')
INSERT INTO ADMIN VALUES('05950045D',1,'Supervisor','normal','admin@gmail.com')

ALTER TABLE court ALTER COLUMN photo BLOB

-- Pistas
INSERT INTO COURT VALUES(1,'Pista de voleibol exterior con medidas de pista reglamentaria y red adaptada para categor\u00eda adulta femenina.','Av. Juan Herrera 1, Madrid','- Descuento a 12\u20ac/hora para cualquier persona vinculada con la Universidad Complutense de Madrid.\u000d\u000a- En caso de necesitar luces por poca visibilidad, el coste aumenta 5\u20ac/hora.\u000d\u000a- Vestuarios (por persona): 1,75 \u20ac.\u000d\u000a- Todas estas tarifas son solo vigentes para la disputa de entrenamientos y partidos, no para la\u000d\u000a   impartici\u00f3n de cursos, jornadas, clinics, etc\u2026\u000d\u000a- Las personas con discapacidad tendr\u00e1n una reducci\u00f3n del 50% en el precio de las tarifas. Si en el\u000d\u000a  certificado de discapacidad se especifica que necesitan acompa\u00f1ante, \u00e9ste acceder\u00e1 gratis a la\u000d\u000a  instalaci\u00f3n.','Pista voleibol femenina - PARANINFO SUR','91 258 365',NULL,16.0E0)

-- Reservas
INSERT INTO RESERVATION VALUES(1,'2018-06-10 00:00:00.000000',TRUE,1,'milagros@gmail.com')
INSERT INTO RESERVATION VALUES(2,'2018-06-12 00:00:00.000000',FALSE,1,'milagros@gmail.com')
INSERT INTO HORAS VALUES(1,'10:00')
INSERT INTO HORAS VALUES(1,'11:00')
INSERT INTO HORAS VALUES(2,'10:00')
INSERT INTO HORAS VALUES(2,'11:00')

