ALTER TABLE `saludcantabriaresponde`.`phone_call` 
CHANGE COLUMN `pc_phone_number` `pc_phone_number` VARCHAR(100) CHARACTER SET 'latin1' COLLATE 'latin1_spanish_ci' NULL ;

INSERT INTO `saludcantabriaresponde`.`form_category` (`fc_code`, `fc_title`, `fc_description`, `fc_enabled`) VALUES ('VIGEPI', 'Vigilancia epidemiológica', '', '1');
INSERT INTO `saludcantabriaresponde`.`form_category` (`fc_code`, `fc_title`, `fc_description`, `fc_enabled`) VALUES ('PREV', 'Prevención y promoción de la salud', '', '1');
INSERT INTO `saludcantabriaresponde`.`form_category` (`fc_code`, `fc_title`, `fc_description`, `fc_enabled`) VALUES ('CONASIS', 'Continuidad asistencial', '', '1');
INSERT INTO `saludcantabriaresponde`.`form_category` (`fc_code`, `fc_title`, `fc_description`, `fc_enabled`) VALUES ('ACCES', 'Accesibilidad', '', '1');

UPDATE `saludcantabriaresponde`.`form` SET `f_category` = 'VIGEPI' WHERE (`f_id` = '1');
UPDATE `saludcantabriaresponde`.`form` SET `f_category` = 'VIGEPI' WHERE (`f_id` = '2');
UPDATE `saludcantabriaresponde`.`form` SET `f_category` = 'VIGEPI' WHERE (`f_id` = '3');
UPDATE `saludcantabriaresponde`.`form` SET `f_category` = 'VIGEPI' WHERE (`f_id` = '4');
UPDATE `saludcantabriaresponde`.`form` SET `f_category` = 'CONASIS' WHERE (`f_id` = '7');
UPDATE `saludcantabriaresponde`.`form` SET `f_category` = 'PREV' WHERE (`f_id` = '6');
UPDATE `saludcantabriaresponde`.`form` SET `f_category` = 'ACCES' WHERE (`f_id` = '5');

