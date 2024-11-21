# Use a base image with Java
FROM openjdk:17-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download the project dependencies
RUN ./mvnw dependency:go-offline

# Copy the entire source code
COPY src ./src

# Package the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Start a new stage to keep the image smaller
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR from the build stage
COPY --from=build /app/target/application-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
