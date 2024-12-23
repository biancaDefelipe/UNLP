--Ejercicio 5.1

SELECT A.RAZON_SOCIAL, A.direccion, A.telef
FROM Agencia A
INNER JOIN Viaje V ON V.razon_social = A.RAZON_SOCIAL
INNER JOIN Ciudad C ON c.CODIGOPOSTAL= V.cpOrigen
INNER JOIN Cliente Cli ON Cli.DNI=V.DNI
WHERE C.nombreCiudad='La Plata' AND Cli.apellido= 'Roma' 
ORDER BY A.RAZON_SOCIAL, A.telef
