ALTER TABLE `saludcantabriaresponde`.`timeline_event_type` 
ADD COLUMN `order` TINYINT NULL AFTER `lastModifiedDate`;

UPDATE `saludcantabriaresponde`.`timeline_event_type` SET `order` = '2' WHERE (`id` = 'ALLE');
UPDATE `saludcantabriaresponde`.`timeline_event_type` SET `order` = '5' WHERE (`id` = 'MEDI');
UPDATE `saludcantabriaresponde`.`timeline_event_type` SET `order` = '1' WHERE (`id` = 'CUPR');
UPDATE `saludcantabriaresponde`.`timeline_event_type` SET `order` = '3' WHERE (`id` = 'VACC');
UPDATE `saludcantabriaresponde`.`timeline_event_type` SET `order` = '4' WHERE (`id` = 'PAPR');

