# pac-architecture
This project demonstrates PAC architecture

## Prerequisites
1. Install Docker
2. Run "build.sh" or "build.bat" file to build the base Docker image with all the required software infrastructure (E.g. Java, etc.)

## Build and Run the project
1. Run the "run.sh" or "run.bat" file
    1.a. This script 
        1.a.1. Compiles the project Java source code
        1.a.2. Builds the Java PAC architectture project
        1.a.3. Runs the tests
        1.a.4. Runs the PAC server if the test succeeds
        1.a.5. Visit "http://localhost:8080/0" on your browser
            1.a.5.a. 0 is the user ID.
            1.a.5.b. Sample data were added for 0, 1, 2, 3 users for customer and seller user roles.

## Simulate PAC multiple data sources and different speed data changes on the data layer and on the views
1. Visit "http://localhost:8080/0" on your browser
    1.a. This is needed to initialize the sample 0,1,2,3 users in the application to run since registration and signin functionalities are not implmemented but focused on PAC demonstration.
2. Slowly updating datasource
    2.a. This is products datasource (DB table).
    3.b. Simulation script is in "scripts/product.sh"
    4.c. To run the product PAC slow simulation:
        2.c.1. Log in to the docker container with "docker exec -it container-pac-demo /bin/bash"
        2.c.2. run "./project/scripts/product.sh"
3. Fast updating datasource
    3.a. This is orders datasource (DB table).
    4.b. Simulation script is in "scripts/order.sh"
    3.c. To run the product PAC fast simulation:
        3.c.1. Log in to the docker container with "docker exec -it container-pac-demo /bin/bash"
        3.c.2. run "./project/scripts/order.sh"
4. Visit "http://localhost:8080/2" on your browser for seller's login for better PAC demonstration view.

## Stop the PAC demo application server
1. Press Ctrl + c to exit server command prompt