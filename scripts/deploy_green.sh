#!/bin/bash

source .env

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

# uninstall grey
helm uninstall accounts-project -n temp

# stop exposing grey
helm upgrade networking ./deployment/svc_switch -n networking 
\ --set test=false 
\ --set primaryNameSpace=$primaryNameSpace
\ --set hostname=$HOSTNAME

echo $secondaryNamespace

# deploy new version to secondaryNamespace
helm upgrade accounts-project ./deployment/api -n $secondaryNameSpace 
\ --set db.namespace=db 
\ --set version=$VERSION --install

# switch traffic to secondary namespace
helm upgrade networking ./deployment/vc_switch -n networking 
\ --set test=false 
\ --set primaryNameSpace=$secondaryNameSpace
\ --set hostname=$HOSTNAME

# traffic now points to green 
# new image has been deployed to secondary namespace
# former secondary namespace is now primary namespace

# Quellen:
# https://helm.sh/docs/helm/helm_upgrade/