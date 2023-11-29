create table topicos (
    id serial primary key ,
    titulo varchar(100),
    mensaje varchar(500),
    fecha_creacion timestamp,
    status varchar(30),
    autor_id int,
    curso_id int,
    is_active boolean,
    foreign key (autor_id) references usuarios(id),
    foreign key (curso_id) references cursos(id)
);