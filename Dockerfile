FROM openjdk:8u212-jdk-slim
VOLUME /tmp
EXPOSE 8080
# The application's jar file (when packaged)
ARG JAR_FILE=target/todo-web-service-0.0.1-SNAPSHOT.jar
# Add the application's jar to the container
ADD ${JAR_FILE} todo-web-service.jar
# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/todo-web-service.jar"]