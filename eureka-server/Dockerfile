FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8761
COPY eureka-server/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

