FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/gateway-service*.jar /app/gateway-service.jar
CMD ["java", "-jar", "gateway-service.jar"]