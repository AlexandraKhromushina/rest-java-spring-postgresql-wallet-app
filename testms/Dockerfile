FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/testms-app.jar testms-app.jar
ENTRYPOINT ["java", "-jar", "wallet-app.jar"]