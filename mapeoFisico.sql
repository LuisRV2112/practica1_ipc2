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

CREATE TABLE Tarjetas (
    numero_tarjeta VARCHAR(19) PRIMARY KEY,
    tipo VARCHAR(20),
    limite DECIMAL(10, 2),
    nombre_cliente VARCHAR(100),
    direccion_cliente VARCHAR(150),
    estado VARCHAR(20),
    fecha_autorizacion DATE,
    numero_solicitud INT,
    FOREIGN KEY (numero_solicitud) REFERENCES Solicitudes(numero_solicitud)
);

CREATE TABLE movimientos (
    tarjeta VARCHAR(16),
    fecha DATE NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    establecimiento VARCHAR(200) NOT NULL ,
    monto VARCHAR(150) NOT NULL ,
    PRIMARY KEY (tarjeta)
);
