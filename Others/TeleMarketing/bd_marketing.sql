create database bd_marketing;

use bd_marketing;

CREATE TABLE IF NOT EXISTS cuentas(
id		int(36)		not null	auto_increment,
nombre		varchar(60)	not null,
dir_calle	varchar(60)	null,
dir_ciudad	varchar(60)	null,
dir_estado	varchar(60)	null,
dir_pais	varchar(60)	null,
telefono	varchar(60)	null,
fax		varchar(60)	null,
website		varchar(120)	null,
PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS cuentas_contactos(
id_cuenta	int(36)		not null,
id_contacto	int(36)		not null,
PRIMARY KEY(id_cuenta));

CREATE TABLE IF NOT EXISTS contactos(
id		int(36)		not null	auto_increment,
nombre		varchar(60)	not null,
apellido	varchar(60)	not null,
dir_calle	varchar(60)	null,
dir_ciudad	varchar(60)	null,
dir_estado	varchar(60)	null,
dir_pais	varchar(60)	null,
telf_cel	varchar(60)	null,
telf_oficina	varchar(60)	null,
telf_otro	varchar(60)	null,
fax		varchar(60)	null,
email		varchar(120)	null,
PRIMARY KEY(id));


CREATE TABLE IF NOT EXISTS cuestionarios(
id			int(36)		not null	auto_increment,
cuestionario		varchar(60)	not null,
descripcion		text		null,
fecha_creada		datetime	null,
fecha_modificada	datetime	null,
PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS pregunta_cuestionario(
id_cuestionario		int(36)		not null	auto_increment,
id_pregunta		int(36)		not null,
pregunta		text		not null,
PRIMARY KEY(id_cuestionario));


CREATE TABLE IF NOT EXISTS respuesta_pregunta(
id_respuesta		int(36)		not null	auto_increment,
id_pregunta		int(36)		not null,
respuesta		text		not null,
respuesta_rel		int(36)		null,
PRIMARY KEY(id_respuesta));


show warnings;

show tables;

describe cuentas;
describe cuentas_contactos;
describe contactos;
describe cuestionarios;
describe pregunta_cuestionario;
describe respuesta_pregunta;