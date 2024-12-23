--ejercicio 1.4
SELECT A.especie, A.años, A.calle, A.nro, L.nombreL, A.nroArbol
FROM Poda P
INNER JOIN Arbol A ON P.nroArbol = A.nroArbol
INNER JOIN Localidad L ON L.codigoPostal = A.codigoPostal
WHERE P.fecha BETWEEN '2022-01-01' AND '2022-12-31'
EXCEPT
SELECT A.especie, A.años, A.calle, A.nro, L.nombreL, A.nroArbol
FROM Poda P
INNER JOIN Arbol A ON P.nroArbol = A.nroArbol
INNER JOIN Localidad L ON L.codigoPostal = A.codigoPostal
WHERE P.fecha BETWEEN '2023-01-01' AND '2023-12-31'



