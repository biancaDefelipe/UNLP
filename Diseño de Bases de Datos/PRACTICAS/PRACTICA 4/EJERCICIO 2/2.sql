--ejercicio2.2

SELECT P.DNI, P.nombre, P.apellido, P.fnac, L.nombreL
FROM Poda Pod 
INNER JOIN Podador P ON Pod.DNI = P.DNI
INNER JOIN Localidad L ON P.codigoPostalVive = L.codigoPostal
WHERE Pod.fecha BETWEEN '2023-01-01' AND '2023-12-31'

