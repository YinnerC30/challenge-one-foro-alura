create table cursos (
    id serial primary key,
    nombre varchar(30),
    categoria varchar(30),
    is_active boolean default false
);