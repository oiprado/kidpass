FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY api-gateway/pom.xml ./api-gateway/
COPY auth-service/pom.xml ./auth-service/
COPY user-service/pom.xml ./user-service/
COPY eureka-server/pom.xml ./eureka-server/
COPY config-server/pom.xml ./config-server/
COPY activity-service/pom.xml ./activity-service/
COPY booking-service/pom.xml ./booking-service/
COPY student-service/pom.xml ./student-service/
COPY notification-service/pom.xml ./notification-service/
COPY authorization-service/pom.xml ./authorization-service/
COPY security-scanner-service/pom.xml ./security-scanner-service/
COPY reporting-service/pom.xml ./reporting-service/
COPY profile-service/pom.xml ./profile-service/
COPY provider-service/pom.xml ./provider-service/
COPY qr-service/pom.xml ./qr-service/

COPY api-gateway/src ./api-gateway/src
COPY auth-service/src ./auth-service/src
COPY user-service/src ./user-service/src
COPY eureka-server/src ./eureka-server/src
COPY config-server/src ./config-server/src
COPY activity-service/src ./activity-service/src
COPY booking-service/src ./booking-service/src
COPY student-service/src ./student-service/src
COPY notification-service/src ./notification-service/src
COPY authorization-service/src ./authorization-service/src
COPY security-scanner-service/src ./security-scanner-service/src
COPY reporting-service/src ./reporting-service/src
COPY profile-service/src ./profile-service/src
COPY provider-service/src ./provider-service/src
COPY qr-service/src ./qr-service/src

RUN mvn clean install -DskipTests && find . -name "*.jar.original" -delete