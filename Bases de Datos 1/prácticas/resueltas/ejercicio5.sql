/*5.	Escribe y ejecute la sentencia correspondiente para crear la siguiente tabla:
APPOINTMENTS_PER_PATIENT
idApP: int(11) PK AI
id_patient: int(11) 
count_appointments: int(11) 
last_update: datetime 
user: varchar(16)
*/


CREATE TABLE appointments_per_patient (
    idApP INT(11) PRIMARY KEY AUTO_INCREMENT,
    id_patient INT(11),
    count_appointments INT(11),
    last_update DATETIME,
    user VARCHAR(16),
    CONSTRAINT fk_appointments_per_patient_patient
        FOREIGN KEY (id_patient) REFERENCES patient(patient_id)
);

/*

CREATE TABLE APPOINTMENTS_PER_PATIENT (
idApP integer(11) primary key auto_increment,
id_patient integer(11),
count_appointments integer(11),
last_update datetime,
user varchar(16)
);


*/