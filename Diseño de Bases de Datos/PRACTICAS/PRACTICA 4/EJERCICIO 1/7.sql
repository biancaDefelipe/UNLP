--EJERCICIO 1.7

SELECT F.nroTicket, F.total, F.fecha, F.hora, C.DNI
FROM Factura F
	INNER JOIN Cliente C ON F.idCliente = C.idCliente
	INNER JOIN Detalle D ON D.nroTicket = F.nroTicket
	INNER JOIN Producto P ON P.idProducto = D.idProducto
WHERE P.nombreP = 'Prod38' OR F.fecha BETWEEN '2019-01-01' AND '2019-12-31';

