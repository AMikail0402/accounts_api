#!/bin/bash
docker kill account-api
docker rm account-api
docker kill account-db
docker rm account-db
docker-compose -f db-config.yml up -d
mvn clean install spring-boot:repackage
docker build -t account . 
docker run -d --name account-api -p 8080:8080 account