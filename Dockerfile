FROM openjdk:8
VOLUME /tmp
ADD build/libs/spring-elastic-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
