--EJERCICIO 13.1
SELECT e.nombreEntrenador, e.fechaNacimiento, e.direccion
FROM Entrenamiento ent
INNER JOIN Entrenador e ON e.idEntrenador = ent.idEntrenador 
WHERE e.fecha BETWEEN '2023-01-01' AND '2023-12-31'
