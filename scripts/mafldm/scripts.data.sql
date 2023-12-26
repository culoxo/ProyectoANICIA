INSERT INTO role (code, description, module) VALUES ('ROLE_MAFLDM_ADMIN', 'Administrador', 'MAFLDM');
INSERT INTO role (code, description, module) VALUES ('ROLE_MAFLDM_CLINICAL', 'Clínico', 'MAFLDM');

INSERT INTO module (m_id, m_description, m_url) VALUES ('MAFLDM', 'MAFLDM', '/mafldm');

INSERT INTO calendar_event_type (cet_id, cet_name, cet_module, cet_color) VALUES ('SP', 'Actividad Deportiva', 'SP', '#fd7e14');
INSERT INTO calendar_event_type (cet_id, cet_name, cet_module, cet_color) VALUES ('EF', 'Cita Educador Físico', 'SP', '#6099d3');
INSERT INTO calendar_event_type (cet_id, cet_name, cet_module, cet_color) VALUES ('SP-PRIM', 'Cita Médica', 'SP', '#1b5281');
INSERT INTO calendar_event_type (cet_id, cet_name, cet_module, cet_color) VALUES ('MAFLDM-PRIM', 'Cita Médica', 'MAFLDM', '#1b5281');