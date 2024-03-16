#!/bin/bash

#docker clean up
docker kill account-api
docker rm account-api
docker kill account-db
docker rm account-db
docker image prune --force
# build api 
mvn clean install spring-boot:repackage
# deploy db with newest artifact of api
docker-compose -f db-config.yml up -d
