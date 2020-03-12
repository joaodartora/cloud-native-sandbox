FROM openjdk:8

EXPOSE 8080

COPY ./build/libs/github-service-0.0.1-SNAPSHOT.jar github.jar

ENTRYPOINT ["java","-jar","/github.jar"]