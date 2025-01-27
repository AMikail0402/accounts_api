FROM openjdk

RUN mkdir /opt/dataanalysis

COPY /target/datanalysis-1.0-SNAPSHOT.jar /opt/dataanalysis

EXPOSE 8080

CMD ["java","-jar","/opt/dataanalysis/datanalysis-1.0-SNAPSHOT.jar"]

