FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8090
COPY qr-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


