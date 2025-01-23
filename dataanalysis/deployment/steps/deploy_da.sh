#!/bin/bash

source .env

cd ../..

mvn clean install spring-boot:repackage

dockerUrl=$REGISTRYURL/da-api:$VERSION

echo "$dockerUrl"

docker build . -t $dockerUrl

docker push $dockerUrl

sleep 5

helm upgrade da-api ./deployment/da -n da \
--set version=$VERSION \
--set image.pullPolicy=Always --force \
--set environment.registryUrl=$REGISTRYURL