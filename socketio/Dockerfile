FROM openjdk:22 AS build-stage
RUN mkdir /app
COPY target/socketio-0.0.1-SNAPSHOT.jar /app/socketio-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/socketio-0.0.1-SNAPSHOT.jar"]
EXPOSE 8082