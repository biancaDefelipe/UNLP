--Ejercicio 1.9
SELECT F.nroTicket, F.total, F.fecha, F.hora
FROM Producto P
INNER JOIN Detalle D ON D.idProducto = P.idProducto
INNER JOIN Factura F ON F.nroTicket = D.nroTicket 
INNER JOIN Cliente C ON C.idCliente = F.idCliente
WHERE (C.nombre='Pepe' AND C.apellido = 'Gómez') AND (P.nombreP <> 'z')
