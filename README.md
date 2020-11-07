# Scheduler Service & Web Project
## Assumptions
- you have the knowledge to install Java, Maven, and an IDE like Eclipse

## Dependencies
- Amazon Corretto 11 JDK
- maven 4.0+
- Docker desktop installed if going to use docker locally

## How to Run
- TODO need to explain need for container running dbase
- Have to download source from https://github.com/rakoch/scheduler.git
- use master branch
- open a terminal or command shell
- cd to the project root--e.g., ~/workspace/scheduler

### You have several options on how to run and Test local rest End points
#### Run as Java in Eclipse
- Run from within eclipse by using ‘Run as Java’ SchedulerApplication.java
- Test with swagger: http://localhost:8080/schedapp/swagger-ui.html

#### Run from command line using spring-boot:run
- cd to the project root--e.g., ~/workspace/scheduler
- start the app with this command: ./mvnw spring-boot:run
- Test with swagger: http://localhost:8080/schedapp/swagger-ui.html

#### Run in docker container using DockerFile
- Make sure docker desktop is running
- cd to the project root--e.g., ~/workspace/scheduler
- mvnw install
- Test run of application: java -jar target\scheduler-0.0.1-SNAPSHOT.jar
- docker build  -t scheduler:v1 .
- docker run -it -p8080:8080 scheduler:v1
- Test with swagger: http://localhost:8080/schedapp/swagger-ui.html

#### Run in docker container using Buildpack through spring-boot:build-image
- Make sure docker desktop is running
- Deploy to Docker using Spring Boot Buildpack
- cd ~/workspace/scheduler
- mvnw spring-boot:build-image
- docker run -it -p8080:8080 scheduler:0.0.1-SNAPSHOT
- Test with swagger: http://localhost:8080/schedapp/swagger-ui.html

### In Swagger
- in the browser enter the link for openapi/swagger ui and try out the endpoint (click try it, then blue execute button): http://localhost:8080/swagger-ui.html

## How to run Integration Tests
- TODO need to explain need for container running dbase
- Have to download source from https://github.com/rakoch/scheduler.git
- use master branch
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
