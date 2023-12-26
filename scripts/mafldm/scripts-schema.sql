
CREATE TABLE mafldm_questionary_pf (
    mqpf_id int NOT NULL AUTO_INCREMENT,
    mqpf_patient_file_id int,
    mqpf_mafldm_questionary_date datetime not null,
    mqpf_mafldm_questionary_end_date datetime,
    mqpf_status_code varchar(20),
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    PRIMARY KEY (mqpf_id)
);
alter table mafldm_questionary_pf convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.mafldm_questionary_pf ADD CONSTRAINT FK_MQPF_PATIENT_FILE_ID FOREIGN KEY (mqpf_patient_file_id) REFERENCES saludcantabriaresponde.patient_file(pf_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE mafldm_questionary_pf_f (
    mqpff_id int NOT NULL AUTO_INCREMENT,
    mqpff_mqpf_id int not null,
    mqpff_form_id int not null,
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    mqpff_deleted bit (1),
    PRIMARY KEY (mqpff_id)
);
alter table mafldm_questionary_pf_f convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.mafldm_questionary_pf_f ADD CONSTRAINT FK_MQPFF_POLL_PF_ID FOREIGN KEY (mqpff_mqpf_id) REFERENCES saludcantabriaresponde.poll_pf(ppf_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.mafldm_questionary_pf_f ADD CONSTRAINT fk_mqpff_form_id FOREIGN KEY (mqpff_form_id) REFERENCES saludcantabriaresponde.form(f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE mafldm_questionary_pf_f_a (
    mqpffa_id int NOT NULL AUTO_INCREMENT,
    mqpffa_mqpff_id int not null,
    mqpffa_question_id int not null,
    mqpffa_answer varchar(5000),
    mqpffa_original_question_text varchar(500),
    mqpffa_original_answer_type varchar(20) not null,
    mqpffa_question_block_id char(6),
    mqpffa_original_question_block_text varchar(100),
    mqpffa_form_id int not null,
    mqpffa_original_form_title varchar(2000),
    mqpffa_original_form_category varchar(45),    
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    PRIMARY KEY (mqpffa_id)
);
alter table mafldm_questionary_pf_f_a convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.mafldm_questionary_pf_f_a ADD CONSTRAINT FK_mqpffa_FORM_ID FOREIGN KEY (mqpffa_form_id) REFERENCES saludcantabriaresponde.form(f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.mafldm_questionary_pf_f_a ADD CONSTRAINT FK_mqpffa_QUESTION_ID FOREIGN KEY (mqpffa_question_id) REFERENCES saludcantabriaresponde.question(q_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.mafldm_questionary_pf_f_a ADD CONSTRAINT FK_mqpffa_QUESTION_BLOCK_ID FOREIGN KEY (mqpffa_question_block_id) REFERENCES saludcantabriaresponde.question_block(qb_code) ON DELETE RESTRICT ON UPDATE RESTRICT;





RENAME TABLE saludcantabriaresponde.appointed_sport_prescription TO saludcantabriaresponde.appointed_follow_up;
ALTER TABLE saludcantabriaresponde.appointed_follow_up 
COLLATE=latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE asp_id afu_id int auto_increment NOT NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE asp_date afu_date datetime NOT NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE asp_title afu_title varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE asp_type afu_type varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE asp_patient_file afu_patient_file int NOT NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE asp_sport_prescription_done afu_sport_prescription_done int NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE asp_discarded afu_discarded bit(1) NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE afu_sport_prescription_done afu_follow_up_done int NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up ADD afu_module varchar(45) NULL;
ALTER TABLE saludcantabriaresponde.appointed_follow_up CHANGE afu_module afu_module varchar(45) NULL AFTER afu_title;



CREATE TABLE `calendar_event_type` (
  `cet_id` varchar(45) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `cet_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `cet_module` varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  `cet_color` varchar(10) CHARACTER SET latin1 COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`cet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;