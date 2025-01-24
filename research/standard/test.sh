#!/bin/bash
begin=$(date +'%Y-%m-%dT%H:%M:%S%3N')
echo -e "{\n  \"time_total\": \"0s\",\n  \"sent_time\": \"${begin}\"\n}," >> totals.json

for i in $(seq 100);
do 
curl -w "{\n  \"time_total\": \"%{time_total}s\",\n  \"sent_time\": \"$(date +'%Y-%m-%dT%H:%M:%S%3N')\"\n},\n" -o /dev/null -s https://localhost/api/transfer >> totals.json
done