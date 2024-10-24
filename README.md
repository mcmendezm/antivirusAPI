# Proyecto Spring Boot: API para Gestión de Oportunidades y Bootcamps

Este proyecto es una API desarrollada con **Spring Boot**, **Java**, y **JPA**, que permite gestionar oportunidades, instituciones, bootcamps, y la relación entre ellos. Utiliza **MySQL** como base de datos, y la documentación de la API se genera con **SpringDoc OpenAPI**.

## Tabla de Contenidos
1. [Requisitos](#requisitos)
2. [Instalación](#instalación)
3. [Estructura del Proyecto](#estructura-del-proyecto)
4. [Configuración de la Base de Datos](#configuración-de-la-base-de-datos)
5. [Ejecución del Proyecto](#ejecución-del-proyecto)
6. [Uso de la API](#uso-de-la-api)
7. [Documentación de la API](#documentación-de-la-api)
8. [Script SQL](#script-sql)

## Requisitos

- **Java 17 o superior**
- **Maven 3.6+**
- **MySQL 8.0+**
- **IntelliJ IDEA** u otro IDE de tu preferencia.

## Instalación

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/tu_usuario/tu_proyecto.git
    cd tu_proyecto
    ```

2. Asegúrate de tener configurada la base de datos MySQL y crea una base de datos llamada `antivirus`:
    ```sql
    CREATE DATABASE antivirus;
    ```

3. Configura las credenciales de tu base de datos en el archivo `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/antivirus
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

## Estructura del Proyecto

La estructura del proyecto es la siguiente:

```
/ruta/de/tu/proyecto/
│
├── src/
│   ├── main/
│   │   ├── java/com/ejemplo/antivirusAPI/
│   │   │   ├── controller/  # Controladores de la API
│   │   │   ├── model/       # Modelos de entidades JPA
│   │   │   ├── repository/  # Repositorios JPA
│   │   │   └── service/     # Servicios que implementan la lógica de negocio
│   │   └── resources/
│   │       ├── application.properties  # Configuración de la base de datos y otros parámetros
│   └── test/  # Pruebas unitarias
│
├── pom.xml  # Archivo de configuración de Maven
├── README.md  # Instrucciones del proyecto (este archivo)
├── script.sql  # Script para crear y poblar la base de datos
└── .gitignore  # Archivos y carpetas a ignorar en Git
```

## Configuración de la Base de Datos

1. En el archivo `script.sql`, se encuentran todas las sentencias SQL para crear y poblar las tablas necesarias en la base de datos `antivirus`.

2. Ejecuta el `script.sql` en tu gestor de base de datos (por ejemplo, MySQL Workbench o desde la terminal):
    ```sql
    SOURCE /ruta/de/tu/proyecto/script.sql;
    ```

## Ejecución del Proyecto

Para ejecutar la aplicación, sigue estos pasos:

1. Navega a la carpeta del proyecto y compila el proyecto con Maven:
    ```bash
    mvn clean install
    ```

2. Inicia la aplicación Spring Boot:
    ```bash
    mvn spring-boot:run
    ```

3. La API estará disponible en `http://localhost:8080`.

## Uso de la API

Las principales rutas de la API son las siguientes:

- **Instituciones**: CRUD para gestionar instituciones educativas.
    - `GET /api/instituciones`: Obtiene la lista de instituciones.
    - `POST /api/instituciones`: Crea una nueva institución.
    - `PUT /api/instituciones/{id}`: Actualiza una institución.
    - `DELETE /api/instituciones/{id}`: Elimina una institución.

- **Oportunidades**: CRUD para gestionar oportunidades de estudio.
    - `GET /api/oportunidades`: Obtiene la lista de oportunidades.
    - `POST /api/oportunidades`: Crea una nueva oportunidad.
    - `PUT /api/oportunidades/{id}`: Actualiza una oportunidad.
    - `DELETE /api/oportunidades/{id}`: Elimina una oportunidad.

- **Bootcamps**: CRUD para gestionar bootcamps.
    - `GET /api/bootcamps`: Obtiene la lista de bootcamps.
    - `POST /api/bootcamps`: Crea un nuevo bootcamp.
    - `PUT /api/bootcamps/{id}`: Actualiza un bootcamp.
    - `DELETE /api/bootcamps/{id}`: Elimina un bootcamp.

## Documentación de la API

La documentación de la API se genera automáticamente con **SpringDoc OpenAPI**. Para acceder a la interfaz de Swagger, abre tu navegador y dirígete a:
```
http://localhost:8080/swagger-ui/index.html
```

## Script SQL

El archivo `script.sql` incluye las sentencias para crear y poblar las tablas necesarias para el funcionamiento de la API:

- **Tablas**: Creación de tablas como `instituciones`, `oportunidades`, `bootcamps`, `categorias`, `tematicas`, y tablas de relación.
- **Población de datos**: Inserciones de datos de prueba para cada una de las tablas.

Asegúrate de ejecutar el `script.sql` antes de iniciar la aplicación para que la base de datos esté correctamente configurada.
