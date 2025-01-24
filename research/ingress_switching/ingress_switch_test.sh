#!/bin/bash

date
echo "starting ingress-switch research"

re='.*\-(main.*)'


uuid=$(openssl rand -hex 4)
runname=ing_$uuid
# insert with cmd argument
median=2.200

echo $runname

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

curl --url "http://localhost/fortio/?labels=lab_${runname}_${i}&url=https%3A%2F%2Fprototype%2Fapi%2Ftransfer&qps=10&t=5s&n=&c=4&log-errors=on&connection-reuse-range-min=&connection-reuse-range-max=&connection-reuse-range-value=&uniform=on&nocatchup=on&p=50%2C+75%2C+90%2C+99%2C+99.9&r=0.0001&X=&H=&payload=&runner=http%2Ftcp%2Fudp&https-insecure=on&resolve=&grpc-ping-delay=0&healthservice=&save=on&timeout=750ms&load=Start" > ./ingress_logs/log_run_$i.json 2>&1 &


sleep 1

helm upgrade networking ../../deployment/ingress_switch \
-n networking \
--set test=false \
--set primaryNameSpace=$secondaryNameSpace \
--set hostname=prototype

sleep 7

echo "Run number ${i}"
done

curl --request GET \
  --url http://localhost/da/median \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/2023.5.8' \
  --data "{\"runname\": \"${runname}\", \"medianMilli\": \"${median}\"}"


date