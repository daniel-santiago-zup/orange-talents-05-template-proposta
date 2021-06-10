## Builder Image
FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /usr/src/app
COPY pom.xml .
RUN mvn dependency:resolve
RUN mvn dependency:resolve-plugins
COPY src ./src
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk11:alpine
COPY --from=builder /usr/src/app/target/proposta-microservice.jar /usr/app/app.jar
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]