FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8091
COPY security-scanner-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
