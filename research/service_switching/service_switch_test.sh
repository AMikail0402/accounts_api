#!/bin/bash

echo "starting svc-switch research"

re='.*\.(.*).svc'


for i in $(seq 1 50);
do 

# extract fqdn of active service
domain=$(kubectl get svc api-svc-01 -o jsonpath='{.spec.externalName}' -n networking)

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
touch ./service_logs/log_run_$i.json

curl --url "http://localhost/fortio/?labels=lab_short_svc_${i}&url=https%3A%2F%2Fprototype%2Fapi%2Ftransfer&qps=10&t=10s&n=&c=4&log-errors=on&connection-reuse-range-min=&connection-reuse-range-max=&connection-reuse-range-value=&uniform=on&nocatchup=on&p=50%2C+75%2C+90%2C+99%2C+99.9&r=0.0001&X=&H=&payload=&runner=http%2Ftcp%2Fudp&https-insecure=on&resolve=&grpc-ping-delay=0&healthservice=&save=on&timeout=750ms&load=Start" > ./service_logs/log_run_$i.json 2>&1 &

sleep 3

helm upgrade networking ../../deployment/svc_switch \
-n networking \
--set test=false \
--set primaryNameSpace=$secondaryNameSpace \
--set hostname=prototype


sleep 20
echo "Run number ${i}"
done