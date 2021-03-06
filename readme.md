## DevTester - Grads - Cucumber RestAssured - 2019.8

#### Project structure - test

````
output->extent report html file
src->main - extent report related stuff
src->test - java - api - request / response handlers and Mediator
src->test - java - runner - cucumber runner with testng
src->test - java - stepdef - cucumber steps
src->test - java - stepsdef - utils - utilities for stepdef
src->resources - features - test files
src->resources - properties - properties files
src->resources - xml's for extent / logback / testng
````

### Build App and Run it from command line
* Run `mvn clean install -DskipTests`
* Run `mvn spring-boot:run`
    
### RUN Tests from IDE
* RightClick `Superhero.feature` - run
    - don't forget to debug your code
    - will produce an `DevTester-report.html`

### Changelog

#### [0.0.1-SNAPSHOT] - 2018-09-24
##### Added
- Init commit
- [Functionality] RestAssured GET test
- [Utils] Properties
- [Utils] Logback
- [Utils] ExtentReport

#### [0.0.2-SNAPSHOT] - 2019-08-12
- [Functionality] Added Swagger for local api
- [Functionality] RestAssured POST test


#### [0.0.3-SNAPSHOT] - 2019-08-13
- [Functionality] Pipeline
