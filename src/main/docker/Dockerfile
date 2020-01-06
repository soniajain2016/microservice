FROM openjdk:8u131-jdk-alpine

MAINTAINER "soniajain2016@gmail.com"

EXPOSE 8089

WORKDIR /usr/local/bin/

COPY maven/microservice-1.0-SNAPSHOT.jar webapp.jar

CMD ["java","-Dspring.profiles.active=docker-demo","-jar","webapp.jar"]