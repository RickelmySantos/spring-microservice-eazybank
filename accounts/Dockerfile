FROM openjdk:17-jdk-alpine

COPY target/accounts-0.0.1-SNAPSHOT.jar /app/accounts.jar

ENTRYPOINT ["java", "-jar", "/app/accounts.jar"]
EXPOSE 8080 