--EJERCICIO 4.4
SELECT a.DNI, p.Apellido, p.Nombre, ac.Calificación
FROM Alumno a 
INNER JOIN Persona p ON a.DNI = p.DNI
INNER JOIN Alumno_Curso ac ON a.DNI = ac.DNI
INNER JOIN Profesor_Curso pc ON ac.Cod_Curso = pc.Cod_Curso
INNER JOIN Profesor prof ON (pc.DNI = prof.DNI)
INNER JOIN Persona p2 ON (prof.DNI = p2.DNI)
WHERE (ac.Calificacion > 8) AND (p2.Nombre = 'Juan') AND (p2.Apellido = 'Garcia')
ORDER BY p.Apellido