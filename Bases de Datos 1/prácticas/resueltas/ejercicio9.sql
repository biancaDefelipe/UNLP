/* 9. Crear un stored procedure que sirva para agregar un appointment, junto el registro de un doctor 
que lo atendió (medical_review) y un medicamento que se le recetó (prescribed_medication), dentro de
una sola transacción. El stored procedure debe recibir los siguientes parámetros: patient_id, 
doctor_id, appointment_duration, contact_phone, appointment_address, medication_name. 
El appointment_date será la fecha actual. Los atributos restantes deben ser obtenidos de la tabla 
Patient (o dejarse en NULL).*/

DELIMITER //

CREATE DEFINER `root`@`localhost`PROCEDURE `insert_appointment`(IN patient_id INTEGER, IN doctor_id INTEGER, IN appointment_duration INTEGER, IN contact_phone VARCHAR(45), IN appointment_address VARCHAR(45), IN medication_name VARCHAR(30))
BEGIN 
    DECLARE today_date DATE; 
    DECLARE EXIT HANDLER FLOR SQLEXCEPTION
    BEGIN   
        ROLLBACK; 
    END; 

    START TRANSACTION; 
        SET today_date = CURDATE(); 

        INSERT INTO appointment(patient_id, appointment_date, appointment_duration, contact_phone, observations)
        VALUES(patient_id, today_date, appointment_duration, contact_phone, appointment_address); 

        INSERT INTO MEDICAL_REVIEW (patient_id, appointment_date, doctor_id)
        VALUES (patient_id, today_date, doctor_id); 

        INSERT INTO PRESCRIBED_MEDICATION(patient_id, appointment_date, medication_name)
        VALUES (patient_id, today_date, medication_name); 

    COMMIT; 
END //

DELIMITER ; 