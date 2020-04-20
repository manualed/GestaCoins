
CREATE TABLE IF NOT EXISTS empleado (idEmpleado numeric,tipoDocumento varchar(3), numeroDocumento varchar(50), primerNombre varchar(50), primerApellido varchar(50), email varchar(50), fechaIngreso date, fechaNacimiento date, fechaCreacion date AS CURRENT_TIMESTAMP);

CREATE TABLE IF NOT EXISTS bonificacion (id_bonificacion numeric, codigoBonificacion varchar(10), nombreBonificacion varchar(100), valorBonificacion numeric(10), tipoBonificacion numeric(1) );

CREATE TABLE IF NOT EXISTS transaccion (idTransaccion numeric, idEmpleado numeric, idBonificacion numeric, redimido boolean, fechaObtencion date, fechaRedencion date);

INSERT INTO empleado (id_empleado,tipo_documento, num_documento, primer_nombre, primer_apellido, fecha_ingreso, fecha_nacimiento, fecha_creacion, email) 
VALUES(99,	'CC',	'90847537',	'Andres',	'Diaz',	'andres.diaz@ceiba.com.co',	'03-02-2020',	'03-02-1989',	now(), 'manuel.@out.com'	);