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
    costos DECIMAL(10, 2),
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

INSERT INTO categorias (nombre, descripcion) VALUES
('Oportunidades socioeconómicas', 'Descripción de la categoría Oportunidades socioeconómicas'),
('Oportunidades formativas', 'Descripción de la categoría Oportunidades formativas');


INSERT INTO instituciones (nombre, ubicacion, url_generalidades, url_oferta_academica, url_bienestar, url_admision) VALUES
('IU de Envigado', 'SUR. Cra 27 B # 39 A Sur 57 - Envigado', 'https://www.iue.edu.co/admisiones.html/', 'https://www.iue.edu.co/?oferta-academica=pregrado
11 Profesionales, 1 tecnología, y 1 técnica.', 'https://www.iue.edu.co/?page_id=5126', 'https://www.iue.edu.co/la-iue/guias-de-inscripcion-y-matricula.'),
('Politécnico Jaime Isaza Cadavid', 'SUR. Cra  48 #7-151 Poblado-Medellín', 'https://www.politecnicojic.edu.co/', 'https://www.politecnicojic.edu.co/profesionales
https://www.politecnicojic.edu.co/tecnicos


2 tecnicas, 19 tecnologias y 13 profesionales


', 'https://www.politecnicojic.edu.co/presentacion-bienestar-institucional', 'https://www.politecnicojic.edu.co/aspirantes'),
('IU Pascual Bravo', 'NOROCCIDENTAL.Sede Robledo-Medellín
Calle 73 # 73A – 226.', 'https://pascualbravo.edu.co/', 'https://pascualbravo.edu.co/pregrados/
10 carreras profesionales y 12 tecnologías', 'https://pascualbravo.edu.co/academico/bienestar-universitario/bienestarparalafelicidad/', 'https://sicau.pascualbravo.edu.co/SICAU/Aspirante/Aspirante/InstruccionesDeInicioDeInscripcion'),
('Colegio Mayor de Antioquia', 'NOROCCIDENTAL.Calle 65#77-126 Robledo - Medellín ', 'https://www.colmayor.edu.co/', 'https://www.colmayor.edu.co/programas/', 'https://www.colmayor.edu.co/bienestar/', 'https://www.colmayor.edu.co/admisiones/contactenos/'),
('Tecnológico de Antioquia', 'NOROCCIDENTAL. CALLE 78B NO. 72A - 220 MEDELLÍN', 'https://tdea.edu.co/', 'https://inscripcionestdea.com/', 'https://www.tdea.edu.co/index.php/bienetar/bienvenido-a-vida-universitaria', 'https://www.tdea.edu.co/index.php/micrositios/admisiones-y-registro'),
('ITM', 'NOROCCIDENTAL. SEDE PRINCIPAL Carrera 76A # 32A73 Robledo', 'https://www.itm.edu.co/', 'https://www.itm.edu.co/aspirante-pregrado/programas-profesionales/. Tecnologías (16): https://www.itm.edu.co/aspirante-pregrado/tecnologias/', 'https://www.itm.edu.co/bienestar/', 'https://www.itm.edu.co/admisiones/'),
('ESA Débora Arango', 'SUR . CALLE 39 SUR 39-8 Envigado, Antioquia', 'https://www.deboraarango.edu.co/inicio/', 'https://www.deboraarango.edu.co/inicio/decanaturas/', 'https://www.deboraarango.edu.co/inicio/dependencias/bienestar/', 'https://www.deboraarango.edu.co/inicio/admisiones/'),
('Universidad Nacional Abierta y a Distancia', 'CENTRO ORIENTAL. SEDE MEDELLÍN:Carrera 45 # 55-19', 'https://universidadesvirtuales.co/universidad-nacional-abierta-y-a-distancia/sede-medellin.html', 'https://universidadesvirtuales.co/universidad-nacional-abierta-y-a-distancia.html#carreras', 'https://visae.unad.edu.co/bienestar', 'https://estudios.unad.edu.co/inscripciones-y-matriculas'),
('Universidad de Antioquia', 'NORORIENTE. Cuidad Universitaria Calle 57 #53 -108. Facultad de Medicina Cra. 51d #62-29 NOROCCIDENTE. Cuidadela Robledo Carrera 74A # 93-30', 'https://www.udea.edu.co/wps/portal/udea/web/inicio', 'https://www.udea.edu.co/wps/portal/udea/web/inicio/estudiar-udea/quiero-estudiar-udea/pregrado/oferta-medellin', 'https://www.udea.edu.co/wps/portal/udea/web/inicio/bienestar', 'https://www.udea.edu.co/wps/portal/udea/web/inicio/estudiar-udea/quiero-estudiar-udea/pregrado/calendario-guias-admision'),
('Universidad Nacional (sede Medellín)', 'NOROCCIDENTAL. Sede Medellín (principal) Cra. 65 # 59A - 110          Campus del rio Cra. 64c #63-120           Campus de Robledo Cl. 75 #79A-51      Facultad de Minas Av. 80 #65 - 223', 'https://medellin.unal.edu.co/', 'http://www.pregrado.unal.edu.co/programas-acred/ ', 'https://bienestaruniversitario.medellin.unal.edu.co/', 'https://admisiones.unal.edu.co/pregrado/'),
('Universidad de Medellín', 'SUROCCIDENTAL .
Carrera 87 N° 30 – 65, Belén las violetas, Medellín.', 'https://udemedellin.edu.co/', 'https://facultades.udemedellin.edu.co/
-27 Profesionales', 'https://bienestaruniversitario.udemedellin.edu.co/#gsc.tab=0', 'https://admisiones.udemedellin.edu.co/pregrado/inscripcion-pregrado/'),
('Universidad Santo Tomás', 'NOROCCIDENTAL. Cra. 82 #77BB-27, Medellín, Robledo.', 'https://ustamed.edu.co/', 'https://ofertaacademica.ustamed.edu.co/#pregrados

 -7 técnicas, 3 profesionales, 4 especializaciones, 4 maestrías


', 'https://ustamed.edu.co/bienestar/', 'http://oas.usta.edu.co:8080/sgacampus/services/inscripciones/home'),
('Universidad EAFIT', 'SURORIENTAL.  Carrera 49 N° 7 Sur - 50, Medellín.', 'https://www.eafit.edu.co/', 'https://www.eafit.edu.co/pregrados
-25 Pregrados y 80 posgrados.', 'https://www.eafit.edu.co/bienestar', 'https://www.eafit.edu.co/admisiones/tramites-y-servicios/Paginas/guia-aspirantes-pregrado.aspx'),
('Universidad CES ', 'SURORIENTAL. Sede principal: El Poblado
Calle 10A #22-04.', 'https://www.ces.edu.co/', 'https://www.ces.edu.co/programas/carreras/?order=ASC

- 14 profesionales, 3 tecnologías.', 'https://www.ces.edu.co/bienestar-institucional-y-desarrollo-humano/', 'https://www.ces.edu.co/inscripciones-y-matriculas/proceso-de-inscripcion/'),
('Universidad Pontificia Bolivariana', 'CENTRO OCCIDENTAL.  Circ 1 70-1, Medellín', 'https://www.upb.edu.co/es/home', 'https://www.upb.edu.co/es/pregrados
-41 profesionales.
', 'https://www.upb.edu.co/es/proyeccion-social/bienestar', 'https://www.upb.edu.co/es/inscripciones-abiertas'),
('Universidad Catolica Luis Amigo ', 'CENTRO OCCIDENTAL Transversal 51A #67B 90', 'https://www.funlam.edu.co/', 'https://www.funlam.edu.co/modules/ofertaacademica/category.php?categoryid=3 ', 'https://www.funlam.edu.co/modules/bienestaruniversitario/ ', 'https://www.funlam.edu.co/modules/registroacademico/category.php?categoryid=1'),
('Corporación Universitaria Americana', 'CENTRO Calle 50 # 43-65', 'https://americana.edu.co/medellin/', 'https://americana.edu.co/medellin/?page_id=6127

Pregrado virtual:
https://americana.edu.co/medellin/?page_id=7674

', 'https://americana.edu.co/medellin/?page_id=6149

', 'https://americana.edu.co/medellin/?page_id=97165'),
('Universidad EIA', 'SUR  Vereda. El Peñasco, Envigado, Antioquia', 'https://www.eia.edu.co/', 'https://www.eia.edu.co/pregrado/

', 'https://www.eia.edu.co/vida-en-la-eia/ ', 'https://www.eia.edu.co/inscripcion-pregrado/'),
('Politécnico Grancolombiano', 'CENTRO OCCIDENTAL.  Carrera 74 # 52 – 20 los colores.', 'https://www.poli.edu.co/', 'https://www.poli.edu.co/landing/pregrado/presencial/medellin?utm_source=ADS&utm_source=adwords&utm_medium=CPC&utm_medium=ppc&utm_campaign=1361027016&utm_campaign=Pre_Pres_Profe_Derecho_Esp_ADS_Pr_Med_Lead_X&utm_content=339375868225&utm_term=&utm_term=&hsa_acc=9012729727&hsa_cam=1361027016&hsa_grp=67431303599&hsa_ad=339375868225&hsa_src=g&hsa_tgt=dsa-1094878875834&hsa_kw=&hsa_mt=&hsa_net=adwords&hsa_ver=3&gad_source=1&gclid=Cj0KCQjwv7O0BhDwARIsAC0sjWO9-FGfPONXxyqf-nYGc_CzpG443-hCwYDeYAJH2cqsXJ4R4S9JVecaAtS3EALw_wcB', 'https://www.poli.edu.co/bienestar', 'https://www.poli.edu.co/content/proceso-de-admision'),
('Servicio Nacional de Aprendizaje', 'CENTRO  Cl. 51 #56A-22, La Candelaria, Medellín', 'https://oferta.senasofiaplus.edu.co/sofia-oferta/inicio-sofia-plus.html', 'https://www.sena.edu.co/es-co/formacion/Paginas/Estudie-en-el-SENA.aspx', 'https://www.sena.edu.co/es-co/comunidades/aprendices/Paginas/bienestarAprendiz.aspx', 'https://senaofertaeducativa.co/'),
('Universidad de San Buenaventura', 'CENTRO ORIENTAL. Medellín, San benito, carrera 56C #51-110', 'https://www.usbmed.edu.co/', 'https://www.usbmed.edu.co/Aspirantes
', 'https://www.usbmed.edu.co/Bienestar-Institucional', 'https://www.usbbog.edu.co/admisiones/proceso-de-inscripcion/'),
('Uniminuto', 'Cl. 45, La Gabriela, Bello, Antioquia', 'https://www.uniminuto.edu/', 'https://www.uniminuto.edu/oferta-academica', 'NULL', 'https://www.uniminuto.edu/matriculate'),
('CESDE', 'Carrera 42 #48-20 Edificio Cesde, Medellín, Antioquia', 'https://www.cesde.edu.co/', 'https://www.cesde.edu.co/programas/ ', ' https://www.cesde.edu.co/bienestar/ ', 'https://www.cesde.edu.co/aspirantes/'),
('Unidigital', 'Cra 55 # 42 90 INT 0101
Centro Cívico Plaza de la Libertad
Medellín, Antioquia', 'https://www.iudigital.edu.co/', ' https://www.iudigital.edu.co/index.php/nuestra-oferta ', ' https://www.iudigital.edu.co/index.php/direccion-de-bienestar ', 'https://www.iudigital.edu.co/index.php/aspirante'),
('Ceipa', 'Cl. 77 Sur #40 - 165, Sabaneta, Antioquia', 'https://ceipa.edu.co/', ' https://ceipa.edu.co/carreras-profesionales/ ', ' https://ceipa.edu.co/bien-ser/ ', 'https://ceipa.edu.co/estudiantes/proceso-de-matriculas/'),
('Institución universitaria Esumer', 'Cl. 76 #80-126, Villa Flora, Medellín, Robledo,  Antioquia', 'https://esumer.edu.co/', ' https://esumer.edu.co/programasacademicos/ ', 'https://esumer.edu.co/bienestar_institucional/ ', 'https://esumer.edu.co/procesodeinscripcion/'),
('Universidad Autónoma Latinoamericana', 'Carrera 55 N° 49-51. Medellín-Colombia-Suramérica.', 'https://www.unaula.edu.co/', 'https://www.unaula.edu.co/pregrado ', 'https://www.unaula.edu.co/bienestar/inicio ', 'https://www.unaula.edu.co/admisiones'),
('Corporación Universitaria Adventista', 'Cra. 84, Cl. 33AA #01, Medellín, Antioquia', 'https://www.unac.edu.co/', 'https://www.unac.edu.co/pregrado/ ', 'https://www.unac.edu.co/bienestar/ ', 'https://www.unac.edu.co/admisiones-pregrado/'),
('Unilasallista Corporación Universitaria', ' Carrera 51 # 118 Sur – 57 (Caldas, Antioquia, Colombia)  ', 'https://www.unilasallista.edu.co/', 'https://www.unilasallista.edu.co/pregrados_/ ', ' https://www.unilasallista.edu.co/comunidad/bienestar/ ', 'https://www.unilasallista.edu.co/admisiones-y-becas/'),
('Open Bootcamp', 'falta informacion', 'https://open-bootcamp.com/', 'falta informacion', 'falta informacion', 'falta informacion'),
('MinTic', 'falta informacion', 'https://cursoscortossenatec.co/', 'falta informacion', 'falta informacion', 'falta informacion'),
('Oracle', 'falta informacion', 'https://www.oracle.com/lad/education/oracle-next-education/', 'falta informacion', 'falta informacion', 'falta informacion'),
('Pragma', 'falta informacion', 'https://www.pragma.co/es/carrera/plan-carrera/bootcamp-power-up-fullstack?utm_campa[…]ocial&utm_term=Video_Lanzamiento_Bootcamp&utm_content=Linkedin', 'falta informacion', 'falta informacion', 'falta informacion'),
('Avanzatec', 'falta informacion', 'https://www.avanzatec.gov.co/720/w3-article-276665.html', 'falta informacion', 'falta informacion', 'falta informacion'),
('Avanzatech', 'falta informacion', 'https://www.avanzatech.co/?utm_source=Google&utm_medium=cpc&utm_campaign=SEM_Curso_desarrollo&utm_term=AdG_Cursos&utm_content=Ad_Dinamico-2&gclid=Cj0KCQjws560BhCuARIsAHMqE0HN_12NN9x5RnwhMiFyk94wZ1tKo24E99sUy_IFa0Eh3AICXAGLO94aAk4oEALw_wcB', 'falta informacion', 'falta informacion', 'falta informacion'),
('Bootcamps Institute', 'falta informacion', 'https://www.bootcamp-institute.co/', 'falta informacion', 'falta informacion', 'falta informacion'),
('Educación IT', 'falta informacion', 'https://www.educacionit.com/bootcamp-full-stack', 'falta informacion', 'falta informacion', 'falta informacion'),
('Crack the Code', 'falta informacion', 'https://www.crackthecode.la/', 'falta informacion', 'falta informacion', 'falta informacion'),
('Digital House', 'falta informacion', 'https://www.digitalhouse.com/co/productos/programacion/certified-tech-developer?utm_sou[…]iyuNeVRFq07d2h1a4ypTHGZnJVgM_Dow04YYbFqwN0xy8aAtUxEALw_wcB', 'falta informacion', 'falta informacion', 'falta informacion'),
('Keep coding', 'falta informacion', 'https://keepcoding.io/nuestros-bootcamps/', 'falta informacion', 'falta informacion', 'falta informacion'),
('FreeCodeCamp', 'falta informacion', 'https://www.freecodecamp.org/', 'falta informacion', 'falta informacion', 'falta informacion');


INSERT INTO tematicas (id, nombre) VALUES
(1, 'Desarrollo web'),
(2, 'Programación (Front-End, Back-End, Fullstack)'),
(3, 'Lenguajes de programación'),
(4, 'Análisis de datos'),
(5, 'Ciberseguridad'),
(6, 'Testin en calidad de software'),
(7, 'Blockchain'),
(8, 'Arquitectura en la nube'),
(9, 'Internet de las cosas'),
(10, 'Realidad Virtual y aumentada'),
(11, 'Gestión de proyectos (Digitales)');

