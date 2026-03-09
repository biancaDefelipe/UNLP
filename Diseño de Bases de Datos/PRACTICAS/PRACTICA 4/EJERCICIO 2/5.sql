--ejercicio 2.5
SELECT P.DNI, P.nombre,P.apellido,  P.fnac, L.nombreL
FROM Poda Pod
INNER JOIN Podador P ON P.DNI = Pod.DNI 
INNER JOIN Localidad L ON L.codigoPostal = P.codigoPostalVive
WHERE  P.apellido LIKE '%ata' AND Pod.fecha BETWEEN '2024-01-01' and '2024-12-31'
GROUP BY P.DNI, P.nombre,P.apellido,  P.fnac, L.nombreL
ORDER BY P.apellido, P.nombre

--consultar q opcion es mejor 

SELECT po.DNI, po.nombre, po.apellido, po.fnac, Loc.nombreL
FROM Podador po 
INNER JOIN Localidad Loc ON po.codigoPostalVive = Loc.codigoPostal
WHERE (po.apellido LIKE '%ata') AND po.DNI IN (
    SELECT pd.DNI
    FROM Poda pd
    WHERE pd.fecha BETWEEN '2024-01-01' AND '2024-12-31'
)
ORDER BY po.nombre,po.apellido


--select * 
--from poda
--where fecha between '2024-01-01' and '2024-12-31'
--select * from podador 