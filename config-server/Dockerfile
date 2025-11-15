FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 8888
COPY --from=kidpass-build /app/config-server/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
