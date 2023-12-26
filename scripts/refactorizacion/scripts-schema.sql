ALTER TABLE saludcantabriaresponde.patient_file_note ADD pfn_module varchar(100) NULL;

RENAME TABLE saludcantabriaresponde.patient_file_note TO saludcantabriaresponde.note;

ALTER TABLE saludcantabriaresponde.note CHANGE pfn_id n_id int auto_increment NOT NULL;

ALTER TABLE saludcantabriaresponde.note CHANGE pfn_content n_content varchar(500) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL;

ALTER TABLE saludcantabriaresponde.note CHANGE pfn_patient_file_id n_patient_file_id int NOT NULL;

ALTER TABLE saludcantabriaresponde.note CHANGE pfn_module n_module varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;

ALTER TABLE saludcantabriaresponde.patient_file_status ADD pfs_module varchar(45) NULL;

ALTER TABLE saludcantabriaresponde.sport_prescription_pf ADD sppf_status_code varchar(20) NULL;
ALTER TABLE saludcantabriaresponde.sport_prescription_pf CHANGE sppf_status_code sppf_status_code varchar(20) NULL AFTER sppf_sport_prescription_end_date;

ALTER TABLE saludcantabriaresponde.question MODIFY COLUMN q_text varchar(2500) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;
ALTER TABLE saludcantabriaresponde.phone_call_pf_f_a MODIFY COLUMN pcpffa_original_question_text varchar(2500) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;
ALTER TABLE saludcantabriaresponde.sport_prescription_pf_f_a MODIFY COLUMN sppffa_original_question_text varchar(2500) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;


CREATE TABLE `appointed_sport_prescription` (
  `asp_id` int NOT NULL AUTO_INCREMENT,
  `asp_date` datetime NOT NULL,
  `asp_title` varchar(500) DEFAULT NULL,
  `asp_type` varchar(20) DEFAULT NULL,
  `asp_patient_file` int NOT NULL,
  `asp_sport_prescription_done` int DEFAULT NULL,
  `asp_discarded` bit(1) DEFAULT NULL,
  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`asp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;



-- saludcantabriaresponde.user_role definition

CREATE TABLE `user_health_centre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` int DEFAULT NULL,
  `healthCentreId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


ALTER TABLE saludcantabriaresponde.patient_file ADD pf_userId_150 INT NULL;
