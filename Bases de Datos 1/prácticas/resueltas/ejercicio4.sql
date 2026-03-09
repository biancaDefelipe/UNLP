/*
4.	Utiliza la vista generada en el ejercicio anterior para resolver las siguientes consultas:
    a.	Obtener la cantidad de doctores por cada paciente que tiene disponible en su ciudad
    b.	Obtener los nombres de los pacientes sin doctores en su ciudad
    c.	Obtener los doctores que comparten ciudad con más de cinco pacientes. 
*/

--- 4a---
SELECT patient_id, count (doctor_id)
FROM doctor_per_patients
GROUP BY patient_id 

--- 4b---
SELECT p.patient_id, p.patient_name
FROM Patient AS p
LEFT JOIN doctors_per_patients AS v
    ON p.patient_id = v.patient_id
WHERE v.doctor_id IS NULL;

---4c---
SELECT doctor_id
FROM doctors_per_patients
GROUP BY doctor_id
HAVING COUNT(patient_id) > 5;
