#!/bin/bash

re='.*\-(main.*)'

for i in $(seq 1 10);
do 

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
touch ./ingress_logs/log_run_$i.json

curl --url "http://localhost:8080/fortio/?labels=testrun_exp_${i}&url=https%3A%2F%2Fhost.docker.internal%2Fapi%2Ftransfer&qps=3&t=15s&n=&c=10&log-errors=on&connection-reuse-range-min=&connection-reuse-range-max=&connection-reuse-range-value=&uniform=on&nocatchup=on&p=50%2C+75%2C+90%2C+99%2C+99.9&r=0.0001&X=&H=&payload=&runner=http%2Ftcp%2Fudp&https-insecure=on&stdclient=on&resolve=&grpc-ping-delay=0&healthservice=&save=on&timeout=750ms&load=Start" > ./ingress_logs/log_run_$i.json 2>&1 &


#docker run fortio/fortio load -logger-force-color \
#  -qps 3 \
#  -t 15s \
#  -https-insecure \
#  -json log_run_$i.json \
#  http://host.docker.internal/api/transfer 2>&1 &

sleep 3

helm upgrade networking ../../deployment/ingress_switch \
-n networking \
--set test=false \
--set primaryNameSpace=$secondaryNameSpace \
--set hostname=host.docker.internal


sleep 30
echo "Run number ${i}"
done