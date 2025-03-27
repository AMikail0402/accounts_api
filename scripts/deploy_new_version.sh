#!/bin/bash

source .env

re='.*\-(main.*)'

# extract fqdn of active service
domain=$(kubectl get ingress api-ingress -o jsonpath='{.spec.rules[0].http.paths[0].backend.service.name}' -n networking --context networking-sa-context)

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

if [[ "$secondaryNameSpace" == "main" ]]; then
    context="pod-builder-sa-context"
else
    context="pod-builder-sa-green-context"
fi

echo $secondaryNameSpace

# stop exposing grey
helm upgrade networking ../deployment/ingress_switch -n networking \
--set test=false \
--set primaryNameSpace=$primaryNameSpace \
--set hostname=$HOSTNAME \
--kube-context networking-sa-context

# uninstall grey
helm uninstall accounts-project -n temp --kube-context pod-builder-sa-temp-context

echo $secondaryNamespace

# deploy new version to secondaryNamespace
helm upgrade accounts-project ../deployment/api -n $secondaryNameSpace \
--set version=$VERSION --install \ 
--kube-context $context


# switch traffic to secondary namespace
helm upgrade networking ../deployment/ingress_switch -n networking \
--set test=false \
--set primaryNameSpace=$secondaryNameSpace \
--set hostname=$HOSTNAME \ 
--kube-context networking-sa-context

# traffic now points to green 
# new image has been deployed to secondary namespace
# former secondary namespace is now primary namespace

# Quellen:
# https://helm.sh/docs/helm/helm_upgrade/