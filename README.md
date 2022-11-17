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

- Run the application and go on http://localhost:8080/

Here are urls to call realted endpoints:

| Request | Route                                   | Body                                                                                  | RequestParam/PathVariable | Açıklama                                                                     |   
|:--------|:----------------------------------------|:--------------------------------------------------------------------------------------|:--------------------------|:-----------------------------------------------------------------------------|
| POST    | /api/v1/word-relations                  | { <br>"firstWord": "road",<br>"secondWord": "avenue",<br> "relation": "related"<br/>} |                           | Adds a new relation record                                                   |
| GET     | /api/v1/word-relations/{includeInverse} |                                                                                       | includeInverse            | Lists all relations                                                          |
| GET     | /api/v1/word-relations                  |                                                                                       | relation                  | Lists by relation                                                            |
| GET     | /api/v1/word-relations/relationStr      |                                                                                       | firstWord, secondWord     | Creates a relation string based on a relation between first and second word. |

### To view Swagger 2 API docs

Run the server and browse to localhost:8080/swagger-ui/
