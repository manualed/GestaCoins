
create table empleado (idEmpleado numeric,tipoDocumento varchar(3), numeroDocumento varchar(100), primerNombre varchar(50), primerApellido varchar(50), email varchar(100), fechaIngreso date, fechaNacimiento date, fechaCreacion date);

create table bonificacion (id_bonificacion numeric, codigoBonificacion varchar(100), nombreBonificacion varchar(100), valorBonificacion numeric(10), tipoBonificacion numeric(1) );

create table transaccion (idEmpleado numeric, idBonificacion numeric, redimido boolean, fechaObtencion date, fechaRedencion date);



