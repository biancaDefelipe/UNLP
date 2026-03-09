/*
2.	Hallar aquellos pacientes que para todas sus consultas médicas siempre hayan dejado su número de teléfono primario (nunca el teléfono secundario). 
*/

SELECT p.patient_id, p.patient_name
FROM PATIENT p
WHERE NOT EXISTS (
    SELECT 1
    FROM APPOINTMENT a
    WHERE a.patient_id = p.patient_id
      AND a.contact_phone = p.secondary_phone
)
AND EXISTS (
    SELECT 1
    FROM APPOINTMENT a
    WHERE a.patient_id = p.patient_id
      AND a.contact_phone = p.primary_phone
);

 