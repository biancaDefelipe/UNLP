--Ejercicio 2.6
SELECT p.dni, p.apellido, p.nombre, p.telefono, p.fnac
FROM Arbol a
INNER JOIN Poda pod ON pod.nroArbol = a.nroArbol
INNER JOIN Podador p ON p.DNI = pod.DNI

