# Franquicias

Aplicación en la cual se puede gestionar una franquicias y sucursales para todo tipo de negocio.

## Requisitos Previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) o superior
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

## Clonar el Repositorio

Clona el repositorio en tu máquina local usando git:

```bash
git clone https://github.com/cristiancano88/tienda.git
cd tienda
```

## Configuración de PostgreSQL

### Queries para la creacion de la base de datos

- **Crea una base de datos en PostgreSQL para la aplicación:**

  ```sql
    CREATE DATABASE tienda;
  ```

- **Crear tablas:**

  ```sql
    CREATE TABLE franquicia (
        id SERIAL PRIMARY KEY,
        nombre VARCHAR(100) NOT NULL
    );

    CREATE TABLE sucursal (
        id SERIAL PRIMARY KEY,
        nombre VARCHAR(100) NOT NULL,
        franquicia_id INT NOT NULL,
        FOREIGN KEY (franquicia_id) REFERENCES franquicia(id) ON DELETE CASCADE
    );

    CREATE TABLE producto (
        id SERIAL PRIMARY KEY,
        nombre VARCHAR(100) NOT NULL,
        cantidad_stock INT NOT NULL CHECK (cantidad_stock >= 0),
        sucursal_id INT NOT NULL,
        FOREIGN KEY (sucursal_id) REFERENCES sucursal(id) ON DELETE CASCADE
    );
  ```

- **Actualiza el archivo application.properties en src/main/resources con tus credenciales de base de datos:**
  ```properties
  spring.r2dbc.url=jdbc:postgresql://localhost:5432/nombre_de_la_base_de_datos
  spring.r2dbc.username=tu_usuario
  spring.r2dbc.password=tu_contraseña
  ```

## Compilar y Ejecutar la Aplicación

Usando Maven, puedes compilar y ejecutar la aplicación con los siguientes comandos:

```bash
mvn clean install
mvn spring-boot:run
```

## Acceder a la Aplicación

Una vez que la aplicación esté en funcionamiento, podrás acceder a ella en tu navegador a través de:

```web
http://localhost:8080
```

## API Endpoints

Aquí hay una lista de los principales endpoints disponibles en la aplicación:

- **POST /franquicias:** Agregar una nueva franquicia.
- **POST /franquicias/{franquiciaId}/sucursales:** Agregar una nueva sucursal a una franquicia.
- **POST /productos/{sucursalId}:** Agregar un nuevo producto a una sucursal.
- **DEL /productos/{productoId}:** Eliminar un producto a una sucursal.
- **PUT /productos/{productoId}/stock?nuevoStock=30:** Modificar el stock de un producto.
- **GET /productos/{franquiciaId}/productos-mayor-stock:** Mostrar cual es el producto que más stock tiene por sucursal para una franquicia puntual.
- **PUT /franquicias/{franquiciaId}/nombre?nuevoNombre=FranquiciaB:** Actualizar el nombre de una franquicia.
- **PUT /sucursales/{sucursalId}/nombre?nuevoNombre=SucursalB:** Actualizar el nombre de una sucursal.
- **PUT /productos/{productoId}/nombre?nuevoNombre=ProductoB:** Actualizar el nombre de una producto.

## Aprovisionamiento de la Base de Datos con Terraform

Este proyecto incluye configuración de infraestructura como código usando Terraform para desplegar una instancia de PostgreSQL en AWS RDS.

### Pasos para Desplegar la Base de Datos

1. **Configura las Credenciales de AWS**: Asegúrate de tener configuradas tus credenciales de AWS en el entorno.

## Desplegar la Base de Datos con Terraform

1. **Navegar a la Carpeta de Terraform**:

   ```bash
   cd infrastructure/terraform
   ```

2. **Inicializa Terraform**:

   ```bash
   terraform init
   ```

3. **Aplica la Configuración de Terraform**:

   ```bash
   terraform apply
   ```

4. **Actualizar la Configuración de Spring Boot**: Actualiza _application.properties_ con el endpoint y las credenciales proporcionadas en _terraform.tfvars_.

## Desplegar con Docker

### Construir la imagen

Ejecuta el siguiente comando en la raíz del proyecto para construir la imagen de Docker:

```bash
docker build -t tienda .
```

### Ejecutar la aplicación en Docker

Para ejecutar la aplicación en Docker, usa:

```bash
docker run -p 8080:8080 tienda
```

### Acceder a la Aplicación

La aplicación estará disponible en:

```web
http://localhost:8080
```
