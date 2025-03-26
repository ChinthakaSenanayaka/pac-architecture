# Building this image takes 10 minutes.
# Author: Chinthaka Senanayaka
# Year: 2022-2024
FROM ubuntu:jammy

RUN apt-get update && apt-get -y upgrade
# Installing GCC compiler
RUN apt-get -y install build-essential manpages-dev default-jdk