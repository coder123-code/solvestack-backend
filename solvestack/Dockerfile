# Build stage
FROM maven:3.9.0-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copy pom.xml from solvestack folder
COPY solvestack/pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code from solvestack folder
COPY solvestack/src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copy the JAR from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
