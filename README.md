# Scheduler Service & Web Project
## Assumptions
- you have the knowledge to install Java, Maven, Docker Desktop, and an IDE like Eclipse

## Dependencies
- OpenJdk 11 OR Amazon Corretto 11 JDK
- maven 4.0+
- Docker desktop installed if going to use docker locally

## Things to note
- Right now the app start recreates all tables and drops all data - will adjust as progress on project
- The app build is dependent on a mysql container to be up and running

## How to Run
- Either use docker-compose or start container(s) manually
- Have to download source from [https://github.com/rakoch/scheduler.git](https://github.com/rakoch/scheduler.git)
- use master branch
- open a terminal or command shell
- cd to the project root for all options below--e.g., `cd ~/workspace/scheduler`
- Make sure docker desktop is running and cleaned out of containers and images for this project
- in terminal:  `docker pull mysql`

### You have several options on how to run and Test local rest End points
#### Run app as Java in Eclipse AFTER starting mysql container
- remove any previous mysql and scheduler docker containers and images
- `docker run --name mysql -p  127.0.0.1:3306:3306 -e MYSQL_ROOT_PASSWORD="password" mysql &`
- Run from within eclipse by using ‘Run as -> Java Application’ on the SchedulerApplication.java
- Test with swagger: [http://localhost:8080/schedapp/swagger-ui.html](http://localhost:8080/schedapp/swagger-ui.html)

#### Run app from command line using spring-boot:run AFTER starting mysql container
- remove any previous mysql and scheduler docker containers and images
- `docker run --name mysql -p  127.0.0.1:3306:3306 -e MYSQL_ROOT_PASSWORD="password" mysql &`
- start the app with this command: ./mvnw spring-boot:run
- Test with swagger: [http://localhost:8080/schedapp/swagger-ui.html](http://localhost:8080/schedapp/swagger-ui.html)

#### Run app in docker container using DockerFile
- remove any previous mysql and scheduler docker containers and images
- `docker run --name mysql -p  127.0.0.1:3306:3306 -e MYSQL_ROOT_PASSWORD="password" mysql &`
- cd to the project root--e.g., ~/workspace/scheduler
- `mvnw install`
- Test run of application if you want: java -jar target\scheduler-0.0.1-SNAPSHOT.jar
- `docker build  -t scheduler:v1 .`
- `docker run -it -p8080:8080 scheduler:v1`
- Test with swagger: [http://localhost:8080/schedapp/swagger-ui.html](http://localhost:8080/schedapp/swagger-ui.html)

#### Run in docker container using Buildpack through spring-boot:build-image
- remove any previous mysql and scheduler docker containers and images
- `docker run --name mysql -p  127.0.0.1:3306:3306 -e MYSQL_ROOT_PASSWORD="password" mysql &`
- Deploy to Docker using Spring Boot Buildpack
- `mvnw spring-boot:build-image`
- `docker run -it -p8080:8080 scheduler:0.0.1-SNAPSHOT`
- Test with swagger: [http://localhost:8080/schedapp/swagger-ui.html](http://localhost:8080/schedapp/swagger-ui.html)

### use docker-compose to start everything
- assumes mvn install/build was performed TODO make this part of the deploy
- remove any previous mysql and scheduler docker containers and images
- `docker-compose up --build -d`

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
