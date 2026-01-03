FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy JAR explicitly
COPY --from=build /app/target/*.jar app.jar

# Create user and give permission
RUN useradd -m appuser && chown appuser:appuser /app/app.jar

USER appuser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
