# 1. Build
FROM gradle:7.6.0-jdk17-alpine AS builder

USER root
RUN chown -R gradle:gradle /home/gradle  
COPY . /app
WORKDIR /app

USER gradle                               
RUN gradle build --no-daemon

# 2. Run
FROM eclipse-temurin:17.0.10_7-jre-alpine
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
