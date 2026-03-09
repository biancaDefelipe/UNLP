/*
3.	Crear una vista llamada ‘doctors_per_patients’ que muestre los id de los pacientes y los id de doctores de la ciudad donde vive el paciente.
*/

CREATE VIEW doctors_per_patients AS
SELECT p.patient_id, d.doctor_id
FROM Patient AS p
INNER JOIN Doctor AS d
ON p.patient_city = d.doctor_city;

-- Para comprobar la vista:
SELECT * FROM doctors_per_patients;
