#!/bin/bash

kubectl delete jobs --all -n db-job

kubectl apply -f transfer-job.yml -n db-job
