#!/bin/bash

helm uninstall accounts-project -n temp

re='.*\-(main.*)'

# extract fqdn of active service
domain=$(kubectl get ingress api-ingress -o jsonpath='{.spec.rules[0].http.paths[0].backend.service.name}' -n networking)

echo $domain

[[ $domain =~ $re ]]

primaryNameSpace=${BASH_REMATCH[1]}

# stop exposing grey
helm upgrade networking ./deployment/ingress_switch -n networking \
--set test=false \
--set hostname=$HOSTNAME \
--set primaryNameSpace=$primaryNameSpace