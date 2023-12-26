ALTER TABLE user ADD COLUMN deletedAt DATETIME AFTER createdDate;
ALTER TABLE form ADD COLUMN f_deleted_at DATETIME AFTER f_active ;
ALTER TABLE form_category ADD COLUMN fc_deleted_at DATETIME AFTER fc_enabled;
ALTER TABLE form_question ADD COLUMN fq_deleted_at DATETIME AFTER fq_priority;
ALTER TABLE question_block ADD COLUMN qb_deleted_at DATETIME AFTER qb_priority;
alter table question_block ADD COLUMN qb_form INT AFTER qb_enabled;

ALTER TABLE user DROP COLUMN password;
ALTER TABLE user DROP COLUMN view_university;
ALTER TABLE user DROP COLUMN view_school;
ALTER TABLE user DROP COLUMN covid_group_residence_id;
ALTER TABLE user DROP COLUMN covid_group_id;
ALTER TABLE user DROP COLUMN school_id;
ALTER TABLE user DROP COLUMN residence_id;
ALTER TABLE user DROP COLUMN zone;
ALTER TABLE user DROP COLUMN type;
ALTER TABLE user DROP PRIMARY KEY;
ALTER TABLE user ADD id INT PRIMARY KEY AUTO_INCREMENT FIRST;

ALTER TABLE user ADD COLUMN dni_complete DATETIME AFTER dni;

CREATE TABLE answer_type_options (
    ato_id int NOT NULL AUTO_INCREMENT,
    ato_question int,
    ato_priority int,
    ato_value varchar(250),
    PRIMARY KEY (ato_id)
);
ALTER TABLE form_category ADD fc_clinic tinyint(1) NOT NULL;
ALTER table form_category add `createdBy` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL;
ALTER table form_category add `createdDate` datetime DEFAULT NULL;
ALTER table form_category add `lastModifiedBy` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL;
ALTER table form_category add `lastModifiedDate` datetime DEFAULT NULL;
ALTER TABLE form MODIFY COLUMN f_category varchar(20) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;

ALTER TABLE form ADD f_primary tinyint(4) NULL;

ALTER TABLE answer_type ADD at_description varchar(50) NULL;
UPDATE answer_type anst SET anst.at_description = 'Casilla' where at_id = 'BOOLEAN';
UPDATE answer_type anst SET anst.at_description = 'Fecha' where at_id = 'DATE';
UPDATE answer_type anst SET anst.at_description = 'Número' where at_id = 'NUMBER';
UPDATE answer_type anst SET anst.at_description = 'Radio Custom' where at_id = 'RADIO_CUSTOM';
UPDATE answer_type anst SET anst.at_description = 'Texto' where at_id = 'STRING';
UPDATE answer_type anst SET anst.at_description = 'Sí / No' where at_id = 'YES_NO';


alter table form_category modify fc_code char(6);

set foreign_key_checks=0;
alter table question_block modify qb_code char(6);
alter table form_question modify fq_block char(6);
alter table phone_call_pf_f_a modify pcpffa_question_block_id char(6);
set foreign_key_checks=1;






INSERT INTO role (code, description) VALUES ('ROLE_CLINICAL', 'Clínico');
INSERT INTO role (code, description) VALUES ('ROLE_ASSISTANT', 'Aux. administrativo');
UPDATE user SET role=1 WHERE username = 'k098';
UPDATE user SET role=3 WHERE username = 'o209';


ALTER TABLE answer_type_options DROP COLUMN ato_deleted_at;