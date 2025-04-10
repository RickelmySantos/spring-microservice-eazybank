FROM openjdk:21-jdk-slim

COPY target/cards-0.0.1-SNAPSHOT.jar /app/cards.jar

ENTRYPOINT ["java", "-jar", "/app/cards.jar"]
EXPOSE 9000