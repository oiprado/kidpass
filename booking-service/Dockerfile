FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8085
COPY booking-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
