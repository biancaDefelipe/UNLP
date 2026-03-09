-- Crear tabla Localidad
CREATE TABLE Localidad (
    codigoPostal INT PRIMARY KEY,
    nombreL VARCHAR(100) NOT NULL,
    descripcion NVARCHAR(MAX),
    numeroHabitantes INT
);

-- Crear tabla Arbol
CREATE TABLE Arbol (
    nroArbol INT IDENTITY(1,1) PRIMARY KEY,
    especie VARCHAR(100) NOT NULL,
    años INT NOT NULL,
    calle VARCHAR(100) NOT NULL,
    nro INT NOT NULL,
    codigoPostal INT,
    FOREIGN KEY (codigoPostal) REFERENCES Localidad(codigoPostal) ON DELETE SET NULL
);

-- Crear tabla Podador
CREATE TABLE Podador (
    DNI VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(15),
    fnac DATE NOT NULL,
    codigoPostalVive INT,
    FOREIGN KEY (codigoPostalVive) REFERENCES Localidad(codigoPostal) ON DELETE SET NULL
);

-- Crear tabla Poda
CREATE TABLE Poda (
    codPoda INT IDENTITY(1,1) PRIMARY KEY,
    fecha DATE NOT NULL,
    DNI VARCHAR(10),
    nroArbol INT,
    FOREIGN KEY (DNI) REFERENCES Podador(DNI) ON DELETE CASCADE,
    FOREIGN KEY (nroArbol) REFERENCES Arbol(nroArbol) ON DELETE CASCADE
);

-- Inserción de localidades
INSERT INTO Localidad (codigoPostal, nombreL, descripcion, numeroHabitantes) VALUES
(1900, 'La Plata', 'Capital de la Provincia de Buenos Aires', 700000),
(4400, 'Salta', 'Capital de la Provincia de Salta', 500000),
(5000, 'Cordoba', 'Capital de la Provincia de Cordoba', 300000);

-- Inserción de árboles (sin especificar `nroArbol`)
INSERT INTO Arbol (especie, años, calle, nro, codigoPostal) VALUES
('Coníferas', 12, 'Calle 50', 100, 1900),
('Cedro', 8, 'Calle 10', 200, 1900),
('Coníferas', 15, 'Calle 100', 500, 4400),
('Roble', 20, 'Calle 20', 300, 4400),
('Pino', 5, 'Calle 70', 700, 5000),
('Coníferas', 25, 'Calle 30', 150, 5000);

-- Inserción de podadores
INSERT INTO Podador (DNI, nombre, apellido, telefono, fnac, codigoPostalVive) VALUES
('12345678', 'Juan', 'Perez', '123456789', '1980-05-10', 1900),
('87654321', 'Jose', 'Garcia', '987654321', '1985-08-20', 4400),
('22234566', 'Pedro', 'Rodriguez', '112233445', '1990-12-15', 5000),
('33345678', 'Sofia', 'Alvarez', '223344556', '1975-02-28', 1900),
('44456789', 'Laura', 'Arata', '334455667', '1987-09-05', 5000),
('55567890', 'Mateo', 'Bata', '445566778', '1992-11-30', 5000);

-- Inserción de podas (sin especificar `codPoda`)
INSERT INTO Poda (fecha, DNI, nroArbol) VALUES
('2022-06-15', '12345678', 1),
('2023-07-18', '12345678', 2),
('2023-08-10', '87654321', 3),
('2023-09-05', '87654321', 4),
('2024-01-12', '55567890', 5),
('2024-02-20', '55567890', 6);