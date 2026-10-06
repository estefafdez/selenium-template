# selenium-template

Template to start testing web applications with Selenium WebDriver, TestNG and Maven. It uses the Page Object pattern and runs a small example suite against [Selenium Easy](https://www.seleniumeasy.com/test/).

## Stack

- Java 8 or higher
- [Selenium](https://www.selenium.dev/) 4
- [TestNG](https://testng.org/) 7
- Maven
- Log4j 2 for logging

## Structure

All the code lives in the `template` folder:

```
template/
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   ├── configuration   # Driver setup, base page object and test set configuration
    │   │   ├── constant        # Locators and constants per page
    │   │   └── pageobject      # Page objects
    │   └── resources
    │       ├── log4j2.properties
    │       └── suite/testng.xml
    └── test/java/test          # TestNG tests
```

## Requirements

- JDK 8 or higher and Maven installed
- Google Chrome or Firefox installed. Selenium Manager downloads the matching driver automatically, so there is nothing else to set up

## Run the tests

```bash
cd template
mvn clean -DtestSuite="src/main/resources/suite/testng.xml" test
```

The suite is defined in `src/main/resources/suite/testng.xml`. To run only the compilation, without opening a browser:

```bash
mvn clean test-compile
```

## Configuration

The browser (`CHROME` or `FIREFOX`) and the operating system (`linux`, `mac` or `windows`) are set in `TestSetConfig.java`. On Linux, Chrome runs in headless mode.

## License

Mozilla Public License 2.0. See [LICENSE](LICENSE).
