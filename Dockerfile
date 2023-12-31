FROM maven:3.8.4-openjdk-17 AS builder

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src src

RUN mvn package -DskipTests

FROM meddream/jdk17:latest

WORKDIR /app

COPY --from=builder /app/target/springaidemo-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "springaidemo-0.0.1-SNAPSHOT.jar"]