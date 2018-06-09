-- Usuarios
INSERT INTO user(login,coducm,dir, is_player, isucm, name, password, phone, roles) VALUES ('milagros@gmail.com', '0098-554896', 'C/Pintor Lucio 13, 2A', 1, 1, 'Milagros Peña', 'milagros', '915468796', 'USER')
INSERT INTO player(team, login) VALUES ('Informatica', 'milagros@gmail.com')
INSERT INTO USER VALUES('admin@gmail.com','0098-55596','C/La Toledana 13, 2A',FALSE,TRUE,'Administrador','admin','916547893','ADMIN,USER')
INSERT INTO ADMIN VALUES('05950045D',1,'Supervisor','normal','admin@gmail.com')
INSERT INTO USER VALUES('laura@ucm.es',NULL,'C/ Vallehermoso 58',FALSE,FALSE,'Laura','laura','789898988','USER')
INSERT INTO USER VALUES('pedro@ucm.es','0098-554888','C/ Montera 60',FALSE,TRUE,'Pedro','pedro','777888999','USER')
INSERT INTO USER VALUES('admin2@gmail.com',NULL,'C/ Guzman el Bueno 23',FALSE,FALSE,'admin2','admin2','638840266','ADMIN,USER')
INSERT INTO ADMIN VALUES('05950335D',1,'Recepcionista','normal','admin2@gmail.com')

-- Pistas
INSERT INTO COURT VALUES(1,'Pista de voleibol exterior con medidas de pista reglamentaria y red adaptada para categor\u00eda adulta femenina.','Av. Juan Herrera 1, Madrid','- Descuento a 12\u20ac/hora para cualquier persona vinculada con la Universidad Complutense de Madrid.\u000d\u000a- En caso de necesitar luces por poca visibilidad, el coste aumenta 5\u20ac/hora.\u000d\u000a- Vestuarios (por persona): 1,75 \u20ac.\u000d\u000a- Todas estas tarifas son solo vigentes para la disputa de entrenamientos y partidos, no para la\u000d\u000a   impartici\u00f3n de cursos, jornadas, clinics, etc\u2026\u000d\u000a- Las personas con discapacidad tendr\u00e1n una reducci\u00f3n del 50% en el precio de las tarifas. Si en el\u000d\u000a  certificado de discapacidad se especifica que necesitan acompa\u00f1ante, \u00e9ste acceder\u00e1 gratis a la\u000d\u000a  instalaci\u00f3n.','Pista voleibol femenina - PARANINFO SUR','91 258 365',NULL,15.0E0)
INSERT INTO COURT VALUES(2,'Pista de cemento exterior adaptada a la categoria masculina.','Av. Juan Herrera 1, Madrid','Descuento para alumnos de la Universidad Complutense de Madrid.','Pista Volleyball Maculina Paraninfo Sur','998812345',NULL,16.0E0)
INSERT INTO COURT VALUES(3,'Pista cubierta con red adaptada para todas las categor\u00edas.','Carretera de H\u00famera, s/n','La estaci\u00f3n de metro Colonia Jard\u00edn (l\u00ednea 10)conecta con el metro ligero (l\u00ednea 2), con parada en el Campus de Somosaguas. Accesible a discapacitados. Vestuario y fuente de agua','Pista cubierta - SOMOSAGUAS','913946094',35.0E0)

-- Reservas
INSERT INTO RESERVATION VALUES(1,'2018-06-10 00:00:00.000000',TRUE,1,'milagros@gmail.com')
INSERT INTO RESERVATION VALUES(2,'2018-06-12 00:00:00.000000',FALSE,1,'milagros@gmail.com')
INSERT INTO RESERVATION VALUES(3,'2018-06-10 00:00:00.000000',TRUE,1,'admin@gmail.com')
INSERT INTO HORAS VALUES(1,'10:00')
INSERT INTO HORAS VALUES(1,'11:00')
INSERT INTO HORAS VALUES(2,'10:00')
INSERT INTO HORAS VALUES(2,'11:00')
INSERT INTO HORAS VALUES(3,'12:00')
INSERT INTO HORAS VALUES(3,'13:00')