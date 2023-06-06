-- SQLBook: Code

INSERT INTO Usuarios(id,nombre,apellido,email,password,rol_usuario,telefono) VALUES(null,'Diego','Maradona','admin@mail.co','admin',2,3002900072)
INSERT INTO Usuarios(id,nombre,apellido,email,password,rol_usuario,telefono) VALUES(null,'Mishelle','Maradona','usuario@mail.co','usuario',1,3192868890)

INSERT INTO Proveedores(id,proveedor_nombre,email,password) VALUES(null,'Pan Sura','proveedor@mail.co','proveedor')
INSERT INTO Proveedores(id,proveedor_nombre,email,password) VALUES(null,'Zenu','nuevo@mail.co','nuevo')

INSERT INTO contact_info(id,telefono,direccion,ciudad,departamento,proveedor_id) VALUES(null,3117177947,'Calle 32 #32-18','San Vicente','Antioquia',1)
INSERT INTO contact_info(id,telefono,direccion,ciudad,departamento,proveedor_id) VALUES(null,3456345634,'Carrera 31','Medellin','Amazonas',2)

INSERT INTO Productos(id,nombre,descripcion,precio,existencias,proveedor_id) VALUES(null,'Papaya','Fruta de consumo diario',8000,12,1)
