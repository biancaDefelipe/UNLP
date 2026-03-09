--Ejercicio 2.7
SELECT a.especie
FROM Arbol a
INNER JOIN Localidad l ON l.codigoPostal= a.codigoPostal
WHERE l.nombreL = 'La Plata'
INTERSECT 
SELECT a.especie
FROM Arbol a
INNER JOIN Localidad l ON l.codigoPostal= a.codigoPostal
WHERE l.nombreL = 'Salta'