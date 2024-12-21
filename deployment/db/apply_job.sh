#!/bin/bash

kubectl delete jobs --all -n db-job

kubectl apply -f reset-connections-job.yml -n db-job
