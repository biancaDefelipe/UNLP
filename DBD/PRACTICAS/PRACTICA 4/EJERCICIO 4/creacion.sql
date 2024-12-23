-- Tabla Persona
CREATE TABLE Persona (
    DNI INT PRIMARY KEY,
    Apellido VARCHAR(50),
    Nombre VARCHAR(50),
    Fecha_Nacimiento DATE,
    Estado_Civil VARCHAR(20),
    Genero CHAR(1)
);

-- Tabla Alumno
CREATE TABLE Alumno (
    DNI INT PRIMARY KEY,
    Legajo VARCHAR(20),
    Año_Ingreso INT,
    FOREIGN KEY (DNI) REFERENCES Persona(DNI)
);

-- Tabla Profesor
CREATE TABLE Profesor (
    DNI INT PRIMARY KEY,
    Matricula VARCHAR(20),
    Nro_Expediente VARCHAR(20),
    FOREIGN KEY (DNI) REFERENCES Persona(DNI)
);

-- Tabla Titulo
CREATE TABLE Titulo (
    Cod_Titulo INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Descripcion VARCHAR(255)
);

-- Tabla Titulo-Profesor (relación entre Titulo y Profesor)
CREATE TABLE Titulo_Profesor (
    Cod_Titulo INT,
    DNI INT,
    Fecha DATE,
    PRIMARY KEY (Cod_Titulo, DNI),
    FOREIGN KEY (Cod_Titulo) REFERENCES Titulo(Cod_Titulo),
    FOREIGN KEY (DNI) REFERENCES Profesor(DNI)
);

-- Tabla Curso
CREATE TABLE Curso (
    Cod_Curso INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Descripcion VARCHAR(255),
    Fecha_Creacion DATE,
    Duracion INT -- Duración en horas
);

-- Tabla Alumno-Curso (relación entre Alumno y Curso)
CREATE TABLE Alumno_Curso (
    DNI INT,
    Cod_Curso INT,
    Año INT,
    Desempeño VARCHAR(50),
    Calificacion DECIMAL(3, 1),
    PRIMARY KEY (DNI, Cod_Curso, Año),
    FOREIGN KEY (DNI) REFERENCES Alumno(DNI),
    FOREIGN KEY (Cod_Curso) REFERENCES Curso(Cod_Curso)
);

-- Tabla Profesor-Curso (relación entre Profesor y Curso)
CREATE TABLE Profesor_Curso (
    DNI INT,
    Cod_Curso INT,
    Fecha_Desde DATE,
    Fecha_Hasta DATE,
    PRIMARY KEY (DNI, Cod_Curso, Fecha_Desde),
    FOREIGN KEY (DNI) REFERENCES Profesor(DNI),
    FOREIGN KEY (Cod_Curso) REFERENCES Curso(Cod_Curso)
);



-- Insertar datos en Persona
INSERT INTO Persona (DNI, Apellido, Nombre, Fecha_Nacimiento, Estado_Civil, Genero)
VALUES 
(12345678, 'Perez', 'Ana', '1995-04-23', 'Soltero', 'F'),
(23456789, 'Garcia', 'Juan', '1980-05-12', 'Casado', 'M'),
(34567890, 'Lopez', 'Maria', '1998-09-15', 'Soltero', 'F'),
(45678901, 'Martinez', 'Carlos', '1990-01-10', 'Divorciado', 'M');

-- Insertar datos en Alumno
INSERT INTO Alumno (DNI, Legajo, Año_Ingreso)
VALUES 
(12345678, '2019/01', 2019),
(34567890, '2020/09', 2020);

-- Insertar datos en Profesor
INSERT INTO Profesor (DNI, Matricula, Nro_Expediente)
VALUES 
(23456789, 'MAT-1234', 'EXP-5678'),
(45678901, 'MAT-5678', 'EXP-1234');

-- Insertar datos en Titulo
INSERT INTO Titulo (Cod_Titulo, Nombre, Descripcion)
VALUES 
(1, 'Licenciatura en Matemática', 'Titulo universitario en matemática'),
(25, 'Doctorado en Computación', 'Titulo de doctorado en ciencias de la computación');

-- Insertar datos en Titulo-Profesor
INSERT INTO Titulo_Profesor (Cod_Titulo, DNI, Fecha)
VALUES 
(1, 23456789, '2015-06-30'),
(25, 23456789, '2017-12-12'),
(1, 45678901, '2018-03-20');

-- Insertar datos en Curso
INSERT INTO Curso (Cod_Curso, Nombre, Descripcion, Fecha_Creacion, Duracion)
VALUES 
(101, 'Diseño de Bases de Datos', 'Curso sobre diseño de bases de datos', '2022-01-15', 120),
(102, 'Algoritmos y Estructuras de Datos', 'Curso avanzado de algoritmos', '2021-09-10', 90);

-- Insertar datos en Alumno-Curso
INSERT INTO Alumno_Curso (DNI, Cod_Curso, Año, Desempeño, Calificacion)
VALUES 
(12345678, 101, 2023, 'Excelente', 9.5),
(34567890, 101, 2023, 'Bueno', 8.5);

-- Insertar datos en Profesor-Curso
INSERT INTO Profesor_Curso (DNI, Cod_Curso, Fecha_Desde, Fecha_Hasta)
VALUES 
(23456789, 101, '2023-01-10', '2023-06-20'),
(45678901, 102, '2022-09-15', '2023-01-10');

