#!/bin/bash

#https://stackoverflow.com/questions/19737675/how-do-i-extract-a-string-using-a-regex-in-a-shell-script

re='.*\.(.*).svc'

domain=$(kubectl get svc api-svc-01 -o jsonpath='{.spec.externalName}' -n networking)

echo $domain

[[ $domain =~ $re ]]

primaryNameSpace=${BASH_REMATCH[1]}

echo $primaryNameSpace

case $primaryNameSpace in
  main)
    secondaryNamespace=main-2
    ;;
  main-2)
    secondaryNamespace=main
    ;;
  *)
    echo "Servicename is faulty"
    exit 1
    ;;
esac

echo $secondaryNamespace