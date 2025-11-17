FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8089
COPY authorization-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
