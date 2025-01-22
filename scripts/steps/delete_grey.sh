#!/bin/bash

helm uninstall accounts-project -n temp


re='.*\.(.*).svc'

# extract fqdn of active service
domain=$(kubectl get svc api-svc-01 -o jsonpath='{.spec.externalName}' -n networking)

echo $domain

[[ $domain =~ $re ]]

primaryNameSpace=${BASH_REMATCH[1]}

# stop exposing grey
helm upgrade networking ./deployment/svc_switch -n networking \
--set test=false \
--set hostname=$HOSTNAME \
--set primaryNameSpace=$primaryNameSpace