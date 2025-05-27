FROM eclipse-temurin:21-jre

WORKDIR /app

RUN apt-get update && apt-get install -y netcat-openbsd && apt-get clean

COPY target/store-management-customers-and-products-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for.sh wait-for.sh

RUN chmod +x wait-for.sh


EXPOSE 8080

