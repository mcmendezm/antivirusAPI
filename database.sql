-- Seleccionar la base de datos 'antivirus'
USE antivirus;

-- Eliminar tablas si ya existen para evitar conflictos
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS bootcamps_tematicas;
DROP TABLE IF EXISTS institucion_bootcamps;
DROP TABLE IF EXISTS usuario_oportunidades;
DROP TABLE IF EXISTS oportunidad_institucion;
DROP TABLE IF EXISTS oportunidades;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS bootcamps;
DROP TABLE IF EXISTS tematicas;
DROP TABLE IF EXISTS instituciones;
DROP TABLE IF EXISTS categorias;
SET FOREIGN_KEY_CHECKS = 1;

-- Crear las tablas desde cero con las nuevas estructuras
CREATE TABLE categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);

CREATE TABLE instituciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    ubicacion TEXT,
    url_generalidades TEXT,
    url_oferta_academica TEXT,
    url_bienestar TEXT,
    url_admision TEXT
);

CREATE TABLE tematicas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo VARCHAR(255) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

CREATE TABLE oportunidades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    observaciones TEXT,
    tipo VARCHAR(50),
    descripcion TEXT,
    requisitos TEXT,
    guia TEXT,
    datos_adicionales TEXT,
    canales_atencion TEXT,
    encargado VARCHAR(255),
    modalidad VARCHAR(50),
    id_categoria INT,
    id_institucion INT,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (id_institucion) REFERENCES instituciones(id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE oportunidad_institucion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_oportunidad INT,
    id_institucion INT,
    FOREIGN KEY (id_oportunidad) REFERENCES oportunidades(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_institucion) REFERENCES instituciones(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE usuario_oportunidades (
    id_usuario INT,
    id_oportunidad INT,
    PRIMARY KEY (id_usuario, id_oportunidad),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_oportunidad) REFERENCES oportunidades(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE bootcamps (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    informacion TEXT,
    costos TEXT,
    id_institucion INT,
    FOREIGN KEY (id_institucion) REFERENCES instituciones(id) ON DELETE SET NULL ON UPDATE CASCADE
);

CREATE TABLE bootcamps_tematicas (
    id_bootcamps INT,
    id_tematicas INT,
    PRIMARY KEY (id_bootcamps, id_tematicas),
    FOREIGN KEY (id_bootcamps) REFERENCES bootcamps(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_tematicas) REFERENCES tematicas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE institucion_bootcamps (
    id_instituciones INT,
    id_bootcamps INT,
    PRIMARY KEY (id_instituciones, id_bootcamps),
    FOREIGN KEY (id_instituciones) REFERENCES instituciones(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_bootcamps) REFERENCES bootcamps(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Activa nuevamente la verificación de claves foráneas
SET FOREIGN_KEY_CHECKS = 1;

-- Insertar datos de ejemplo en la tabla categorias
INSERT INTO categorias (nombre, descripcion) VALUES
('Tecnología', 'Programas relacionados con la informática y la tecnología.'),
('Negocios', 'Formación en administración y gestión empresarial.'),
('Salud', 'Cursos relacionados con la salud y el bienestar.'),
('Ingeniería', 'Programas enfocados en diversas ramas de la ingeniería.'),
('Artes', 'Cursos sobre arte, música y diseño.'),
('Ciencias Sociales', 'Programas de sociología, psicología y humanidades.'),
('Derecho', 'Cursos y programas enfocados en leyes y regulación.'),
('Educación', 'Formación para docentes y pedagogía.'),
('Medio Ambiente', 'Cursos relacionados con sostenibilidad y ecología.'),
('Deportes', 'Formación y entrenamiento en diversas disciplinas deportivas.');

-- Insertar datos de ejemplo en la tabla instituciones
INSERT INTO instituciones (nombre, ubicacion, url_generalidades, url_oferta_academica, url_bienestar, url_admision) VALUES
('Institución Universitaria de Envigado', 'Envigado, Antioquia', 'https://www.iue.edu.co/', 'https://www.iue.edu.co/?page_id=3173', 'https://www.iue.edu.co/?page_id=5126', 'https://www.iue.edu.co/la-iue/guias-de-inscripcion/'),
('Politécnico Jaime Isaza Cadavid', 'Medellín, Antioquia', 'https://www.politecnicojic.edu.co/', 'https://www.politecnicojic.edu.co/profesionales/#oferta-academica=pregrados', 'https://www.politecnicojic.edu.co/presentacionbienestar', 'https://www.politecnicojic.edu.co/aspirantes'),
('Institución Universitaria Pascual Bravo', 'Medellín, Antioquia', 'https://pascualbravo.edu.co/', 'https://pascualbravo.edu.co/pregrados/', 'https://pascualbravo.edu.co/academico/bienestar', 'https://sicau.pascualbravo.edu.co/SICAU/Aspirante/Login.jsp'),
('Institución Universitaria Colegio Mayor de Antioquia', 'Medellín, Antioquia', 'https://www.colmayor.edu.co/', 'https://www.colmayor.edu.co/programas/', 'https://www.colmayor.edu.co/bienestar/', 'https://www.colmayor.edu.co/admisiones/contacto-para-admisiones/'),
('Tecnológico de Antioquia', 'Medellín, Antioquia', 'https://inscripcionestdea.com/', 'https://www.tdea.edu.co/index.php/bienestar', 'https://www.tdea.edu.co/index.php/bienetar/bienestar', 'https://www.tdea.edu.co/index.php/micrositios/aspirantes'),
('Universidad de Antioquia', 'Medellín, Antioquia', 'https://www.udea.edu.co/', 'https://www.udea.edu.co/wps/portal/udea/web/inicio/programas-academicos', 'https://www.udea.edu.co/wps/portal/udea/web/inicio/bienestar', 'https://www.udea.edu.co/wps/portal/udea/web/inicio/admisiones'),
('Universidad Nacional de Colombia - Sede Medellín', 'Medellín, Antioquia', 'https://www.medellin.unal.edu.co/', 'https://www.medellin.unal.edu.co/programas.html', 'https://www.medellin.unal.edu.co/bienestar-universitario.html', 'https://www.medellin.unal.edu.co/admisiones.html'),
('Universidad EAFIT', 'Medellín, Antioquia', 'https://www.eafit.edu.co/', 'https://www.eafit.edu.co/programas-academicos', 'https://www.eafit.edu.co/bienestar-universitario', 'https://www.eafit.edu.co/inscripciones-y-admisiones'),
('Universidad Pontificia Bolivariana', 'Medellín, Antioquia', 'https://www.upb.edu.co/', 'https://www.upb.edu.co/es/pregrados', 'https://www.upb.edu.co/es/bienestar', 'https://www.upb.edu.co/es/admisiones'),
('Corporación Universitaria Lasallista', 'Caldas, Antioquia', 'https://www.lasallista.edu.co/', 'https://www.lasallista.edu.co/programas', 'https://www.lasallista.edu.co/bienestar', 'https://www.lasallista.edu.co/admisiones');

-- Insertar datos de ejemplo en la tabla tematicas
INSERT INTO tematicas (nombre) VALUES
('Desarrollo Web'),
('Programación'),
('Big Data'),
('Ciberseguridad'),
('Machine Learning'),
('DevOps'),
('Realidad Aumentada'),
('Blockchain'),
('Inteligencia Artificial'),
('Robótica');

-- Insertar datos de ejemplo en la tabla usuarios
INSERT INTO usuarios (nombre, correo, contrasena, rol) VALUES
('Carlos Perez', 'carlos.perez@example.com', 'password123', 'user'),
('Maria Rodriguez', 'maria.rodriguez@example.com', 'password456', 'admin'),
('Juan Lopez', 'juan.lopez@example.com', 'password789', 'user'),
('Ana Martinez', 'ana.martinez@example.com', 'password101', 'user'),
('Luis Gomez', 'luis.gomez@example.com', 'password202', 'user'),
('Sofia Fernandez', 'sofia.fernandez@example.com', 'password303', 'guest'),
('Diego Torres', 'diego.torres@example.com', 'password404', 'user'),
('Laura Morales', 'laura.morales@example.com', 'password505', 'user'),
('Miguel Sanchez', 'miguel.sanchez@example.com', 'password606', 'admin'),
('Elena Herrera', 'elena.herrera@example.com', 'password707', 'guest');

-- Insertar datos de ejemplo en la tabla oportunidades
INSERT INTO oportunidades (nombre, observaciones, tipo, descripcion, requisitos, guia, datos_adicionales, canales_atencion, encargado, modalidad, id_categoria, id_institucion) VALUES
('Beca de Desarrollo Web', 'Dirigido a estudiantes de ingeniería', 'Beca', 'Curso intensivo de desarrollo web', 'Conocimientos básicos de HTML y CSS', 'Guía para aplicar', 'Incluye material de estudio', 'Online y presencial', 'Juan Perez', 'Presencial', 1, 1),
('Programa de Ciberseguridad', 'Orientado a profesionales', 'Curso', 'Formación en protección de sistemas', 'Experiencia en redes', 'Manual de inscripción', 'Certificación incluida', 'Online', 'Ana Lopez', 'Online', 2, 2),
('Bootcamp de Big Data', 'Para analistas de datos', 'Bootcamp', 'Curso intensivo sobre Big Data', 'Conocimientos en SQL', 'Guía de inicio', 'Acceso a herramientas', 'Presencial', 'Pedro Martinez', 'Presencial', 3, 3),
('Máster en Machine Learning', 'Para ingenieros de software', 'Máster', 'Programa avanzado de ML', 'Experiencia en Python', 'Guía de requisitos', 'Acceso a laboratorios virtuales', 'Online', 'Sofia Gomez', 'Online', 4, 4),
('Curso de Blockchain', 'Para interesados en criptomonedas', 'Curso', 'Introducción a la tecnología blockchain', 'Sin requisitos previos', 'Guía de inscripción', 'Acceso a simuladores', 'Presencial', 'Carlos Sanchez', 'Presencial', 5, 5);

-- Insertar datos de ejemplo en la tabla oportunidad_institucion
INSERT INTO oportunidad_institucion (id_oportunidad, id_institucion) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 1);

-- Insertar datos de ejemplo en la tabla usuario_oportunidades
INSERT INTO usuario_oportunidades (id_usuario, id_oportunidad) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 1),
(7, 2),
(8, 3),
(9, 4),
(10, 5);

-- Insertar datos de ejemplo en la tabla bootcamps
INSERT INTO bootcamps (nombre, descripcion, informacion, costos, id_institucion) VALUES
('Fullstack Development Bootcamp', 'Bootcamp intensivo de desarrollo web', 'Aprende a construir aplicaciones web desde cero', '500.00', 1),
('Data Science Bootcamp', 'Formación en análisis de datos y Big Data', 'Programa avanzado de análisis de datos', '800.00', 2),
('Cybersecurity Bootcamp', 'Protección de redes y sistemas', 'Curso especializado en ciberseguridad', '600.00', 3),
('Machine Learning Bootcamp', 'Aprendizaje automático con Python', 'Curso intensivo de machine learning', '700.00', 4),
('Blockchain Technology Bootcamp', 'Introducción a la blockchain y criptomonedas', 'Curso avanzado de blockchain', '900.00', 5);

-- Insertar datos de ejemplo en la tabla bootcamps_tematicas
INSERT INTO bootcamps_tematicas (id_bootcamps, id_tematicas) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 6),
(2, 7),
(3, 8),
(4, 9),
(5, 10);

-- Insertar datos de ejemplo en la tabla institucion_bootcamps
INSERT INTO institucion_bootcamps (id_instituciones, id_bootcamps) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 1);

