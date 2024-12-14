#!/bin/bash

source .env

cd apps/accounts-api

mvn clean install spring-boot:repackage

dockerUrl=localhost:5000/accounts-api:$VERSION

echo "$dockerUrl"

docker build . -t $dockerUrl

docker push $dockerUrl