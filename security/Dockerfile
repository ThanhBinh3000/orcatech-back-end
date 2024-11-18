FROM openjdk:22 AS build-stage
RUN mkdir /app
COPY target/security-0.0.1-SNAPSHOT.jar /app/security-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/security-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081