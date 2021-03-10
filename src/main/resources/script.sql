 CREATE DATABASE bdturismo;
USE bdturismo;

CREATE DATABASE bdturismo;
USE bdturismo;

CREATE TABLE IF NOT EXISTS tb_lugar_turistico (
id_lugar_turistico INTEGER UNSIGNED PRIMARY KEY auto_increment,
codigo_lugar_turistico VARCHAR (50) UNIQUE KEY NOT NULL ,
nombre VARCHAR (200) NOT NULL,
descripcion VARCHAR (300) NOT NULL,
url_imagen1 VARCHAR (200) NOT NULL,
url_imagen2 VARCHAR (200) NOT NULL,
url_imagen3 VARCHAR (200) NOT NULL,
precio_x_persona DECIMAL (10,2) NOT NULL,
insertado_por VARCHAR (50) ,
modificado_por VARCHAR (50) ,
fecha_insert TIMESTAMP  NULL ,
fecha_update TIMESTAMP  NULL ,
calificacion_estrellas INTEGER (10)  NOT NULL,
habilitado_o_deshabilitado VARCHAR(100) NOT NULL,
clima_tour VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_servicio (
id_servicio INTEGER UNSIGNED PRIMARY KEY auto_increment,
codigo_servicio VARCHAR (50) UNIQUE KEY NOT NULL ,
nombre_servicio VARCHAR (50)NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_permiso (
id_permiso INTEGER UNSIGNED PRIMARY KEY auto_increment,
codigo_permiso VARCHAR (50) UNIQUE KEY NOT NULL,
descripcion_permiso VARCHAR (200) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_menu (
id_menu INTEGER UNSIGNED PRIMARY KEY auto_increment,
codigo_menu VARCHAR (50) UNIQUE KEY NOT NULL ,
menu VARCHAR (50) NOT NULL, 
url_menu VARCHAR (500) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_rol (
id_rol INTEGER UNSIGNED PRIMARY KEY auto_increment,
codigo_rol VARCHAR (50) UNIQUE KEY NOT NULL ,
descripcion VARCHAR (100) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_rol_permiso (
id_rol_permiso INTEGER UNSIGNED PRIMARY KEY auto_increment,
id_rol INTEGER UNSIGNED,
id_permiso INTEGER UNSIGNED,
FOREIGN KEY (id_rol) REFERENCES tb_rol(id_rol),
FOREIGN KEY (id_permiso) REFERENCES tb_permiso(id_permiso)
);

CREATE TABLE IF NOT EXISTS tb_rol_menu (
id_rol_menu INTEGER UNSIGNED PRIMARY KEY auto_increment,
id_rol INTEGER UNSIGNED,
id_menu INTEGER UNSIGNED,
FOREIGN KEY (id_rol) REFERENCES tb_rol(id_rol),
FOREIGN KEY (id_menu) REFERENCES tb_menu(id_menu)
);

CREATE TABLE IF NOT EXISTS tb_incluye (
id_incluye INTEGER UNSIGNED PRIMARY KEY auto_increment,
costo DECIMAL (10,2) NOT NULL ,
id_lugar_turistico INTEGER UNSIGNED,
id_servicio INTEGER UNSIGNED,
FOREIGN KEY (id_lugar_turistico) REFERENCES tb_lugar_turistico(id_lugar_turistico),
FOREIGN KEY (id_servicio) REFERENCES tb_servicio(id_servicio)
);

CREATE TABLE IF NOT EXISTS tb_usuario (
id_usuario INTEGER UNSIGNED PRIMARY KEY auto_increment ,
nombre_usuario VARCHAR (50) NOT NULL ,
apellido VARCHAR (50) NOT NULL ,
usuario VARCHAR (50) UNIQUE KEY NOT NULL ,
clave VARCHAR (50) NOT NULL ,
id_rol INTEGER UNSIGNED,
FOREIGN KEY (id_rol) REFERENCES tb_rol(id_rol)
);

CREATE TABLE IF NOT EXISTS tb_compra (
id_compra INTEGER UNSIGNED PRIMARY KEY auto_increment , 
cantidad_personas INT(50)NOT NULL , 
sub_total DECIMAL(10,2) NOT NULL , 
fecha_compra TIMESTAMP  NULL ,
fecha_viaje DATE NULL,
id_usuario INTEGER UNSIGNED,
id_lugar_turistico INTEGER UNSIGNED,
FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario),
FOREIGN KEY (id_lugar_turistico) REFERENCES tb_lugar_turistico(id_lugar_turistico)
);

-- seleccionar servicios de cada tour turistico
SELECT b.nombre_servicio FROM tb_incluye AS a
JOIN tb_servicio AS b ON a.id_servicio = b.id_servicio
WHERE id_lugar_turistico = 1;

-- opciones de un admin
SELECT m. * FROM tb_rol r, tb_rol_menu rm , tb_menu m 
WHERE 
r.id_rol = rm.id_rol and
rm.id_menu =m.id_menu and
r.codigo_rol = "04";

-- select lista de usuarios con descripción
SELECT a.id_usuario , a.nombre_usuario , a.apellido , a.usuario , a.clave , b.descripcion FROM tb_usuario AS a
JOIN tb_rol AS b ON a.id_rol = b.id_rol;

-- select si usuario tiene mas de una venta
SELECT  COUNT(a.id_usuario) FROM tb_usuario AS a INNER JOIN tb_compra AS b ON a.id_usuario = b.id_usuario WHERE a.id_usuario = 1;

-- validar si usuario
SELECT COUNT(usuario) FROM tb_usuario WHERE usuario = "ricardo123";

/*
 DROP TABLE tb_compra;
 DROP TABLE tb_usuario;
 DROP TABLE tb_incluye;
 DROP TABLE tb_rol_menu;
 DROP TABLE tb_rol_permiso;
 DROP TABLE tb_rol;
 DROP TABLE tb_menu;
 DROP TABLE tb_permiso;
 DROP TABLE tb_servicio;
 DROP TABLE tb_lugar_turistico;
 */
