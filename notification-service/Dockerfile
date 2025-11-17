FROM amazoncorretto:17
VOLUME /tmp
EXPOSE 8088
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
