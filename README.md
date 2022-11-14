# Spring Boot Word-Relation API Project

This is a sample Java / Maven / Spring Boot (v2.7.5) application for word relations.

## How to Run

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository
* Make sure you are using JDK 1.8+ and Maven 3.x+
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
java -jar -Dspring.profiles.active=test target/wordrelation-0.0.1-SNAPSHOT
or
mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"
```

## About the Service

Here are the endpoints which can be called:

```
http://localhost:8080/api/v1/word-relations (POST)
http://localhost:8080/api/v1/word-relations/{includeInverse} (GET)
http://localhost:8080/api/v1/word-relations/{relation} (GET)
http://localhost:8080/api/v1/word-relations/relationStr/{firstWord}/{secondWord} (GET) // Needs work
```

### To view Swagger 2 API docs

Run the server and browse to localhost:8080/swagger-ui/