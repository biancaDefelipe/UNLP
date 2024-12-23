--Ejercicio 2.1
(SELECT A.especie,A.años, A.calle, A.nro, L.nombreL
FROM Arbol A 
INNER JOIN Localidad L ON A.codigoPostal= L.codigoPostal
INNER JOIN Poda pod ON pod.nroArbol = A.nroArbol
INNER JOIN Podador Po ON Po.DNI= pod.DNI

WHERE Po.nombre = 'Juan' AND Po.apellido = 'Perez')
INTERSECT 
(SELECT A.especie,A.años, A.calle, A.nro, L.nombreL
FROM Arbol A 
INNER JOIN Localidad L ON A.codigoPostal= L.codigoPostal
INNER JOIN Poda pod ON pod.nroArbol = A.nroArbol
INNER JOIN Podador Po ON Po.DNI= pod.DNI

WHERE Po.nombre = 'Jose' AND Po.apellido = 'Garcia')