FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD out/artifacts/tuan04_jar/tuan04.jar app.jar

ENTRYPOINT exec java -jar app.jar