FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 8082
COPY --from=kidpass-build /app/user-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


