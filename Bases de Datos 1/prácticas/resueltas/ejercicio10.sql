/* 10. Ejecutar el stored procedure del punto 9 con los siguientes datos:
patient_id: 10004427
doctor_id: 1003
appointment_duration: 30
contact_phone: +54 15 2913 9963
appointment_address: ‘Hospital Italiano’ 
medication_name: ‘Paracetamol’ */

-- PROCEDURE `insert_appointment`(, IN appointment_duration INTEGER, IN contact_phone VARCHAR(45), IN appointment_address VARCHAR(45), IN medication_name VARCHAR(30))
CALL insert_appointment(10004427, 1003, 30, '+54 15 2913 9963', ‘Hospital Italiano’ , ‘Paracetamol’ ); 