# API REST - Foro Alura

# Índice

- [Descripción del proyecto](#Descripción-del-proyecto)
- [Estado del proyecto](#Estado-del-proyecto)
- [Acceso al proyecto](#Acceso-al-proyecto)
- [Tecnologías utilizadas](#Tecnologías-utilizadas)

# Descripción del proyecto

El presente proyecto es un aplicativo desarrollado con el fin de brindar un sistema de gestión de registros generados en un foro.

La API REST Foro Alura posee las siguientes funcionalidades:

- Endpoints para los metodos CRUD de la entidad Usuarios
- Endpoints para los metodos CRUD de la entidad Cursos
- Endpoints para los metodos CRUD de la entidad Topicos
- Endpoints para los metodos CRUD de la entidad Respuestas

# Estado del proyecto

El proyecto por el momento se encuentra finalizado, no obstante se tiene pensado agregarle otro tipo de funcionalidades en el futuro, tales como otro la implementación de medidas de seguridad para proteger la API REST.

# Acceso al proyecto

## Opción 1
- Clonar el repositorio desde la siguiente URL : `https://github.com/YinnerC30/challenge-one-foro-alura.git/`
- Importar proyecto en algun IDE (recomiendo IntelliJ)
- Crear la base de datos `db-foro-alura` (solo crearla, ya que las tablas y relaciones se crearan al ejecutar el proyecto)
- Configurar la conexión a la base de datos PostgreSQL de tu computadora (usuario, contraseña, puerto de escucha servidor) concuerden con los parametros de la cadena de conexión del presente proyecto
desde el archivo `application.properties`.
- Ejecutar aplicación desde la clase `ForoInicialApplication.java`.

## Opción 2
- Descargar el archivo `challenge-one-foro-alura.jar` haciendo clic [aquí](https://github.com/YinnerC30/challenge-hotel-alura/blob/main/out/artifacts/challenge_hotel_alura/challenge-hotel-alura.jar).
- Abrir una terminal en el direcotiro donde se descargo el anterior archivo
- Ejecutar el comando `java -jar challenge-one-foro-alura.jar`

Nota: Asegurate que la conexión a la base de datos PostgreSQL de tu computadora (usuario, contraseña, puerto de escucha servidor) concuerden con los parametros de la cadena de conexión del presente proyecto.

# Tecnologías utilizadas

- Java 17
- Spring Boot
- Base de datos PostgreSQL