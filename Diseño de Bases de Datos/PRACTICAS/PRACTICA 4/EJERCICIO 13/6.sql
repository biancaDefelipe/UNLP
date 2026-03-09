DELETE 
FROM Entrenamiento 
WHERE IdEntrenador IN (
    SELECT e.IdEntrenador
    FROM Entrenamiento ent
	INNER JOIN Entrenador en ON (ent.IdEntrenador = e.IdEntrenador)
    WHERE e.nombreEntrenador='Juan Perez'
)

--not exist tabla de la tabla con l aque hago la division 
--y dsp  not exist con la tabla de la relacion