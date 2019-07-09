# Technical test sicredi 

This code was developed to the selection of Sicredi.(enjoy)

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
At Eclipse IDE
```

```
Access File > Import...
```

```
Projects from Git
```

```
Select a wizard to use importing projects choose the option Import as general project
```

```
Right click on the project and choose an option
```

```
Configure > Convert to Maven Project
```

Double check

```
verify that all dependencies of the project have been downloaded.
```

## Running the tests

You could execute the suite test (testng.xml), located at package "suite", or execute the test class, located at package "test".
You can also running parallell tests, to this you must change the parameter thread-count, on testng.xlm

The browser configured was Google Chrome, but you can change the browser, just change the parameter of the Properties class, located in the core package.
Make sure that you have the driver for the selected browser.

After the test execution, are create screenshots files, to evidence the result. 
They are stored at folder called screenshots.

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

Was used [Sourcetree](https://www.sourcetreeapp.com//) for versioning. 

## Authors

* **Anderson Mann** - *Sr. QA Engineer* - [GitHub](https://github.com/andersonmann)

## License

This project is licensed under the GNU License.

## Acknowledgments

* With this tool you do not have to develop methods to perform various interactions with elements and web components, saving time to perform more productive tasks.
