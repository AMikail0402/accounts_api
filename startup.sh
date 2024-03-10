#!/bin/bash
docker kill account-api
docker rm account-api
docker kill account-db
docker rm account-db
mvn clean install spring-boot:repackage
docker-compose -f db-config.yml up -d
