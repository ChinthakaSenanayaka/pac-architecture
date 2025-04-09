# pac-architecture
This project demonstrates PAC architecture

## Prerequisites
1. Install Docker
2. Run "build.sh" or "build.bat" file to build the base Docker image with all the required software infrastructure (E.g. Java, etc.)

## Build and Run the project
1. Run the "run.sh" or "run.bat" file
    1. This script 
        1. Compiles the project Java source code
        2. Builds the Java PAC architectture project
        3. Runs the tests
        4. Runs the PAC server if the test succeeds
        5. Visit http://localhost:8080/0 on your browser
            1. 0 is the user ID.
            2. Sample data were added for 0, 1, 2, 3 users for customer and seller user roles.

## Simulate PAC multiple data sources and different speed data changes on the data layer and on the views
1. Visit http://localhost:8080/0 on your browser
    1. This is needed to initialize the sample 0,1,2,3 users in the application to run since registration and signin functionalities are not implmemented but focused on PAC demonstration.
2. Slowly updating datasource
    1. This is products datasource (DB table).
    2. Simulation script is in "scripts/product.sh"
    3. To run the product PAC slow simulation:
        1. Log in to the docker container with "docker exec -it container-pac-demo /bin/bash"
        2. run "./project/scripts/product.sh"
3. Fast updating datasource
    1. This is orders datasource (DB table).
    2. Simulation script is in "scripts/order.sh"
    3. To run the product PAC fast simulation:
        1. Log in to the docker container with "docker exec -it container-pac-demo /bin/bash"
        2. run "./project/scripts/order.sh"
4. Visit http://localhost:8080/2 on your browser for seller's login for better PAC demonstration view.

## Stop the PAC demo application server
1. Press Ctrl + c to exit server command prompt

## Testing plan and test report
### Testing plan
1. Testing plan can be found in "src/test/main"
2. Tests are organized into packages for controller and abstraction.
3. Testing on PAC Presentation is not possibile since Presentation is on the browser and needs browser testing tools such as Selenium, etc. which makes the project complex.
3. There are 20 test cases all together covering all the business use cases.
4. Each use case has self-descriptive test name as well as code comment explaining the testing scenario.

### Testing report
1. Testing report is generated and shown on the command line (or terminal) when the "run.sh" or "run.bat" files are run.
3. PAC server will be started and ready to use only if the tests were succeeded.