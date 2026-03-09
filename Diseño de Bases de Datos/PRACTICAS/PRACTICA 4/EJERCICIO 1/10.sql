--Ejercicio 1.10
SELECT C.DNI,C.apellido,C.nombre, SUM(F.total) AS montoTotal
FROM Cliente C
INNER JOIN Factura F ON F.idCliente = C.idCliente
GROUP BY C.dni, C.nombre, C.apellido
HAVING SUM (F.total) > 120

--SELECT C.DNI,C.apellido,C.nombre, SUM(F.total) as montoTotal
--FROM Cliente C
--INNER JOIN Factura F ON C.idCliente = F.idCliente
--GROUP BY C.DNI,C.apellido,C.nombre
--HAVING SUM(F.total) >10