create database if not exists javawebapi62205;

use javawebapi62205;

drop table if exists usuarios;

create table if not exists usuarios(
	correo varchar(150) not null,-- primary key
	clave blob not null,
	fechaCreacion datetime,
	activo boolean default 1,
	primary key (correo)
);

-- AES_encrypt?