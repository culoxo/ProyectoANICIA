ALTER TABLE form MODIFY COLUMN f_description varchar(5000) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;
ALTER TABLE question ADD COLUMN q_header tinyint(1) AFTER q_priority;
ALTER TABLE phone_call_pf_f_a MODIFY COLUMN pcpffa_original_form_title varchar(200) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;

ALTER TABLE question MODIFY COLUMN q_text varchar(500) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;
ALTER TABLE phone_call_pf_f_a MODIFY COLUMN pcpffa_original_question_text varchar(500) CHARACTER SET latin1 COLLATE latin1_spanish_ci NULL;



ALTER TABLE saludcantabriaresponde.question ADD q_answers_hz INT NULL;
