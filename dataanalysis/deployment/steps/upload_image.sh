#!/bin/bash

source .env

cd ../..

mvn clean install spring-boot:repackage

dockerUrl=$REGISTRYURL/dataanalysis:$VERSION

echo "$dockerUrl"

docker build . -t $dockerUrl

docker push $dockerUrl