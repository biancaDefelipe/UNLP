SELECT A.especie, A.años, A.calle, A.nro, L.nombreL
FROM Arbol A
INNER JOIN Localidad L ON L.codigoPostal= A.codigoPostal
LEFT JOIN Poda P ON A.nroArbol = P.nroArbol
WHERE p.nroArbol IS NULL