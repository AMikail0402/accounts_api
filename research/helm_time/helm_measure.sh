#!/bin/bash

re='.*\-(main.*)'

# extract fqdn of active service
domain=$(kubectl get ingress api-ingress -o jsonpath='{.spec.rules[0].http.paths[0].backend.service.name}' -n networking)

echo $domain

[[ $domain =~ $re ]]

primaryNameSpace=${BASH_REMATCH[1]}

case $primaryNameSpace in
  main)
    secondaryNameSpace=main-2
    ;;
  main-2)
    secondaryNameSpace=main
    ;;
  *)
    echo "Ingress-Name is faulty"
    exit 1
    ;;
esac

echo $secondaryNameSpace

echo "Date right before $(date '+%a %b %d %H:%M:%S %Y')"
helm upgrade networking ../../deployment/ingress_switch \
-n networking \
--set test=false \
--set primaryNameSpace=$secondaryNameSpace \
--set hostname=host.docker.internal \
--debug | grep "LAST"