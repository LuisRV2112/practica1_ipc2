DROP DATABASE IF EXISTS banco;
CREATE DATABASE banco;
USE banco;

CREATE TABLE solicitudes (
    numero INT NOT NULL,
    fecha DATE NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    salario DECIMAL(10,2) NOT NULL ,
    direccion VARCHAR(150) NOT NULL ,
    PRIMARY KEY (numero)
);