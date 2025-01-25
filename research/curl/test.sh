#!/bin/bash
begin=$(date +'%Y-%m-%dT%H:%M:%S%3N')

appendage=ingress

echo -e "{\n  \"time_total\": \"0s\",\n  \"sent_time\": \"${begin}\"\n}," >> totals_$appendage.json

for i in $(seq 500);
do 
curl --keepalive-time 3600 -w "{\n  \"time_total\": \"%{time_total}s\",\n  \"sent_time\": \"$(date +'%Y-%m-%dT%H:%M:%S%3N')\"\n},\n" -o /dev/null -s https://localhost/api/transfer >> totals_$appendage.json
if (( $i % 50 == 0 )); then
  echo "$i Anfragen wurden verschickt"
fi
done