# Stage 1: Build
FROM gradle:7.6.1-jdk17-alpine AS builder
WORKDIR /app
COPY . .
RUN ./gradlew build --no-daemon

# Stage 2: Run
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]  