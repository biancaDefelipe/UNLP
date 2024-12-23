--EJERCICIO 2.9
SELECT l.nombreL, l.descripcion, l.numeroHabitantes
FROM Localidad L 
INNER JOIN Arbol a  ON a.codigoPostal= l.codigoPostal
GROUP BY l.codigoPostal, l.nombreL, l.descripcion, l.numeroHabitantes
HAVING COUNT(*)< 100