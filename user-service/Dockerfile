FROM openjdk:11-jre-slim
WORKDIR /app
COPY user-service/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

