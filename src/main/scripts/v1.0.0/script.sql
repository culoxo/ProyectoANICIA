UPDATE `saludcantabriaresponde`.`timeline_event_type` SET `order` = '1' WHERE (`id` = 'MEDI');
UPDATE `saludcantabriaresponde`.`timeline_event_type` SET `order` = '5' WHERE (`id` = 'CUPR');

ALTER TABLE `saludcantabriaresponde`.`doc_appo_event_type` 
ADD COLUMN `order` TINYINT(1) NULL AFTER `lastModifiedDate`;

UPDATE `saludcantabriaresponde`.`doc_appo_event_type` SET `order` = '1' WHERE (`id` = 'PRIM');
UPDATE `saludcantabriaresponde`.`doc_appo_event_type` SET `order` = '2' WHERE (`id` = 'HOSP');
UPDATE `saludcantabriaresponde`.`doc_appo_event_type` SET `order` = '3' WHERE (`id` = 'HOTE');

