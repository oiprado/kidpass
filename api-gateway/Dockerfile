FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 9090
COPY api-gateway/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
