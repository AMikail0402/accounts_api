#!/bin/bash

source .env

dockerUrl=$REGISTRYURL/kc:$VERSION

echo "$dockerUrl"

cd ..

docker build . -t $dockerUrl

docker push $dockerUrl
