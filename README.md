# Scheduler Service & Web Project
## Assumptions
- you have the knowledge to install Java, Maven, and an IDE like Eclipse

## Dependencies
- Amazon Corretto 11 JDK
- maven 4.0+

## How to Run
- TODO need to explain need for container running dbase
- Have to download source from https://github.com/rakoch/scheduler.git
- use master branch
- adjust hard-coded path in application.properties to point where the json files exists for the project on your machine
- open a terminal or command shell
- cd to the project root--e.g., ~/workspace/scheduler
- start the app with this command: ./mvnw spring-boot:run
- after you see it reported that '...Started SchedulerServiceApplication...' open up a browser 
- in the browser enter the link for openapi/swagger ui and try out the endpoint (click try it, then blue execute button): http://localhost:8080/swagger-ui.html

## How to run Integration Tests
- TODO need to explain need for container running dbase
- Have to download source from https://github.com/rakoch/scheduler.git
- use master branch
- adjust hard-coded path in application.properties to point where the json files exists for the project on your machine
- open a terminal or command shell
- cd to the project root--e.g., ~/workspace/scheduler
- type in command: mvn test
- should see results: Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

## Notes on initial project creation
- use spring initilzr  - web, actuator, devtools - see pom.xml
- generate
- unzip generated zip file and place in workspace
- cd to directory and `git init`create or copy .gitignoregit add .
- git commit -m "first commit"
- go to github and create a new private repo with nothing in it (name scheduler)
- At the top of your GitHub repository's Quick Setup page, click  to copy the remote repository URL.
- git remote add origin https://github.com/rakoch/scheduler.git
- git remote -v
- git push origin master
