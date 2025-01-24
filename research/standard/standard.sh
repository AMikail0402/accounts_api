#!/bin/bash

date
re='.*\.(.*).svc'

uuid=$(openssl rand -hex 4)
runname=std_$uuid
# insert with cmd argument
median=2.200

echo $runname
for i in $(seq 1 25);
do 

touch ./standard_logs/log_run_$i.json
# backup
curl --url "http://localhost/fortio/?labels=lab_${runname}_${i}&url=https%3A%2F%2Fprototype%2Fapi%2Ftransfer&qps=10&t=10s&n=&c=4&log-errors=on&connection-reuse-range-min=&connection-reuse-range-max=&connection-reuse-range-value=&uniform=on&nocatchup=on&p=50%2C+75%2C+90%2C+99%2C+99.9&r=0.0001&X=&H=&payload=&runner=http%2Ftcp%2Fudp&https-insecure=on&resolve=&grpc-ping-delay=0&healthservice=&save=on&timeout=750ms&load=Start" > ./standard_logs/log_run_$i.json 2>&1 &

sleep 15
echo "Run number ${i}"
done

#curl --request GET \
#  --url http://localhost/da/median \
#  --header 'Content-Type: application/json' \
#  --header 'User-Agent: insomnia/2023.5.8' \
#  --data "{\"runname\": \"${runname}\", \"medianMilli\": \"${median}\"}"

date