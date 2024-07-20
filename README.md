
# Ebay Automation

A brief description of what this project does and who it's for

### Approach to Build the framework
- Create Maven Project.
- Add dependencies.
- Create Base Files: base page, global config properties file, browser drivers, base test.
- Implement Page Object Repository: create Page Object classes to store objects of each page separately.
- Implement Page Classes: create Page classes to instantiate and create methods using elements from page objects
- Implement validations using TestNG assertions.
- Create a testng.xml file: create a suite containing all the tests.
- Add initDriver(@BeforeTest) and tearDriver(@AfterTest) methods.
- Integrate testng.xml into maven pom.xml: On doing so, whenever we trigger maven file(mvn test), it will trigger testng.xml file and that will inturn trigger all the test cases.
- Modify testng.xml to create individual tests instead of all tests wrapped into a single test tag.
- Add parallel='methods' attribure in testng.xml to run tests parallely.
- Added screenshots on failures using TestNG Listeners.
- Add TestNG listener information to testng.xml file.
- Added extent reports to TestNG listener.

### Prerequisite
- Maven or Gradle build tools should be installed and configured,
- Java v1.8 or higher should be installed and configured,
- Lombok dependency in mvn should be added and Lombok plugin has to be installed in order to access members of Page object classes
- Make sure to sync all the latest dependencies as per maven.
### Steps to execute the script file via following:
- To run tests independently : Press control + shift + R (mac) after selecting test method.
- Create run configuration : Select test kind class / method / group and relevant parameters and click on run
- Run using TestNG XML: Create run configuration> Test kind : Suite > Select testng.xml file and click on run
- Run using maven : hit `mvn test` command or go to maven > lifecycle > test





#### Authors

- Nikhar Trivedi

