-- Crear la tabla Cliente
CREATE TABLE Cliente (
    idCliente INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    DNI VARCHAR(10) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(100)
);

-- Crear la tabla Factura
CREATE TABLE Factura (
    nroTicket INT IDENTITY(1,1) PRIMARY KEY,
    total DECIMAL(10, 2) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
    ON DELETE CASCADE
);

-- Crear la tabla Producto
CREATE TABLE Producto (
    idProducto INT IDENTITY(1,1) PRIMARY KEY,
    nombreP VARCHAR(50) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
);

-- Crear la tabla Detalle
CREATE TABLE Detalle (
    nroTicket INT,
    idProducto INT,
    cantidad INT NOT NULL,
    preciounitario DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (nroTicket, idProducto),
    FOREIGN KEY (nroTicket) REFERENCES Factura(nroTicket)
    ON DELETE CASCADE,
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
    ON DELETE CASCADE
);

-- Insertar datos en la tabla Cliente
INSERT INTO Cliente (nombre, apellido, DNI, telefono, direccion) VALUES
('Juan', 'Perez', '45789456', '123456789', 'Calle 1'),
('Pepe', 'Gómez', '87654321', '987654321', 'Calle 2'),
('María', 'Garcia', '90000000', '997654321', 'Calle 3');

-- Insertar datos en la tabla Factura
INSERT INTO Factura (total, fecha, hora, idCliente) VALUES
(100.00, '2017-10-27', '10:00:00', 1),
(150.50, '2017-10-28', '11:00:00', 2);

-- Insertar datos en la tabla Producto
INSERT INTO Producto (nombreP, descripcion, precio, stock) VALUES
('Producto A', 'Descripción del Producto A', 50.00, 100),
('Producto B', 'Descripción del Producto B', 75.00, 200);

-- Insertar datos en la tabla Detalle
INSERT INTO Detalle (nroTicket, idProducto, cantidad, preciounitario) VALUES
(1, 1, 2, 50.00),
(1, 2, 1, 75.00),
(2, 1, 1, 50.00);
