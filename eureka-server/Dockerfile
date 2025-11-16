FROM amazoncorretto:17
VOLUME /app
EXPOSE 8761
COPY eureka-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

