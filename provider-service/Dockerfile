FROM amazoncorretto:17
EXPOSE 8086
COPY provider-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
