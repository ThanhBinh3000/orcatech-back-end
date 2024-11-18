FROM openjdk:22 AS build-stage
RUN mkdir /app
COPY target/config-0.0.1-SNAPSHOT.jar /app/config-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/config-0.0.1-SNAPSHOT.jar"]
EXPOSE 2302