--EJERCICIO 13.3
SELECT c.nombreComplejo
FROM Entrenador e
INNER JOIN Entrenamiento ent  ON ent.IdEntrenador = e.IdEntrenador 
INNER JOIN Cancha ca ON ca.IdCancha= e.IdCancha
INNER JOIN Complejo co ON co.IdComplejo = ca.IdComplejo
WHERE e.nombre = "Jorge Gonzalez" 
ORDER BY co.nombreComplejo 