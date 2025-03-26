@REM Author: Chinthaka Senanayaka
@REM Year: 2022-2024

cd perf\scripts\java\time
docker rm container-java-time
docker compose up --remove-orphans
cd ..\..\..\..