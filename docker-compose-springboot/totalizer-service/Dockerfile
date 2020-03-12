FROM openjdk:8

EXPOSE 8080

COPY ./build/libs/totalizer-service-0.0.1-SNAPSHOT.jar totalizer.jar

ENTRYPOINT ["java","-jar","/totalizer.jar"]