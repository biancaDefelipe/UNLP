--EJERCICIO 5.5
SELECT COUNT(*) AS CANTIDAD
FROM Agencia A 
INNER JOIN Viaje V ON V.razon_social= A.RAZON_SOCIAL
INNER JOIN Ciudad C ON C.CODIGOPOSTAL = V.cpDestino
WHERE A.RAZON_SOCIAL ='TAXI' AND C.nombreCIudad ='Villa Elisa'
 