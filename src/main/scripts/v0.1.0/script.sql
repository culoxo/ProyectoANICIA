CREATE TABLE `saludcantabriaresponde`.`doc_appo_event_type` (
  `id` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `color` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

insert into`saludcantabriaresponde`.`doc_appo_event_type` (id, name, color) VALUES ('PRIM', 'Primaria', '#2A93D5');
insert into`saludcantabriaresponde`.`doc_appo_event_type` (id, name, color) VALUES ('HOSP', 'Hospital', '#DC3545');
insert into`saludcantabriaresponde`.`doc_appo_event_type` (id, name, color) VALUES ('HOTE', 'Prueba hospital', '#F8AD33');
commit;
