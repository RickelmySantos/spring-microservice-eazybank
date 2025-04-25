# FROM openjdk:21-jdk-slim

# COPY target/accounts-0.0.1-SNAPSHOT.jar /app/accounts.jar

# ENTRYPOINT ["java", "-jar", "/app/accounts.jar"]
# EXPOSE 8080 
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

ENV TZ=UTC \
    LANG=en_US.UTF-8 \
    LANGUAGE=en_US:en \
    LC_ALL=en_US.UTF-8

COPY --from=builder /app/target/accounts-0.0.1-SNAPSHOT.jar /accounts.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/accounts.jar"]
