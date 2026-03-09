--EJERCICIO 5.4

SELECT Cli.DNI, Cli.nombre, Cli.apellido, Cli.telefono, Cli.direccion
FROM CLiente Cli 
INNER JOIN Viaje V ON V.DNI = Cli.DNI 
INNER JOIN Ciudad C on C.CODIGOPOSTAL= V.cpDestino
WHERE C.nombreCiudad = 'Coronel Brandsen'

EXCEPT
SELECT Cli.DNI, Cli.nombre, Cli.apellido, Cli.telefono, Cli.direccion
FROM CLiente Cli 
INNER JOIN Viaje V ON V.DNI = Cli.DNI 
INNER JOIN Ciudad C on C.CODIGOPOSTAL= V.cpDestino
WHERE NOT (C.nombreCiudad = 'Coronel Brandsen')