CREATE TABLE `saludcantabriaresponde`.`timeline_event_type` (
  `id` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `color` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `lastModifiedBy` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

insert into`saludcantabriaresponde`.`timeline_event_type` (id, name, color) VALUES ('VACC', 'Vacunas', '#FF7008');
insert into`saludcantabriaresponde`.`timeline_event_type` (id, name, color) VALUES ('ALLE', 'Alergias', '#4D6846');
insert into`saludcantabriaresponde`.`timeline_event_type` (id, name, color) VALUES ('MEDI', 'Medicamentos', '#04FFFF');
insert into`saludcantabriaresponde`.`timeline_event_type` (id, name, color) VALUES ('CUPR', 'Problemas en curso', '#04F222');
insert into`saludcantabriaresponde`.`timeline_event_type` (id, name, color) VALUES ('PAPR', 'Problemas pasados', '#04F333');

commit;
