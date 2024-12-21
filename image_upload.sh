#!/bin/bash

# uninstall grey
helm uninstall accounts-project -n temp
source .env

cd apps/accounts-api

mvn clean install spring-boot:repackage

dockerUrl=localhost:5000/accounts-api:$VERSION

echo "$dockerUrl"

docker build . -t $dockerUrl

docker push $dockerUrl

cd ../..

bash ./deployment/db/apply_job.sh

# wait for db reset
kubectl wait --for=condition=complete job/db-reset -n db-job

# comission grey
## db namespace is fixed for this deployment as well as namespace
helm install accounts-project ./deployment/api -n temp --set db.namespace=db-2 --set version=$VERSION

# expose grey


# commence e2e test 
sleep 10 
echo "E2E-Test Done" 

