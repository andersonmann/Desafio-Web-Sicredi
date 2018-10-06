# Technical proof sicredi 

This code was developed to the selection of Sicredi.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Java JRE
* Java JDK
* Google Chrome
* Selenium Webdriver
* Chrome driver
* IDE

### Installing

To running this project, you need do it the following steps:

```
Create a new maven project and import this code.
```

Or 

```
Import this project.
```

Double check

```
verify that all dependencies of the project have been downloaded.
```

## Running the tests

You could execute the suite test (testng.xml), located at package "suite", or execute the test class, located at package "test".
You can also running parallell tests, to this you must change the parameter thread-count, on testng.xlm

### Purpose of the tests

The tests created simulate a user creating a register, searching and deleting this register.
Were explored different types of locators and strategies.

```
Creation the customer register using differents informations.
```

### Design Pattern

The below design patterns are used at this project

```
DSL
```

```
Factory
```

```
Singleton
```

```
Strategy
```

## Deployment

You just must execute the test classes.

## Built With

* [SELENIUM WEBDRIVER](http://seleniumwebdriver.org/selenium-webdriver/) - The automation framework used
* [TestNG](https://testng.org/doc/documentation-main.html/) - The automation framework used
* [MAVEN](https://maven.apache.org/) - Dependency Management
* [JAVA](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html/) - Programing language


## Versioning

WAas used [Sourcetree](https://www.sourcetreeapp.com//) for versioning. 

## Authors

* **Anderson Mann** - *Sr. QA Engineer* - [GitHub](https://github.com/andersonmann)

## License

This project is licensed under the GNU License.

## Acknowledgments

* With this tool you do not have to develop methods to perform various interactions with elements and web components, saving time to perform more productive tasks.
