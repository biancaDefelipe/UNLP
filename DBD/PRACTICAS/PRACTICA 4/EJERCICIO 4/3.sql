--EJERCICIO 4.3
SELECT A.DNI,P .Apellido, P.Nombre, P.Genero, P.Fecha_Nacimiento
FROM Alumno A
INNER JOIN Persona P ON A.DNI= P.DNI 
INNER JOIN Alumno_Curso ac ON A.DNI=ac.DNI
INNER JOIN Curso c ON c.Cod_curso= ac.Cod_Curso
WHERE c.Nombre= 'Diseño de Bases de Datos' and ac.Año=2023

