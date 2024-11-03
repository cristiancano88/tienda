# Etapa 1: Construir la aplicación
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY pom.xml .
COPY src ./src

# Compila la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia el archivo JAR compilado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto en el que la aplicación escucha
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]