-- SQLBook: Code

INSERT INTO Usuarios(id,nombre,apellido,email,password,telefono,codigo_rol) VALUES(null,'Diego','Manjarez','admin@mail.co','admin',3192868890,1)
INSERT INTO Usuarios(id,nombre,apellido,email,password,telefono,codigo_rol) VALUES(null,'Andres','Maradona','usuario@mail.co','usuario',3192868890,2)

INSERT INTO Proveedores(id,marca_nombre,proveedor_nombre,email,password,codigo_rol) VALUES(null,'Bimbo','Pan Sura','proveedor@mail.co','proveedor',2)

INSERT INTO contact_info(id,telefono,direccion,ciudad,departamento,usuario_id) VALUES(1,3117177947,'Calle 32 #32-18','San Vicente','Antioquia',1)

INSERT INTO Productos(id,nombre,descripcion,precio,existencias) VALUES(1,'Papaya','Fruta de consumo diario',8000,12)
