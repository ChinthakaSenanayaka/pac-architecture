#!/bin/bash

cd /project

java_v=("$(java -version)")
echo $java_v

# Compile the Java PAC demo project
mvn clean install

# Run the Java PAC demo project
mvn spring-boot:run