--EJERCICIO3:
--1.3
SELECT P.nombreP, CAST(P.descripcion AS VARCHAR(MAX)), P.precio, P.stock
FROM Producto P
INNER JOIN Detalle D ON D.idProducto = P.idProducto
INNER JOIN Factura F ON F.nroTicket = D.nroTicket
INNER JOIN Cliente C ON C.idCliente = F.idCliente
WHERE C.DNI = 45789456

EXCEPT 

SELECT P.nombreP, CAST(P.descripcion AS VARCHAR(MAX)), P.precio, P.stock
FROM Producto P
INNER JOIN Detalle D ON D.idProducto = P.idProducto
INNER JOIN Factura F ON F.nroTicket = D.nroTicket
INNER JOIN Cliente C ON C.idCliente = F.idCliente
WHERE C.apellido = 'Garcia';
