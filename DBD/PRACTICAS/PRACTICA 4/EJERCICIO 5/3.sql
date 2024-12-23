SELECT A.direccion, A.telef, A.e-mail
FROM Agencia A 
INNER JOIN Viaje V ON V.razon_social =A.RAZON_SOCIAL 
WHERE (V.Fecha BETWEEN '2019-01-01'  AND '2019-31-12')OR 
		(A.e-mail  LIKE '%@jmail.com')