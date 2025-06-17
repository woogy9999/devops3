# 1. Build
FROM gradle:7.6.0-jdk17-alpine AS builder
COPY . /app
WORKDIR /app
RUN gradle build --no-daemon

# 2. Run
FROM eclipse-temurin:17.0.10_7-jre-alpine
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]
