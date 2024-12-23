--EJERCICIO 13.2
SELECT c.nombreCancha, COUNT(*) As Cantidad de entrenamientos
FROM Complejo c 
INNER JOIN Cancha ch ON (c.IdComplejo = ch.IdComplejo)
LEFT JOIN Entrenamiento e ON (ch.IdCancha = e.IdCancha)
WHERE c.nombreComplejo = "Complejo 1" AND (e.fecha BETWEEN "01/01/2019" AND "31/12/2019")
GROUP BY c.IdCancha, c.nombreCancha
