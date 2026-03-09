--EJERCICIO 13.4
SELECT e.nombreEntrenador, e.fechaNacimiento, e.direccion
FROM Club cu
INNER JOIN Complejo co ON co.IdCulb = cu.IdClub
INNER JOIN Cancha ca ON ca.IdComplejo = co.IdComplejo
INNER JOIN Entrenamiento ent ON ent.IdCancha = ca.IdCancha 
INNER JOIN Entrenador e ON e.IdEntrenador = ent.IdEntrenador
WHERE Cu.nombreClub = 'Estrella de Berisso'
INTERSECT 
SELECT e.nombreEntrenador, e.fechaNacimiento, e.direccion
FROM Club cu
INNER JOIN Complejo co ON co.IdCulb = cu.IdClub
INNER JOIN Cancha ca ON ca.IdComplejo = co.IdComplejo
INNER JOIN Entrenamiento ent ON ent.IdCancha = ca.IdCancha 
INNER JOIN Entrenador e ON e.IdEntrenador = ent.IdEntrenador
WHERE Cu.nombreClub = 'Everton'