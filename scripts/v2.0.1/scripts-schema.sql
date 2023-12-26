alter table user modify dni_complete VARCHAR(100);
ALTER TABLE form MODIFY f_title VARCHAR(150)
ALTER TABLE phone_call_pf_f_a  MODIFY pcpffa_original_form_title VARCHAR(150)
ALTER TABLE phone_call_pf_f_a  MODIFY pcpffa_original_form_category VARCHAR(150)
ALTER TABLE form MODIFY f_category CHAR(6)

ALTER TABLE patient_file ADD COLUMN pf_phone_1 VARCHAR(45) AFTER pf_phone;
