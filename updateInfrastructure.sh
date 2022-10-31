#!/bin/bash

aws cloudformation update-stack --stack-name gradle-hero --template-body file://./cloud.yml --capabilities CAPABILITY_IAM
aws cloudformation wait stack-update-complete --stack-name gradle-hero