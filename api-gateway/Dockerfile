FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 8080
COPY --from=kidpass-build /app/api-gateway/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
