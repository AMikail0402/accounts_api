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

kubectl delete jobs --all -n db-job

# reset db and import schema 
kubectl apply -f ./deployment/db/reset-connections-job.yml -n db-job

# wait for db reset
kubectl wait --for=condition=complete job/db-reset -n db-job

# comission grey
## db namespace is fixed for this deployment as well as namespace
helm install accounts-project ./deployment/api -n temp --set db.namespace=db-2 --set version=$VERSION

# extract primaryNamespace / determine blue and green

re='.*\.(.*).svc'

# extract fqdn of active service
domain=$(kubectl get svc api-svc-01 -o jsonpath='{.spec.externalName}' -n networking)

echo $domain

[[ $domain =~ $re ]]

primaryNameSpace=${BASH_REMATCH[1]}

echo $primaryNameSpace

case $primaryNameSpace in
  main)
    secondaryNameSpace=main-2
    ;;
  main-2)
    secondaryNameSpace=main
    ;;
  *)
    echo "Servicename is faulty"
    exit 1
    ;;
esac

echo $secondaryNameSpace

# expose grey
# primary namespace needs to be seen
helm upgrade networking ./deployment/ingress -n networking --set test=true --set primaryNameSpace=$primaryNameSpace

# commence e2e test 
sleep 10
echo "exploratory tests done"

# commence exploratory-test
# If no end to end tests are being used, the pipeline should be restarted with an option

# stop exposing grey
helm upgrade networking ./deployment/ingress -n networking --set test=false --set primaryNameSpace=$primaryNameSpace

echo $secondaryNamespace

# deploy new version to secondaryNamespace
helm upgrade accounts-project ./deployment/api -n $secondaryNameSpace --set db.namespace=db --set version=$VERSION

# switch traffic to secondary namespace
helm upgrade networking ./deployment/ingress -n networking --set test=false --set primaryNameSpace=$secondaryNameSpace

# traffic now points to green 
# new image has been deployed to secondary namespace
# former secondary namespace is now primary namespace

# sources
# bash-case: https://linuxize.com/post/bash-case-statement/
# regex: https://stackoverflow.com/questions/19737675/how-do-i-extract-a-string-using-a-regex-in-a-shell-script
