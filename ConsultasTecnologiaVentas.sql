SELECT * FROM Usuarios;

SELECT * FROM proveedores;

SELECT * FROM contact_info;


##Consultar informacion relacionados con ID
select p.proveedor_nombre, ph.telefono from proveedores p inner join contact_info ph on p.id = ph.usuario_id;