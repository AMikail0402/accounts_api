#!/bin/bash

for i in {1..400}; do
  curl --request POST \
  --url http://localhost/api/user \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/2023.5.8' \
  --data '{
	"family_name": "testFamily",
	"surname": "test test", 
	"address": "test_address",
	"phone_number": "014122233"
  }'
done