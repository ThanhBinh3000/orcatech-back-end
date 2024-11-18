FROM openjdk:22 AS build-stage
RUN mkdir /app
COPY target/registry-0.0.1-SNAPSHOT.jar /app/registry-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/registry-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761