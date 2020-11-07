ARG CORRETTO_VERSION="11"
FROM amazoncorretto:${CORRETTO_VERSION}
VOLUME /tmp
ARG JAR_FILE=target/scheduler-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]