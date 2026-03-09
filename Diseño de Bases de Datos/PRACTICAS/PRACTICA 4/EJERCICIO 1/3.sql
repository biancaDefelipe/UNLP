--EJERCICIO 1

--3: 
SELECT nombreP descripcion precio stock
FROM Producto 
NATURAL JOIN Detalle 
NATURAL JOIN Factura
NATURAL JOIN Cliente
WHERE DNI=45789456
EXCEPT(
SELECT nombreP descripcion precio stock
FROM Producto 
NATURAL JOIN Detalle 
NATURAL JOIN Factura
NATURAL JOIN Cliente
WHERE apellido="Garcia"
)

--3 version alternativa
SELECT P.nombreP, P.descripcion, P.precio, P.stock
FROM Producto P
INNER JOIN Detalle D ON D.idProducto = P.idProducto
INNER JOIN Factura F ON F.nroTicket = D.nroTicket
INNER JOIN Cliente C ON C.idCliente = F.idCliente
WHERE C.DNI = '45789456' 
EXCEPT 
(SELECT P.nombreP, P.descripcion, P.precio, P.stock
FROM Producto P
INNER JOIN Detalle D ON D.idProducto = P.idProducto
INNER JOIN Factura F ON F.nroTicket = D.nroTicket
INNER JOIN Cliente C ON C.idCliente = F.idCliente
WHERE C.apellido = 'Garcia');