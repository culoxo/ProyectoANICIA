CREATE TABLE `saludcantabriaresponde`.`health_centre` (
  `id` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `name` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `address` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `locality` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `codPostal` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `phone` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

insert into`saludcantabriaresponde`.`health_centre` (id, name, address, locality, codPostal, phone, email)
select id, name, address, locality, codPostal, phone, email from `covid19900`.`health_centre`;

UPDATE `saludcantabriaresponde`.`patient_file_status` SET `pfs_code` = 'ACTIVE' WHERE (`pfs_code` = 'PENDING');

