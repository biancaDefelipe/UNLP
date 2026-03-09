--EJERCICIO 1.6

SELECT C.nombre, C.apellido, C.DNI, C.telefono, C.direccion 
FROM Cliente C
INNER JOIN Factura F ON C.idCliente=F.idCliente
INNER JOIN Detalle D ON F.nroTicket=D.nroTicket
INNER JOIN Producto P ON P.idProducto=D.idProducto
WHERE P.nombreP='prod1'

INTERSECT
SELECT C.nombre, C.apellido, C.DNI, C.telefono, C.direccion 
FROM Cliente C
INNER JOIN Factura F ON C.idCliente=F.idCliente
INNER JOIN Detalle D ON F.nroTicket=D.nroTicket
INNER JOIN Producto P ON P.idProducto=D.idProducto
WHERE P.nombreP='prod2'
EXCEPT 
SELECT C.nombre, C.apellido, C.DNI, C.telefono, C.direccion 
FROM Cliente C
INNER JOIN Factura F ON C.idCliente=F.idCliente
INNER JOIN Detalle D ON F.nroTicket=D.nroTicket
INNER JOIN Producto P ON P.idProducto=D.idProducto
WHERE P.nombreP='prod3'