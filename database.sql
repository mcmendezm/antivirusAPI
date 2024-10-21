-- Seleccionar la base de datos 'antivirus'
USE antivirus;

-- Eliminar tablas si ya existen para evitar conflictos
DROP TABLE IF EXISTS bootcamps_tematicas;
DROP TABLE IF EXISTS institucion_bootcamps;
DROP TABLE IF EXISTS usuario_oportunidades;
DROP TABLE IF EXISTS oportunidades;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS bootcamps;
DROP TABLE IF EXISTS tematicas;
DROP TABLE IF EXISTS instituciones;
DROP TABLE IF EXISTS categorias;

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

CREATE TABLE usuario_oportunidades (
    id_usuario INT,
    id_oportunidad INT,
    PRIMARY KEY (id_usuario, id_oportunidad),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id_oportunidad) REFERENCES oportunidades(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE bootcamps (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion TEXT,
    informacion TEXT,
    id_institucion INT,
    id_tematicas INT,
    costos DECIMAL(10, 2),
    FOREIGN KEY (id_institucion) REFERENCES instituciones(id) ON DELETE SET NULL ON UPDATE CASCADE,
    FOREIGN KEY (id_tematicas) REFERENCES tematicas(id) ON DELETE SET NULL ON UPDATE CASCADE
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
