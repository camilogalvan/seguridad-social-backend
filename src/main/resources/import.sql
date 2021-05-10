INSERT INTO sspt_rol (descripcion,rol) VALUES ('Administrador','ROLE_ADMIN');
INSERT INTO sspt_rol (descripcion,rol) VALUES ('Gerente','ROLE_GERENTE');
INSERT INTO sspt_rol (descripcion,rol) VALUES ('Usuario','ROLE_USER');

INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Registro civil','RC');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Tarjeta de identidad','TI');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Cédula de ciudadanía','CC');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Cédula de extranjería','CE');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Pasaporte','PA');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Certificado de nacido vivo','NV');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Carné diplomático','CD');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Salvo conducto de permanencia','SC');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Pasaporte de la ONU','PR');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Permiso Especial de Permanencia','PE');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('NIT','NI');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Adulto sin Identificación','AS');
INSERT INTO sspt_tipo_identificacion (descripcion,tipo) VALUES ('Menor sin Identificación','MS');

INSERT INTO sspt_usuario (apellidos,email,"enable",fecha_registro,identificacion,nombres,"password",username,id_rol,id_tipo_identificacion) VALUES ('ramón montes','omarmontes.879@gmail.com',true,'2019-06-29 15:47:30.000','1093792354','omar','$2a$10$a3syW59aYf6/a1wtf7PYVOFJnTWHe6dlc7mQ91s.u/pN./rLwDn5O','omarrm',1,3);
