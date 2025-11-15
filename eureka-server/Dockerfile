FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 8761
COPY --from=kidpass-build /app/eureka-server/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
