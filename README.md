# selfcare-ms-spring-archetype 
The goal of this project is to provide a template for generating new Spring Boot-based microservices.

### Testing
Use `mvn package integration-test` to test the archetype (for more detail about testing a maven archetype, see [Maven Archetype Integration Test](https://maven.apache.org/archetype/maven-archetype-plugin/integration-test-mojo.html)).

### Installation
Use `mvn install` to install archetype locally.

### Project generation
Move to the destination directory and run `mvn archetype:generate -DarchetypeCatalog=local` to create a new project from the archetype. 
