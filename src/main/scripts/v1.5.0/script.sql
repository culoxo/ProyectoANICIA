CREATE TABLE `saludcantabriaresponde`.`audit_pf_dashboard` (
  `apfd_id` INT NOT NULL AUTO_INCREMENT,
  `apfd_user` VARCHAR(45) NOT NULL,
  `apfd_datetime` DATETIME NOT NULL,
  `apfd_widget` VARCHAR(45) NOT NULL,
  `apfd_widget_info` VARCHAR(1000) NULL,
  PRIMARY KEY (`apfd_id`));


CREATE TABLE `saludcantabriaresponde`.`widget` (
  `w_id` VARCHAR(45) NOT NULL,
  `w_title` VARCHAR(45) NOT NULL,
  `w_description` VARCHAR(150) NULL,
  PRIMARY KEY (`w_id`));

ALTER TABLE `saludcantabriaresponde`.`audit_pf_dashboard` 
ADD CONSTRAINT `fk_apfd_widget`
  FOREIGN KEY (apfd_widget)
  REFERENCES `saludcantabriaresponde`.`widget` (w_id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  ALTER TABLE `saludcantabriaresponde`.`audit_pf_dashboard` 
ADD COLUMN `apfd_patient_file` INT NOT NULL AFTER `apfd_widget_info`,
ADD INDEX `fk_apfd_patient_file_idx` (`apfd_patient_file` ASC);
;
ALTER TABLE `saludcantabriaresponde`.`audit_pf_dashboard` 
ADD CONSTRAINT `fk_apfd_patient_file`
  FOREIGN KEY (`apfd_patient_file`)
  REFERENCES `saludcantabriaresponde`.`patient_file` (`pf_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

INSERT INTO `saludcantabriaresponde`.`widget` (`w_id`, `w_title`) VALUES ('PATIENT_BASIC_DATA', 'Datos básicos paciente');
INSERT INTO `saludcantabriaresponde`.`widget` (`w_id`, `w_title`) VALUES ('TIMELINE', 'Historial médico');
INSERT INTO `saludcantabriaresponde`.`widget` (`w_id`, `w_title`) VALUES ('APPOINTMENTS', 'Próximas citas');
INSERT INTO `saludcantabriaresponde`.`widget` (`w_id`, `w_title`) VALUES ('VACCINATIONS', 'Vacunas');
INSERT INTO `saludcantabriaresponde`.`widget` (`w_id`, `w_title`, `w_description`) VALUES ('CALL_HISTORY', 'Llamadas', '');
INSERT INTO `saludcantabriaresponde`.`widget` (`w_id`, `w_title`) VALUES ('NOTES', 'Notas');

ALTER TABLE `saludcantabriaresponde`.`phone_call_pf_f` 
ADD COLUMN `pcpff_deleted` BIT(1) NULL DEFAULT NULL AFTER `lastModifiedDate`;

ALTER TABLE `saludcantabriaresponde`.`phone_call_pf_f` 
CHANGE COLUMN `pcpff_deleted` `pcpff_deleted` BIT(1) NULL DEFAULT 0 ;




