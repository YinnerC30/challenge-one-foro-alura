create table respuestas (
    id serial primary key ,
    mensaje varchar(500),
    topico_id int,
    fechaCreacion timestamp,
    autor_id int,
    is_solved boolean,
    is_active boolean,
    foreign key (topico_id) references topicos(id),
    foreign key (autor_id) references usuarios(id)
);