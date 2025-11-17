FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8083
COPY notification-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
