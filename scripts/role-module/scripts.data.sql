INSERT INTO module VALUES ('SCR','Salud Cantabria Responde','/');
INSERT INTO module VALUES ('PD','Prescripción Deportiva', '/sport-prescription');
INSERT INTO module VALUES ('ENC','Encuestas', '/poll');

//Insertar roles
INSERT INTO role (code, description, module) VALUES ('ROLE_SP_ADMIN', 'Administrador', 'PD');
INSERT INTO role (code, description, module) VALUES ('ROLE_PD_CLINICAL', 'Clínico', 'PD');
INSERT INTO role (code, description, module) VALUES ('ROLE_PD_EF', 'Educador Físico', 'PD');
INSERT INTO role (code, description, module) VALUES ('ROLE_PD_COORD', 'Coordinador', 'PD');
INSERT INTO role (code, description, module) VALUES ('ROLE_POLL_ADMIN', 'Administrador', 'ENC');
INSERT INTO role (code, description, module) VALUES ('ROLE_POLL_TECHNICAN', 'Técnico', 'ENC');

//Actualizar roles viejos
UPDATE role SET code='ROLE_SCR_ADMIN' WHERE code = 'ROLE_ADMIN';
UPDATE role SET code='ROLE_SCR_CLINICAL' WHERE code = 'ROLE_CLINICAL';
UPDATE role SET code='ROLE_SCR_ASSISTANT' WHERE code = 'ROLE_ASSISTANT';

//Si eliminamos username de user_role
INSERT INTO user_role (role, userid) VALUES (1, 1);



INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minW, wm_minH, wm_role) VALUES ('SCR', 'patient-basic-data',0,0,4,6,4,6,'ROLE_SCR_ADMIN');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minW, wm_minH, wm_role) VALUES ('SCR', 'appointments',0,7,4,6,4,6,'ROLE_SCR_ADMIN');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'call-summary',9,0,3,1,'ROLE_SCR_ADMIN');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'call-history',9,2,3,4,'ROLE_SCR_ADMIN');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'notes',9,6,3,3,'ROLE_SCR_ADMIN');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minH, wm_role) VALUES ('SCR', 'chronology',4,4,5,8,3,'ROLE_SCR_ADMIN');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'vaccines',4,12,5,3,'ROLE_SCR_ADMIN');

INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minW, wm_minH, wm_role) VALUES ('SCR', 'patient-basic-data',0,0,4,6,4,6,'ROLE_SCR_CLINICAL');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minW, wm_minH, wm_role) VALUES ('SCR', 'appointments',0,7,4,6,4,6,'ROLE_SCR_CLINICAL');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'call-summary',9,0,3,1,'ROLE_SCR_CLINICAL');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'call-history',9,2,3,4,'ROLE_SCR_CLINICAL');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'notes',9,6,3,3,'ROLE_SCR_CLINICAL');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minH, wm_role) VALUES ('SCR', 'chronology',4,4,5,8,3,'ROLE_SCR_CLINICAL');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'vaccines',4,12,5,3,'ROLE_SCR_CLINICAL');


INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minW, wm_minH, wm_role) VALUES ('SCR', 'patient-basic-data',0,0,4,6,4,6,'ROLE_SCR_ASSISTANT');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minW, wm_minH, wm_role) VALUES ('SCR', 'appointments',4,0,5,6,4,6,'ROLE_SCR_ASSISTANT');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'call-summary',9,0,3,1,'ROLE_SCR_ASSISTANT');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'call-history',9,2,3,4,'ROLE_SCR_ASSISTANT');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('SCR', 'notes',9,6,3,3,'ROLE_SCR_ASSISTANT');

INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minW, wm_minH, wm_role) VALUES ('ENC', 'patient-basic-data',0,0,5,6,4,6,'ROLE_POLL_ADMIN');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('ENC', 'poll-history',5,0,7,6,'ROLE_POLL_ADMIN');

INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_minW, wm_minH, wm_role) VALUES ('ENC', 'patient-basic-data',0,0,4,6,4,6,'ROLE_POLL_TECHNICAN');
INSERT INTO widget_module (wm_module, wm_widget, wm_x, wm_y, wm_w, wm_h, wm_role) VALUES ('ENC', 'poll-history',4,0,5,6,'ROLE_POLL_TECHNICAN');


INSERT INTO poll_pf_status (ppfs_code, ppfs_description) VALUES ('CREATED', 'Encuesta creada');
INSERT INTO poll_pf_status (ppfs_code, ppfs_description) VALUES ('STARTED', 'Encuesta empezada');
INSERT INTO poll_pf_status (ppfs_code, ppfs_description) VALUES ('TO_SEND', 'Para enviar por SMS');
INSERT INTO poll_pf_status (ppfs_code, ppfs_description) VALUES ('SENT', 'Encuesta enviada por SMS');
INSERT INTO poll_pf_status (ppfs_code, ppfs_description) VALUES ('ENDED', 'Encuesta finalizada');
INSERT INTO poll_pf_status (ppfs_code, ppfs_description) VALUES ('SMS_FAILED', 'Fallo de SMS');