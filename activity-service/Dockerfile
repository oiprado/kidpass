FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8084
COPY activity-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
