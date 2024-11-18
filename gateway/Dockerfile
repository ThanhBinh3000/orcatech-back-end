FROM openjdk:22 AS build-stage
RUN mkdir /app
COPY target/gateway-0.0.1-SNAPSHOT.jar /app/gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/gateway-0.0.1-SNAPSHOT.jar"]
EXPOSE 8888