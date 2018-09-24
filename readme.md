## DevTester - Fresh Grads - Cucumber RestAssured - 2018

#### Project structure

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

### RUN Tests from command line
* Run `mvn clean install`
    - will produce an `DevTester-report.html`
    
### RUN Tests from IDE
* RightClick `GetPetclinic.feature` - run
    - don't forget to debug your code

### Changelog

#### [0.0.1-SNAPSHOT] - 2018-09-24
##### Added
- Init commit
- [Functionality] RestAssured GET tests
- [Utils] Properties
- [Utils] Logback
- [Utils] ExtentReport

#### [0.0.2-SNAPSHOT] - 2018-10-01
##### TODO
- [Functionality] RestAssured POST tests
- [Functionality] Objects and Mappers
- [Functionality] Asserts