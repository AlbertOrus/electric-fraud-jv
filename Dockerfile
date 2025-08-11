FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY target/electric-fraud.jar /app/electric-fraud.jar

ENTRYPOINT ["java", "-jar","/app/electric-fraud.jar"]