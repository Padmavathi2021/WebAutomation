A Maven and Cucumber framework in which to build Selenium tests written in Java

Getting Started
Copy the repo into your local machine.

Run tests locally
Right click the Test Runner class and Run as JUnit test

Define the browser name, driver path and url in Configuration.properties file
browser=chrome
driverPath=chromedriver_win32//chromedriver.exe

Test data:
Test Data is given as Json file under src/test/reosurces and corresponding Class types should be defined under src/main/java/testDataTypes
JSon file contents can be converted to a list using the JsonDataReader class under src/main/java/dataProviders. Based on the given 
key from Feature file, test data will be retrieved from Json

BasePage:
It provides some of the WebDriver methods with exception Handling

Logging:
Logging can be easily added to tests by using the static methods from the Log class.

Info
Log.Info("This is an info level message");

Error
Log.Error("This is an error level message");

A detailed log file is generated in the project root path
