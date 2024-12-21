#!/bin/bash

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

# switch traffic to secondary namespace
helm upgrade networking ./deployment/ingress -n networking --set test=false --set primaryNameSpace=$secondaryNameSpace
