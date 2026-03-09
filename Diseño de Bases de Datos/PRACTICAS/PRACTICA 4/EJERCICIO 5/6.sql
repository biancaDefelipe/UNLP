--EJERCICIO 56
SELECT Cli.nombre, Cli.apellido, Cli.direccion, Cli.telef
FROM Cliente Cli
WHERE NOT EXISTS
	SELECT * 
	FROM Agencia A 
	WHERE NOT EXISTS
		SELECT * 
		FROM Viaje V
		WHERE Cli.DNI= V.DNI AND A.RAZON_SOCIAL= V.razon_social