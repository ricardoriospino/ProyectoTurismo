 CREATE DATABASE bdturismo;
USE bdturismo;

CREATE TABLE IF NOT EXISTS tb_lugar_turistico (
id_lugar_turistico INTEGER UNSIGNED PRIMARY KEY auto_increment,
nombre VARCHAR (200) NOT NULL,
descripcion VARCHAR (300) NOT NULL,
url_imagen VARCHAR (200) NOT NULL,
precio_x_persona DECIMAL (10,2) NOT NULL,
insertado_por VARCHAR (50) ,
modificado_por VARCHAR (50) ,
fecha_insert DATE NOT NULL,
fecha_update DATE DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS tb_servicio (
id_servicio INTEGER UNSIGNED PRIMARY KEY auto_increment,
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
menu VARCHAR (50) NOT NULL 
);

CREATE TABLE IF NOT EXISTS tb_rol (
id_rol INTEGER UNSIGNED PRIMARY KEY auto_increment,
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
monto_total DECIMAL(10,2) NOT NULL , 
id_usuario INTEGER UNSIGNED,
id_lugar_turistico INTEGER UNSIGNED,
FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario),
FOREIGN KEY (id_lugar_turistico) REFERENCES tb_lugar_turistico(id_lugar_turistico)
);


SELECT * FROM tb_lugar_turistico;
SELECT * FROM tb_servicio;
SELECT * FROM tb_permiso;
SELECT * FROM tb_menu;
SELECT * FROM tb_rol;
SELECT * FROM tb_rol_permiso;
SELECT * FROM tb_rol_menu;
SELECT * FROM tb_incluye;
SELECT * FROM tb_usuario;
SELECT * FROM tb_compra;