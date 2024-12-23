--EJERCICIO 1.5

SELECT P.nombreP, 
       CAST(P.descripcion AS VARCHAR(MAX)), 
       P.precio, 
       COUNT(D.idProducto) AS veces_vendido
FROM Producto P
INNER JOIN Detalle D ON P.idProducto = D.idProducto
GROUP BY P.nombreP,  CAST(P.descripcion AS VARCHAR(MAX)), P.precio
ORDER BY P.nombreP;
