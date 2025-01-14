#!/bin/bash

source .env

cd ../../apps/accounts-api

mvn clean install spring-boot:repackage

dockerUrl=$REGISTRYURL/accounts-api:$VERSION

echo "$dockerUrl"

docker build . -t $dockerUrl

docker push $dockerUrl