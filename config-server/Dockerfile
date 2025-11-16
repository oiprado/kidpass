FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8888
COPY config-server/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
