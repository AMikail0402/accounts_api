#!/bin/bash

for i in {1..100}; 
do
  curl -o /dev/null -s -w "Time Total: %{time_total}s\n" --request GET \
  --url http://localhost/api/transfer \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/2023.5.8' 
done