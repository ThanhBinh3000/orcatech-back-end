FROM openjdk:22 AS build-stage
RUN mkdir /app
COPY target/categories-0.0.1-SNAPSHOT.jar /app/categories-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/categories-0.0.1-SNAPSHOT.jar"]
EXPOSE 8084