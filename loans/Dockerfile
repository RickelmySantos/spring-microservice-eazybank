FROM openjdk:21-jdk-slim

COPY target/loans-0.0.1-SNAPSHOT.jar /loans.jar

ENTRYPOINT ["java", "-jar", "/loans.jar"]
EXPOSE 8090