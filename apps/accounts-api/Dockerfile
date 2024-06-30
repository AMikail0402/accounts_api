FROM openjdk

RUN mkdir /opt/accounts-api

COPY /target/accounts_api-1.0-SNAPSHOT.jar /opt/accounts-api

EXPOSE 8080

CMD ["java","-jar","/opt/accounts-api/accounts_api-1.0-SNAPSHOT.jar"]

