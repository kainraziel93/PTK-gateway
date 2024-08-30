FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/gateway*.jar /app/gateway.jar
CMD ["java", "-jar", "gateway.jar"]