#!/bin/bash

# Author: Chinthaka Senanayaka
# Year: 2022-2024

cd perf/scripts/java

# If you built the base Java image on your local, run this file. Building this image takes 10 minutes.
docker build -t build-java-image:latest .

cd ../../..