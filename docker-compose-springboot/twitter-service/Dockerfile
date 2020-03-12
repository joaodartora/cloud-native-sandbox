FROM openjdk:8

EXPOSE 8080

COPY ./build/libs/twitter-service-0.0.1-SNAPSHOT.jar twitter.jar

ENTRYPOINT ["java","-jar","/twitter.jar"]