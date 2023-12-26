CREATE TABLE module (
    m_id varchar(45),
    m_description varchar(250),
    m_url varchar(500),
    PRIMARY KEY (m_id)
);

ALTER TABLE user_role ADD COLUMN userid int AFTER role;

ALTER TABLE user_role DROP COLUMN username;

ALTER TABLE patient_file ADD COLUMN pf_module Varchar(45);

ALTER TABLE form_category ADD COLUMN fc_module Varchar(45);

ALTER TABLE form ADD COLUMN f_module Varchar(45);

ALTER TABLE form ADD COLUMN createdBy varchar(45);
ALTER TABLE form ADD COLUMN createdDate datetime;
ALTER TABLE form ADD COLUMN lastModifiedBy varchar(45);
ALTER TABLE form ADD COLUMN lastModifiedDate datetime;

ALTER TABLE widget ADD COLUMN w_code varchar(45);

CREATE TABLE widget_module (
    wm_id int NOT NULL AUTO_INCREMENT,
    wm_module varchar(45),
    wm_widget varchar(500),
    PRIMARY KEY (wm_id)
);
ALTER TABLE widget_module ADD COLUMN wm_x int;
ALTER TABLE widget_module ADD COLUMN wm_y int;
ALTER TABLE widget_module ADD COLUMN wm_w int;
ALTER TABLE widget_module ADD COLUMN wm_h int;
ALTER TABLE widget_module ADD COLUMN wm_minW int;
ALTER TABLE widget_module ADD COLUMN wm_minH int;
ALTER TABLE widget_module ADD COLUMN wm_role varchar(45);


CREATE TABLE poll_pf (
    ppf_id int NOT NULL AUTO_INCREMENT,
    ppf_patient_file_id int,
    ppf_poll_date datetime not null,
    ppf_poll_end_date datetime,
    ppf_status_code varchar(20) default 'CREATED',
    ppf_sms_sent int,
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    PRIMARY KEY (ppf_id)
);
alter table poll_pf convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.poll_pf ADD CONSTRAINT FK_PPF_PATIENT_FILE_ID FOREIGN KEY (ppf_patient_file_id) REFERENCES saludcantabriaresponde.patient_file(pf_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE poll_pf_f (
    ppff_id int NOT NULL AUTO_INCREMENT,
    ppff_ppf_id int not null,
    ppff_form_id int not null,
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    ppff_deleted bit (1),
    PRIMARY KEY (ppff_id)
);
alter table poll_pf_f convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.poll_pf_f ADD CONSTRAINT FK_PPFF_POLL_PF_ID FOREIGN KEY (ppff_ppf_id) REFERENCES saludcantabriaresponde.poll_pf(ppf_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.poll_pf_f ADD CONSTRAINT fk_ppff_form_id FOREIGN KEY (ppff_form_id) REFERENCES saludcantabriaresponde.form(f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE poll_pf_f_a (
    ppffa_id int NOT NULL AUTO_INCREMENT,
    ppffa_ppff_id int not null,
    ppffa_question_id int not null,
    ppffa_answer varchar(5000),
    ppffa_original_question_text varchar(500),
    ppffa_original_answer_type varchar(20) not null,
    ppffa_question_block_id char(6),
    ppffa_original_question_block_text varchar(100),
    ppffa_form_id int not null,
    ppffa_original_form_title varchar(2000),
    ppffa_original_form_category varchar(45),    
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    PRIMARY KEY (ppffa_id)
);
alter table poll_pf_f_a convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.poll_pf_f_a ADD CONSTRAINT FK_ppffa_FORM_ID FOREIGN KEY (ppffa_form_id) REFERENCES saludcantabriaresponde.form(f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.poll_pf_f_a ADD CONSTRAINT FK_ppffa_QUESTION_ID FOREIGN KEY (ppffa_question_id) REFERENCES saludcantabriaresponde.question(q_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.poll_pf_f_a ADD CONSTRAINT FK_ppffa_QUESTION_BLOCK_ID FOREIGN KEY (ppffa_question_block_id) REFERENCES saludcantabriaresponde.question_block(qb_code) ON DELETE RESTRICT ON UPDATE RESTRICT;



CREATE TABLE sport_prescription_pf (
    sppf_id int NOT NULL AUTO_INCREMENT,
    sppf_patient_file_id int,
    sppf_sport_prescription_date datetime not null,
    sppf_sport_prescription_end_date datetime,
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    PRIMARY KEY (sppf_id)
);
alter table sport_prescription_pf convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.sport_prescription_pf ADD CONSTRAINT FK_SPPF_PATIENT_FILE_ID FOREIGN KEY (sppf_patient_file_id) REFERENCES saludcantabriaresponde.patient_file(pf_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE sport_prescription_pf_f (
    sppff_id int NOT NULL AUTO_INCREMENT,
    sppff_sppf_id int not null,
    sppff_form_id int not null,
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    sppff_deleted bit (1),
    PRIMARY KEY (sppff_id)
);
alter table sport_prescription_pf_f convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.sport_prescription_pf_f ADD CONSTRAINT FK_SPPFF_POLL_PF_ID FOREIGN KEY (sppff_sppf_id) REFERENCES saludcantabriaresponde.poll_pf(ppf_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.sport_prescription_pf_f ADD CONSTRAINT fk_sppff_form_id FOREIGN KEY (sppff_form_id) REFERENCES saludcantabriaresponde.form(f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE sport_prescription_pf_f_a (
    sppffa_id int NOT NULL AUTO_INCREMENT,
    sppffa_sppff_id int not null,
    sppffa_question_id int not null,
    sppffa_answer varchar(5000),
    sppffa_original_question_text varchar(500),
    sppffa_original_answer_type varchar(20) not null,
    sppffa_question_block_id char(6),
    sppffa_original_question_block_text varchar(100),
    sppffa_form_id int not null,
    sppffa_original_form_title varchar(2000),
    sppffa_original_form_category varchar(45),    
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    PRIMARY KEY (sppffa_id)
);
alter table sport_prescription_pf_f_a convert to character set latin1 collate latin1_spanish_ci;
ALTER TABLE saludcantabriaresponde.sport_prescription_pf_f_a ADD CONSTRAINT FK_sppffa_FORM_ID FOREIGN KEY (sppffa_form_id) REFERENCES saludcantabriaresponde.form(f_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.sport_prescription_pf_f_a ADD CONSTRAINT FK_sppffa_QUESTION_ID FOREIGN KEY (sppffa_question_id) REFERENCES saludcantabriaresponde.question(q_id) ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE saludcantabriaresponde.sport_prescription_pf_f_a ADD CONSTRAINT FK_sppffa_QUESTION_BLOCK_ID FOREIGN KEY (sppffa_question_block_id) REFERENCES saludcantabriaresponde.question_block(qb_code) ON DELETE RESTRICT ON UPDATE RESTRICT;

CREATE TABLE poll_pf_status (
    ppfs_code VARCHAR(20),
    ppfs_description varchar(90),
    PRIMARY KEY (ppfs_code)
);

CREATE TABLE pin (
    p_id int NOT NULL AUTO_INCREMENT,
    p_request_id varchar(10),
    p_pin varchar(10),
    p_nif varchar(20),
    p_name varchar(100),
    p_surname varchar(100),
    p_phone_number varchar(20),
    p_ppf_id int,
    p_url_generated varchar(250),
    p_begin_date datetime,  
    createdBy varchar(45),
    createdDate datetime,
    lastModifiedBy varchar(45),
    lastModifiedDate datetime,
    PRIMARY KEY (p_id)
);

ALTER TABLE role MODIFY COLUMN module varchar(45);