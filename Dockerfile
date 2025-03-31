# Author: Chinthaka Senanayaka, Emile Guillaume, Alireza Abrehforoush
# Year: 2025-2026
FROM ubuntu:jammy

RUN apt-get update && apt-get -y upgrade
# Installing JDK compiler
RUN apt-get -y install build-essential manpages-dev default-jdk maven curl python3-requests