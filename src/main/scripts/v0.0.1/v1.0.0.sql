-- CREATE SCHEMA `saludcantabriaresponde` ;
CREATE TABLE `saludcantabriaresponde`.`form` (
  `f_id` int NOT NULL AUTO_INCREMENT,
  `f_title` varchar(45) NOT NULL,
  `f_description` varchar(255) DEFAULT NULL,
  `f_category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `saludcantabriaresponde`.`form` (`f_title`) VALUES ('Síntomas COVID');
INSERT INTO `saludcantabriaresponde`.`form` (`f_title`) VALUES ('Vacunación COVID');
INSERT INTO `saludcantabriaresponde`.`form` (`f_title`) VALUES ('Contacto COVID');
INSERT INTO `saludcantabriaresponde`.`form` (`f_title`) VALUES ('Certificado COVID');
INSERT INTO `saludcantabriaresponde`.`form` (`f_title`) VALUES ('Prestaciones ortoprotésicas');
INSERT INTO `saludcantabriaresponde`.`form` (`f_title`) VALUES ('Asistencia sanitaria');
INSERT INTO `saludcantabriaresponde`.`form` (`f_title`) VALUES ('Seguimiento enfermedad crónica');
INSERT INTO `saludcantabriaresponde`.`form` (`f_title`) VALUES ('Formulario básico');

ALTER TABLE `saludcantabriaresponde`.`form` 
ADD COLUMN `f_active` TINYINT NULL DEFAULT '1' AFTER `f_category`;

CREATE TABLE `saludcantabriaresponde`.`answer_type` (
  `at_id` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `at_enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`at_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
INSERT INTO `saludcantabriaresponde`.`answer_type` VALUES ('BOOLEAN',1),('DATE',1),('NUMBER',1),('RADIO_CUSTOM',1),('STRING',1),('YES_NO',1);

CREATE TABLE `saludcantabriaresponde`.`question` (

  `q_id` int NOT NULL AUTO_INCREMENT,
  `q_text` varchar(250) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `q_answer_type` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `q_enabled` tinyint(1) NOT NULL,
  `q_priority` int NOT NULL,
  
  `question_parent_type` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `question_block` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  
  `q_help` varchar(300) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`q_id`),
  KEY `FK_QUESTION_ANSWER_TYPE_ID` (`q_answer_type`),
  CONSTRAINT `FK_QUESTION_ANSWER_TYPE_ID` FOREIGN KEY (`q_answer_type`) REFERENCES `answer_type` (`at_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

INSERT INTO `saludcantabriaresponde`.`question` VALUES (1,'¿Tiene Tos seca varios accesos a día y que no cede?','YES_NO',0,1,'MONITORING_CALL',NULL,NULL),(2,'¿Cuántos días lleva con tos?','STRING',0,2,'MONITORING_CALL',NULL,NULL),(3,'¿Le duele el pecho o el costado al toser?','YES_NO',0,3,'MONITORING_CALL',NULL,NULL),(4,'¿Dificultad para Respirar o sensación de falta de aire que ha aparecido bruscamente?','YES_NO',0,4,'MONITORING_CALL',NULL,NULL),(5,'¿Tiene diarrea de varios días o ha hecho en las últimas 24 horas más de 10 deposiciones?','YES_NO',0,5,'MONITORING_CALL',NULL,NULL),(6,'¿Tiene vómitos frecuentes que le impiden la alimentación?','YES_NO',0,6,'MONITORING_CALL',NULL,NULL),(7,'¿Tiene Fiebre >= 37,7? ','YES_NO',0,7,'MONITORING_CALL',NULL,NULL),(8,'¿Cuántos días lleva con fiebre (>= 37,7)?','STRING',0,8,'MONITORING_CALL',NULL,NULL),(9,'¿Cede con medicación para la fiebre?','YES_NO',0,9,'MONITORING_CALL',NULL,NULL),(10,'¿En total desde que comenzaron los síntomas, cuántos días lleva con Síntomas?','STRING',0,10,'MONITORING_CALL',NULL,NULL),(11,'¿Tiene Tos seca varios accesos a día y que no cede?','YES_NO',0,11,'MONITORING_CALL',NULL,NULL),(12,'¿Tiene Fiebre >= 37,7? ','YES_NO',0,12,'MONITORING_CALL',NULL,NULL),(13,'¿Tiene dolores musculares?','YES_NO',0,13,'MONITORING_CALL',NULL,NULL),(14,'¿Ha perdido el sentido del olfato o el gusto bruscamente?','YES_NO',0,14,'MONITORING_CALL',NULL,NULL),(15,'Hipertensión arterial','BOOLEAN',0,1,'PATIENT_FILE',NULL,NULL),(16,'Diabetes','BOOLEAN',0,2,'PATIENT_FILE',NULL,NULL),(17,'Enfermedad cardiovascular (angina, infarto, insuficiencia cardiaca, fibrilación auricular)','BOOLEAN',0,3,'PATIENT_FILE',NULL,NULL),(18,'Enfermedad pulmonar','BOOLEAN',0,4,'PATIENT_FILE',NULL,NULL),(19,'Enfermedad del hígado','BOOLEAN',0,5,'PATIENT_FILE',NULL,NULL),(20,'Enfermedad del riñón','BOOLEAN',0,6,'PATIENT_FILE',NULL,NULL),(21,'Ictus','BOOLEAN',0,7,'PATIENT_FILE',NULL,NULL),(22,'Cáncer actual','BOOLEAN',0,8,'PATIENT_FILE',NULL,NULL),(23,'Medicación inmunosupresora','BOOLEAN',0,9,'PATIENT_FILE',NULL,NULL),(24,'Tiroides','BOOLEAN',0,10,'PATIENT_FILE',NULL,NULL),(25,'Colesterol','BOOLEAN',0,11,'PATIENT_FILE',NULL,NULL),(26,'Disnea','YES_NO',1,1,'PATIENT_FILE',NULL,NULL),(27,'Caso especial','STRING',0,2,'PATIENT_FILE',NULL,NULL),(28,'Número de convivientes','STRING',1,3,'PATIENT_FILE',NULL,NULL),(29,'Riesgo social','YES_NO',0,4,'PATIENT_FILE',NULL,NULL),(30,'Patología cardiaca','YES_NO',1,5,'PATIENT_FILE',NULL,NULL),(31,'Patología pulmonar','YES_NO',1,6,'PATIENT_FILE',NULL,NULL),(32,'Antecedentes psiquiátricos','YES_NO',1,7,'PATIENT_FILE',NULL,NULL),(33,'¿Tiene un cuidador responsable?','YES_NO',0,1,'MONITORING_CALL',NULL,NULL),(34,'¿Convive con alguna persona con factor de riesgo social (dependiente, deterioro cognitivo, patología grave, etc)?','YES_NO',0,2,'MONITORING_CALL',NULL,NULL),(35,'Inmunodeprimido','YES_NO',1,8,'PATIENT_FILE',NULL,NULL),(36,'Embarazada','YES_NO',1,9,'PATIENT_FILE',NULL,NULL),(37,'Tratamiento oncológico activo','YES_NO',1,10,'PATIENT_FILE',NULL,NULL),(38,'¿Entiende las indicaciones de autoaislamiento?','YES_NO',1,2,'MONITORING_CALL',NULL,NULL),(39,'¿Pertenece a un colectivo esencial?','YES_NO',1,2,'PATIENT_FILE',NULL,'Ayuda: (sanitario, sociosanitario, fuerzas y cuerpos de seguridad del estado, penitenciaria, otros)'),(40,'¿Tiene un cuidador responsable?','YES_NO',1,3,'MONITORING_CALL','RISO',NULL),(41,'¿Tiene las necesidades básicas de alimentación cubiertas?','YES_NO',1,4,'MONITORING_CALL','RISO',NULL),(42,'¿Tiene las necesidades básicas de fármacos cubiertas?','YES_NO',1,5,'MONITORING_CALL','RISO',NULL),(43,'¿Tiene las necesidades básicas de vivienda cubiertas?','YES_NO',1,6,'MONITORING_CALL','RISO',NULL),(44,'¿Tiene las necesidades básicas de higiene cubiertas?','YES_NO',1,7,'MONITORING_CALL','RISO',NULL),(45,'¿Eres persona cuidadora? ','YES_NO',1,8,'MONITORING_CALL','RISO',NULL),(46,'¿La persona la que cuida tiene otra alternativa de cuidado?','YES_NO',1,9,'MONITORING_CALL','RISO','Ayuda: SI = resuelto ; No = derivamos'),(47,'Inseguridad laboral subjetiva (miedo) ','YES_NO',1,10,'MONITORING_CALL','RISO',NULL),(49,'¿Está sufriendo algún tipo de maltrato en la actualidad por parte de su pareja o expareja?','YES_NO',1,11,'MONITORING_CALL','VIGE',NULL),(50,'¿Convive con él?','YES_NO',1,12,'MONITORING_CALL','VIGE',NULL),(51,'¿Conoce los dispositivos necesarios en caso de precisar ayuda?','YES_NO',1,13,'MONITORING_CALL','VIGE',NULL),(52,'¿Ha estado en contacto en los últimos dos meses con un especialista en salud mental o siguiendo algún tratamiento para los nervios?','YES_NO',1,14,'MONITORING_CALL','SAME',NULL),(53,'¿Se está sintiendo sobrepasado o muy estresado por la situación actual y ha tenido síntomas como insomnio, ansiedad o mayor consumo de alcohol o tabaco? ','YES_NO',1,15,'MONITORING_CALL','SAME',NULL),(54,'Apoyo psicosocial','BOOLEAN',1,16,'MONITORING_CALL','INRE',NULL),(55,'Coordinación con otros recursos','BOOLEAN',1,17,'MONITORING_CALL','INRE',NULL),(56,'Correo a Centro de Salud','BOOLEAN',1,18,'MONITORING_CALL','INRE',NULL),(57,'Derivación a Trabajo Social','BOOLEAN',1,19,'MONITORING_CALL','INRE',NULL),(58,'Derivación a Unidad de Salud Mental','BOOLEAN',1,20,'MONITORING_CALL','INRE',NULL),(59,'Derivación a su mutua (MUFACE, ISFAS, MUGEJU)','BOOLEAN',1,21,'MONITORING_CALL','INRE',NULL),(60,'Derivación a recurso por violencia de género','BOOLEAN',1,22,'MONITORING_CALL','INRE',NULL),(61,'Educación sobre autoaislamiento','BOOLEAN',1,23,'MONITORING_CALL','INRE',NULL),(62,'Información sanitaria','BOOLEAN',1,24,'MONITORING_CALL','INRE',NULL),(63,'Informar a Salud Pública','BOOLEAN',1,25,'MONITORING_CALL','INRE',NULL),(64,'Nueva llamada de seguimiento','BOOLEAN',1,26,'MONITORING_CALL','INRE',NULL),(65,'Tos','YES_NO',1,2,'SYMPTOM',NULL,''),(66,'Fiebre','YES_NO',1,3,'SYMPTOM',NULL,NULL),(67,'Disnea','YES_NO',1,4,'SYMPTOM',NULL,NULL),(68,'Pérdida del gusto/olfato','YES_NO',1,5,'SYMPTOM',NULL,NULL),(69,'Dolor en el costado al toser','YES_NO',1,6,'SYMPTOM',NULL,NULL),(70,'Dolor en el costado al respirar','YES_NO',1,7,'SYMPTOM',NULL,NULL),(71,'Dolor cabeza ','YES_NO',1,9,'SYMPTOM',NULL,NULL),(72,'Fecha inicio síntomas','STRING',1,1,'SYMPTOM',NULL,NULL),(73,'HTA','BOOLEAN',1,33,'SYMPTOM','PTRE',NULL),(74,'Diabetes Mellitus','BOOLEAN',1,34,'SYMPTOM','PTRE',NULL),(75,'Enfermedades pulmonares','BOOLEAN',1,35,'SYMPTOM','PTRE',NULL),(76,'Cáncer en tratamiento actual','BOOLEAN',1,36,'SYMPTOM','PTRE',NULL),(77,'Imnunosupresión','BOOLEAN',1,37,'SYMPTOM','PTRE',NULL),(78,'Toma medicación habitual','BOOLEAN',1,38,'SYMPTOM','PTRE',NULL),(80,'Dolor de garganta','YES_NO',1,10,'SYMPTOM',NULL,NULL),(81,'Número de convivientes','NUMBER',1,1,'INCOMING_CALL','CONV',NULL),(82,'Fecha inicio síntomas','DATE',1,1,'INCOMING_CALL','SYMP',NULL),(83,'Tos','YES_NO',1,4,'INCOMING_CALL','SYMP',NULL),(84,'Fiebre','YES_NO',1,5,'INCOMING_CALL','SYMP',NULL),(85,'Dolor de cabeza','YES_NO',1,6,'INCOMING_CALL','SYMP',NULL),(86,'Dolor de garganta','YES_NO',1,7,'INCOMING_CALL','SYMP',NULL),(87,'Mialgia','YES_NO',1,8,'INCOMING_CALL','SYMP',NULL),(88,'Anosmia','YES_NO',1,11,'INCOMING_CALL','SYMP',NULL),(89,'Disgeusia','YES_NO',1,10,'INCOMING_CALL','SYMP',NULL),(90,'Vómitos','YES_NO',1,13,'INCOMING_CALL','SYMP',NULL),(91,'Lesiones cutáneas','YES_NO',1,14,'INCOMING_CALL','SYMP',NULL),(92,'Dolor en el costado al toser','YES_NO',1,15,'INCOMING_CALL','SYMP',NULL),(93,'HTA','BOOLEAN',1,11,'INCOMING_CALL','PTRE',NULL),(94,'Diabetes Mellitus','BOOLEAN',1,7,'INCOMING_CALL','PTRE',NULL),(95,'Fumador','BOOLEAN',1,8,'INCOMING_CALL','PTRE',NULL),(96,'Obesidad','BOOLEAN',1,6,'INCOMING_CALL','PTRE',NULL),(97,'Enfermedades cardíacas','BOOLEAN',1,2,'INCOMING_CALL','PTRE',NULL),(98,'Enfermedades pulmonares','BOOLEAN',1,5,'INCOMING_CALL','PTRE',NULL),(99,'Inmunosupresión','BOOLEAN',1,3,'INCOMING_CALL','PTRE',NULL),(100,'Cáncer en tratamiento actual','BOOLEAN',1,1,'INCOMING_CALL','PTRE',NULL),(101,'Toma medicación habitual','BOOLEAN',1,12,'INCOMING_CALL','PTRE',NULL),(102,'Posible salud mental','BOOLEAN',1,9,'INCOMING_CALL','PTRE',NULL),(103,'Autovigilancia','BOOLEAN',1,1,'INCOMING_CALL','INDRE','Contacto casual'),(104,'Cuarentena + autovigilancia','BOOLEAN',1,4,'INCOMING_CALL','INDRE','Contacto estrecho'),(105,'Autoaislamiento','BOOLEAN',1,2,'INCOMING_CALL','INDRE',NULL),(106,'Situación domiciliaria no permite autoaislamiento en domicilio','BOOLEAN',1,45,'INCOMING_CALL','SEGU',NULL),(107,'Caso especial','BOOLEAN',0,41,'INCOMING_CALL',NULL,NULL),(108,'Necesita baja médica','BOOLEAN',0,50,'INCOMING_CALL',NULL,NULL),(109,'Baja seguridad social','BOOLEAN',0,49,'INCOMING_CALL',NULL,NULL),(110,'Baja mutualidad','BOOLEAN',0,46,'INCOMING_CALL',NULL,NULL),(111,'¿Cuál?','STRING',1,8,'INCOMING_CALL','PROF',NULL),(112,'Nombre de empresa','STRING',1,9,'INCOMING_CALL','PROF',NULL),(113,'Llamar centro de salud','BOOLEAN',1,1,'INCOMING_CALL','INRE',NULL),(114,'Acudir a C.S. por sus propios medios','BOOLEAN',1,4,'INCOMING_CALL','INRE',NULL),(115,'Acudir a SUAP por sus propios medios','BOOLEAN',1,7,'INCOMING_CALL','INRE',NULL),(116,'Llamada no pertinente','BOOLEAN',1,67,'INCOMING_CALL','ACTI',NULL),(117,'Llamada informativa','BOOLEAN',1,5,'INCOMING_CALL','INDRE',NULL),(118,'Contacto estrecho','RADIO_CUSTOM',1,2,'INCOMING_CALL','MAIN',NULL),(119,'Refiere','STRING',1,2,'INCOMING_CALL','SYMP',NULL),(120,'Astenia','YES_NO',1,9,'INCOMING_CALL','SYMP',NULL),(121,'Diarrea','YES_NO',1,12,'INCOMING_CALL','SYMP',NULL),(122,'Edad mayor de 60 años','BOOLEAN',1,10,'INCOMING_CALL','PTRE',NULL),(123,'Iniciar trámite de incapacidad temporal','BOOLEAN',1,4,'INCOMING_CALL','TRAM',NULL),(124,'Profesión esencial','YES_NO',1,7,'INCOMING_CALL','PROF',NULL),(125,'Derivación 061','BOOLEAN',1,5,'INCOMING_CALL','INRE',NULL),(126,'Derivación 112','BOOLEAN',1,8,'INCOMING_CALL','INRE',NULL),(127,'Se aporta consejo sanitario','BOOLEAN',1,3,'INCOMING_CALL','INDRE',NULL),(128,'Seguimiento por vulnerabilidad','BOOLEAN',1,68,'INCOMING_CALL','SEGU',NULL),(129,'Petición de PCR','BOOLEAN',1,42,'INCOMING_CALL',NULL,NULL),(130,'Solicitar tarjeta desplazado','BOOLEAN',1,3,'INCOMING_CALL','TRAM',NULL),(131,'Dificultad para respirar','YES_NO',1,3,'INCOMING_CALL','SYMP',NULL),(132,'Deterioro cognitivo','BOOLEAN',1,4,'INCOMING_CALL','PTRE',NULL),(143,'De Caso confirmado en otra Comunidad Autónoma','BOOLEAN',1,1,'INCOMING_CALL','CONTE',NULL),(144,'De Caso confirmado en Cantabria','BOOLEAN',1,2,'INCOMING_CALL','CONTE',NULL),(145,'De Caso confirmado \"Conviviente\"','BOOLEAN',1,3,'INCOMING_CALL','CONTE',NULL),(146,'De Caso confirmado en ámbito escolar','BOOLEAN',1,4,'INCOMING_CALL','CONTE',NULL),(147,'De Caso confirmado en ámbito laboral','BOOLEAN',1,5,'INCOMING_CALL','CONTE',NULL),(148,'De Caso confirmado por Radar Covid','BOOLEAN',1,6,'INCOMING_CALL','CONTE',NULL),(149,'Indico esperar llamada de rastreadores','BOOLEAN',1,6,'INCOMING_CALL','INDRE',NULL),(150,'Citado para prueba PCR','BOOLEAN',1,1,'INCOMING_CALL','TRAM',NULL),(151,'Citado PCR no recibe SMS Educación','BOOLEAN',1,2,'INCOMING_CALL','TRAM',NULL),(152,'Cito otras pruebas de test (no PCR)','BOOLEAN',1,5,'INCOMING_CALL','TRAM',NULL),(153,'Informo Salud Pública','BOOLEAN',1,6,'INCOMING_CALL','TRAM',NULL),(154,'Acudir al Hospital por sus propios medios','BOOLEAN',1,2,'INCOMING_CALL','INRE',NULL),(155,'Remito a Servicio Prevención de Riesgos Laborales','BOOLEAN',1,3,'INCOMING_CALL','INRE',NULL),(156,'Remito a su médico Privado/Seguro Privado/Mutua','BOOLEAN',1,6,'INCOMING_CALL','INRE',NULL),(157,'Remito a su coordinador COVID de centro educativo','BOOLEAN',1,9,'INCOMING_CALL','INRE',NULL),(158,'Incidencias','STRING',1,1,'INCOMING_CALL','INCI',NULL),(159,'Dar código Radar COVID','BOOLEAN',1,7,'INCOMING_CALL','TRAM',NULL),(160,'Posible Reinfección','BOOLEAN',1,69,'INCOMING_CALL','SEGU',NULL),(164,'Observaciones','STRING',1,1,'INCOMING_CALL',NULL,NULL);

ALTER TABLE `saludcantabriaresponde`.`question` DROP COLUMN `question_parent_type`;
ALTER TABLE `saludcantabriaresponde`.`question` DROP COLUMN `question_block`;

CREATE TABLE `saludcantabriaresponde`.`question_block` (
  `qb_code` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `qb_description` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `qb_enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`qb_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

INSERT INTO `saludcantabriaresponde`.`question_block` VALUES ('ACTI',' ',1),('CONTE','Contacto Estrecho',1),('CONV','',1),('INCI','Registro de incidencias',1),('INDRE','Indicación Realizada',1),('INRE','Intervención realizada',1),('MAIN','Clasificación',1),('PROF',' ',1),('PTRE','Patologías de riesgo',1),('RISO','Riesgo social',1),('SAME','Cribaje Salud Mental',1),('SEGU','Seguimiento',1),('SYMP','Síntomas',1),('TRAM','Trámites',1),('VIGE','Despistaje violencia de género',1);

CREATE TABLE `saludcantabriaresponde`.`form_question` (
  `fq_id` INT NOT NULL,
  `fq_form` INT NULL,
  `fq_question` INT NOT NULL,
  `fq_block` VARCHAR(20) COLLATE latin1_spanish_ci NULL,
  `fq_priority` INT NULL,
  PRIMARY KEY (`fq_id`),
  INDEX `fq_form_fk_idx` (`fq_form` ASC) VISIBLE,
  INDEX `fq_question_fk_idx` (`fq_question` ASC) VISIBLE,
  CONSTRAINT `fq_form_fk`
    FOREIGN KEY (`fq_form`)
    REFERENCES `saludcantabriaresponde`.`form` (`f_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fq_question_fk`
    FOREIGN KEY (`fq_question`)
    REFERENCES `saludcantabriaresponde`.`question` (`q_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `fq_block_fk`
  FOREIGN KEY (`fq_block`)
  REFERENCES `saludcantabriaresponde`.`question_block` (`qb_code`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);

ALTER TABLE `saludcantabriaresponde`.`form_question` 
CHANGE COLUMN `fq_id` `fq_id` INT NOT NULL AUTO_INCREMENT ;


  
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,82, 1);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,83, 4);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,84, 5);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,85, 6);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,86, 7);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,87, 8);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,88, 11);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,89, 10);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,90, 13);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,91, 14);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,92, 15);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,119, 2);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,120, 9);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,121, 12);
INSERT INTO `saludcantabriaresponde`.`form_question`(`fq_form`,`fq_question`,`fq_priority`) VALUES(1,131, 3);

UPDATE `saludcantabriaresponde`.`form_question` SET `fq_block` = 'PTRE' WHERE (`fq_id` = '11');
UPDATE `saludcantabriaresponde`.`form_question` SET `fq_block` = 'PTRE' WHERE (`fq_id` = '15');




CREATE TABLE `saludcantabriaresponde`.`patient_file_status` (
  `pfs_code` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pfs_description` varchar(90) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pfs_enabled` tinyint(1) NOT NULL DEFAULT '1',
  `pfs_sort` int DEFAULT NULL,
  PRIMARY KEY (`pfs_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

INSERT INTO `patient_file_status` VALUES ('CLOSED','Cerrado',1,2),('ACTIVE','En seguimiento',1,1);

CREATE TABLE `saludcantabriaresponde`.`phone_call` (
  `pc_id` int NOT NULL AUTO_INCREMENT,
  `pc_phone_number` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pc_caller` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pc_observations` varchar(3000) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pc_call_date` datetime NOT NULL,
  `pc_end_call_date` datetime,
  `pc_is_appropiate_call` tinyint(1) NOT NULL,
  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`pc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;



CREATE TABLE `saludcantabriaresponde`.`patient_answer` (
  `pa_id` int NOT NULL AUTO_INCREMENT,
  `pa_question_id` int NOT NULL,
  `pa_answer` varchar(5000) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pa_original_question_text` varchar(250) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pa_original_answer_type` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pa_question_block_id` varchar(20),
  `pa_original_question_block_text` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pa_form_id` int not null,
  `pa_original_form_title` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pa_original_form_category` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`pa_id`),
  KEY `FK_PA_QUESTION_ID` (`pa_question_id`),
  CONSTRAINT `FK_PA_QUESTION_ID` FOREIGN KEY (`pa_question_id`) REFERENCES `question` (`q_id`),
  
  KEY `FK_PA_QUESTION_BLOCK_ID` (`pa_question_block_id`),
  CONSTRAINT `FK_PA_QUESTION_BLOCK_ID` FOREIGN KEY (`pa_question_block_id`) REFERENCES `question_block` (`qb_code`),
  
  KEY `FK_PA_FORM_ID` (`pa_form_id`),
  CONSTRAINT `FK_PA_FORM_ID` FOREIGN KEY (`pa_form_id`) REFERENCES `form` (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `saludcantabriaresponde`.`patient_file` (
  `pf_id` int NOT NULL AUTO_INCREMENT,
  
  `pf_dni` varchar(30) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_cip` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_scs` tinyint DEFAULT NULL,
  
  `pf_name` varchar(60) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_surname` varchar(120) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
    
  `pf_birthdate` date DEFAULT NULL,
  `pf_age` int DEFAULT NULL,
  
  `pf_email` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_phone` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  
  `pf_address` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_locality` varchar(125) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_postalCode` varchar(5) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,

  `pf_status` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_reopened` tinyint(1) DEFAULT '0',
  
  `pf_health_centre` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_health_centre_code` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_health_centre_zone_code` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_health_centre_zone_name` varchar(300) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_doctor` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pf_nurse` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  
  -- `pf_phone_call_id` int,
  

  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  
  PRIMARY KEY (`pf_id`),
  KEY `idx_pfile_status` (`pf_status`),
  KEY `idx_pfile_dni` (`pf_dni`),
  KEY `idx_pfile_phone` (`pf_phone`),
  KEY `idx_pfile_cip` (`pf_cip`)-- ,
  -- KEY `FK_PF_PHONE_CALL_ID` (`pf_phone_call_id`),
  -- CONSTRAINT `FK_PF_PHONE_CALL_ID` FOREIGN KEY (`pf_phone_call_id`) REFERENCES `saludcantabriaresponde`.`incoming_phone_call` (`pc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE `saludcantabriaresponde`.`phone_call_pf` (
  `pcpf_id` int NOT NULL AUTO_INCREMENT,
  
  `pcpf_phone_call_id` int NOT NULL,
  `pcpf_patient_file_id` int NOT NULL,
    

  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  
  PRIMARY KEY (`pcpf_id`),
  KEY `FK_PCPF_PHONE_CALL_ID` (`pcpf_phone_call_id`),
  CONSTRAINT `FK_PCPF_PHONE_CALL_ID` FOREIGN KEY (`pcpf_phone_call_id`) REFERENCES `saludcantabriaresponde`.`phone_call` (`pc_id`),
  KEY `FK_PCPF_PATIENT_FILE_ID` (`pcpf_patient_file_id`),
  CONSTRAINT `FK_PCPF_PATIENT_FILE_ID` FOREIGN KEY (`pcpf_patient_file_id`) REFERENCES `saludcantabriaresponde`.`patient_file` (`pf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE `saludcantabriaresponde`.`phone_call_pf_f` (
  `pcpff_id` int NOT NULL AUTO_INCREMENT,
  
  `pcpff_pcpf_id` int NOT NULL,
  `pcpff_form_id` int NOT NULL,
    

  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  
  PRIMARY KEY (`pcpff_id`),
  KEY `fk_pcpff_pcpf_id` (`pcpff_pcpf_id`),
  CONSTRAINT `fk_pcpff_pcpf_id` FOREIGN KEY (`pcpff_pcpf_id`) REFERENCES `saludcantabriaresponde`.`phone_call_pf` (`pcpf_id`),
  KEY `fk_pcpff_form_id` (`pcpff_form_id`),
  CONSTRAINT `fk_pcpff_form_id` FOREIGN KEY (`pcpff_form_id`) REFERENCES `saludcantabriaresponde`.`form` (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE `saludcantabriaresponde`.`phone_call_pf_f_a` (
  `pcpffa_id` int NOT NULL AUTO_INCREMENT,
  `pcpffa_pcpff_id` int NOT NULL,
  
  `pcpffa_question_id` int NOT NULL,
  `pcpffa_answer` varchar(5000) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `pcpffa_original_question_text` varchar(250) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pcpffa_original_answer_type` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pcpffa_question_block_id` varchar(20),
  `pcpffa_original_question_block_text` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pcpffa_form_id` int not null,
  `pcpffa_original_form_title` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `pcpffa_original_form_category` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  
  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`pcpffa_id`),
  KEY `FK_pcpffa_QUESTION_ID` (`pcpffa_question_id`),
  CONSTRAINT `FK_pcpffa_QUESTION_ID` FOREIGN KEY (`pcpffa_question_id`) REFERENCES `question` (`q_id`),
  
  KEY `FK_pcpffa_QUESTION_BLOCK_ID` (`pcpffa_question_block_id`),
  CONSTRAINT `FK_pcpffa_QUESTION_BLOCK_ID` FOREIGN KEY (`pcpffa_question_block_id`) REFERENCES `question_block` (`qb_code`),
  
  KEY `FK_pcpffa_FORM_ID` (`pcpffa_form_id`),
  CONSTRAINT `FK_pcpffa_FORM_ID` FOREIGN KEY (`pcpffa_form_id`) REFERENCES `form` (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `saludcantabriaresponde`.`form_category` (
  `fc_code` varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `fc_title` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `fc_description` varchar(150) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `fc_enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`fc_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

INSERT INTO saludcantabriaresponde.form_category (fc_code, fc_title, fc_description, fc_enabled) VALUES('VIEP', 'Vigilancia epidemiológica', 'Formularios de vigilancia epidemiológica', 1);
INSERT INTO saludcantabriaresponde.form_category (fc_code, fc_title, fc_description, fc_enabled) VALUES('PPSA', 'Prevención y promoción de la salud', 'Formularios de prevención y promoción de la salud', 1);
INSERT INTO saludcantabriaresponde.form_category (fc_code, fc_title, fc_description, fc_enabled) VALUES('COAS', 'Continuidad asistencial', 'Formularios de continuidad asistencial', 1);
INSERT INTO saludcantabriaresponde.form_category (fc_code, fc_title, fc_description, fc_enabled) VALUES('ACCE', 'Accesibilidad', 'Formularios de accesibilidad', 1);


ALTER TABLE `saludcantabriaresponde`.`form` 
CHANGE COLUMN `f_category` `f_category` VARCHAR(20) NULL DEFAULT NULL ;


CREATE TABLE `saludcantabriaresponde`.`user` (
  `username` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar(60) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `role` int DEFAULT NULL,
  `enabled` tinyint NOT NULL DEFAULT '1',
  `name` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `surname` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `surname2` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `dni` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `type` varchar(25) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `zone` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `residence_id` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `clinical_profile` tinyint DEFAULT NULL,
  `phone` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastLogin` datetime DEFAULT NULL,
  `school_id` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `covid_group_id` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `loginAttempts` int DEFAULT NULL,
  `lockMessage` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `covid_group_residence_id` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `view_school` tinyint DEFAULT NULL,
  `view_university` tinyint DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

insert into `saludcantabriaresponde`.`user` values('admin','$2a$10$x1J91w39fBZJ91edusdSW.FvPvEptdLQeBON.3y4JWEnfD/JYMr4G',NULL,1,'Administrador','Admin',' ',NULL,'admin@prueba.com','USER_900',NULL,NULL,'anonymousUser','2022-11-23 12:29:35',NULL,NULL,1,'','2022-11-23 12:29:35',NULL,NULL,1,NULL,NULL,1,1);

CREATE TABLE `saludcantabriaresponde`.`role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `description` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `origin` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  `module` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE `saludcantabriaresponde`.`user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `role` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=462 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

insert into `saludcantabriaresponde`.`role`(id,code,description) value(1,'ROLE_SCR_ADMIN','Administrador');
insert into `saludcantabriaresponde`.`user_role` values(1, 'admin', 1);
