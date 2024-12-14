#!/bin/bash

source .env

dockerUrl=localhost:5000/accounts-api:$VERSION

echo "$dockerUrl"

docker build apps/accounts-api -t $dockerUrl

docker push $dockerUrl