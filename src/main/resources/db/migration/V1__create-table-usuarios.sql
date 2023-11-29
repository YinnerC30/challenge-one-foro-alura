CREATE TABLE usuarios
(
    id         SERIAL PRIMARY KEY,
    nombre     VARCHAR(30),
    email      VARCHAR(30),
    contrasena VARCHAR(20),
    is_active  BOOLEAN DEFAULT FALSE
);