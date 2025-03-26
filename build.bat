@REM Author: Chinthaka Senanayaka
@REM Year: 2022-2024

cd perf\scripts\java

@REM If you built the base Java image on your local, run this file. Building this image takes 10 minutes.
docker build -t build-java-image:latest .

cd ..\..\..