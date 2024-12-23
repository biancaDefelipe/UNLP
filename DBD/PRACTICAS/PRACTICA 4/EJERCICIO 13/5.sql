--EJERCICIO 13.5



SELECT cu.nombreClub, cu.ciudad
FROM Club cu
INNER JOIN Complejo co ON cu.IdClub = co.IdClub
INNER JOIN Cancha ca ON co.IdComplejo = ca.IdComplejo
INNER JOIN Entrenamiento ent ON ca.IdCancha = ent.IdCancha
INNER JOIN Entrenador e ON ca.IdEntrenador = ent.IdEntrenador
WHERE en.nombreEntrenador = 'Marcos Perez'