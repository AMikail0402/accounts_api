#!/bin/bash

kubectl delete jobs --all -n db-job

kubectl apply -f job.yml -n db-job
