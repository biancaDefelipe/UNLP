SELECT V.FECHA, V.HORA, Cli.DNI, Cli.nombre, Cli.apellido, Cli.telefon, Cli.direccion, Ori.nombreCiudad, Dest.nombreCIudad

FROM Viaje V
INNER JOIN Cliente Cli ON Cli.DNI = V.DNI
INNER JOIN Ciudad Ori ON Ori.CODIGOPOSTAL= V.cpOrigen
INNER JOIN Ciudad Dest ON Dest.CODIGOPOSTAL=V.cpDestino
WHERE (V.FECHA BETWEEN '2019-01-01' AND '2019-01-31') AND (V.descripcion LIKE %demorado%)