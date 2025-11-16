FROM amazoncorretto:17
WORKDIR /app
COPY user-service/target/*.jar app.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "app.jar"]
