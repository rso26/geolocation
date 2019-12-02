FROM openjdk:11.0.4-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/geolocation-api-1.0.0-SNAPSHOT.jar /app

EXPOSE 8084

CMD ["java", "-jar", "geolocation-api-1.0.0-SNAPSHOT.jar"]