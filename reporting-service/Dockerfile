FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8092
COPY reporting-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
