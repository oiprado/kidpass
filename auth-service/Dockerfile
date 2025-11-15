FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 8081
COPY --from=kidpass-build /app/auth-service/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
