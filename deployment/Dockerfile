# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY backend/pom.xml ./pom.xml
COPY pom.xml ./root-pom.xml
COPY backend/src ./src
RUN mvn -f pom.xml clean package -DskipTests

# ---- Run stage ----
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/multi-utility-calculator.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
