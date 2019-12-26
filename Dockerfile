FROM openjdk:8-alpine

WORKDIR /opt/app
RUN mkdir /opt/app/logs

ADD ./target/book-api:1.0.jar book-api:1.0.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar" ]

CMD [ "book-api:1.0.jar" ]