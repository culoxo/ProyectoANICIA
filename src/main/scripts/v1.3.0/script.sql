CREATE TABLE `saludcantabriaresponde`.`appointed_phone_call` (
  `apc_id` INT NOT NULL AUTO_INCREMENT,
  `apc_date` DATETIME NOT NULL,
  `apc_observations` VARCHAR(500) NULL,
  PRIMARY KEY (`apc_id`));

ALTER TABLE `saludcantabriaresponde`.`appointed_phone_call` 
ADD COLUMN `apc_patient_file` INT NOT NULL AFTER `apc_observations`;

ALTER TABLE `saludcantabriaresponde`.`appointed_phone_call` 
ADD COLUMN `apc_phone_call_done` INT NULL AFTER `apc_patient_file`;

alter table appointed_phone_call
add column `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
add column  `createdDate` datetime DEFAULT NULL,
add column  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
add column   `lastModifiedDate` datetime DEFAULT NULL;

ALTER TABLE `saludcantabriaresponde`.`appointed_phone_call` 
ADD COLUMN `apc_phone_number` VARCHAR(15) NULL AFTER `apc_phone_call_done`;
