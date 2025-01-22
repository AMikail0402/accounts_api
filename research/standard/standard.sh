#!/bin/bash

re='.*\.(.*).svc'


for i in $(seq 1 10);
do 

touch ./standard_logs/log_run_$i.json

curl --url "http://localhost/fortio/?labels=lab_std_${i}&url=https%3A%2F%2Fprototype%2Fapi%2Ftransfer&qps=4&t=50s&n=&c=1&log-errors=on&connection-reuse-range-min=&connection-reuse-range-max=&connection-reuse-range-value=&uniform=on&nocatchup=on&p=50%2C+75%2C+90%2C+99%2C+99.9&r=0.0001&X=&H=&payload=&runner=http%2Ftcp%2Fudp&https-insecure=on&resolve=&grpc-ping-delay=0&healthservice=&save=on&timeout=750ms&load=Start" > ./standard_logs/log_run_$i.json 2>&1 &

sleep 70
echo "Run number ${i}"
done