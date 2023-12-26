CREATE TABLE `saludcantabriaresponde`.`patient_file_note` (
  `pfn_id` INT NOT NULL AUTO_INCREMENT,
  `pfn_content` VARCHAR(500) NOT NULL,
  `pfn_date` DATETIME NOT NULL,
  PRIMARY KEY (`pfn_id`));

ALTER TABLE `saludcantabriaresponde`.`patient_file_note` 
DROP COLUMN `pfn_date`,
ADD COLUMN `pfn_patient_file_id` INT NOT NULL AFTER `pfn_content`,
ADD INDEX `fk_pfn_pf_idx` (`pfn_patient_file_id` ASC) VISIBLE;
;
ALTER TABLE `saludcantabriaresponde`.`patient_file_note` 
ADD CONSTRAINT `fk_pfn_pf`
  FOREIGN KEY (`pfn_patient_file_id`)
  REFERENCES `saludcantabriaresponde`.`patient_file` (`pf_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


alter table patient_file_note
add column `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
add column  `createdDate` datetime DEFAULT NULL,
add column  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
add column   `lastModifiedDate` datetime DEFAULT NULL;

ALTER TABLE `saludcantabriaresponde`.`patient_file_note` 
ADD COLUMN `deleted` BIT(1) NULL DEFAULT 0 AFTER `lastModifiedDate`;
