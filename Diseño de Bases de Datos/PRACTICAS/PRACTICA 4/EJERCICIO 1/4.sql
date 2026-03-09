--EJERCICIO 1.4

SELECT P.nombreP, P.descripcion, P.precio, P.stock
FROM Producto P
WHERE P.idProducto NOT IN (
	SELECT P.idProducto
	FROM Producto P
	INNER JOIN Detalle D ON D.idProducto = P.idProducto
	INNER JOIN Factura F ON F.nroTicket = D.nroTicket
	INNER JOIN Cliente C ON C.idCliente = F.idCliente
	WHERE (C.telefono LIKE '221%')
)
ORDER BY P.nombreP