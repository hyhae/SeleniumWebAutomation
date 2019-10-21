# SeleniumWebAutomation
How to Run:
1-	Make sure you have maven, a jdk , and chrome installed.
2-	Clone the repository using “git clone https://github.com/hyhae/SeleniumWebAutomation” if you have a git command line client or by visiting the url and downloading the project zipped.
3-	Navigate to the root folder of the repository.
4-	Run the program by importing it to your favorite Java IDE or by running “mvn test” from the command line.
5-	Reports by default are generated in “resources/reports/”

How to configure the test properties:
You can configure some aspects of the tests to a certain degree by changing some properties in the config.properties file. 
You can change:
-	The registration page URL, though it will cause the program to crash
-	The minimum timeout of the application before it quits
-	The path to your chromedriver in-case you don’t want to use the bundled one.
-	The path where the application saves the screenshots
-	The path where the application saves the reports
-	The path where your test data exists

How to configure the test runs:
You can control the amount of runs you want to do and the data and their assertions from the excel sheet you configure as your source test data input. Keep in mind it needs to be the same format as the attached one alongside the repository. Each row is mapped to a test case, so you can add as many as you want with different expected results for the registration form.

Tl;dr overview of the whole framework:
Utils: package contain classes that setup the steering, reporting, and data entry.
Models: contain any classes needed to represent an object used in the framework of any kind
Tests: contain the tests that the maven test will run
PageObjects: contains classes representing webPages of the application and encapsulating all functionality related to that page in its own class.
The test cases import all what it needs and uses the page objects to steer automatically. 

Limitations:
1-	Need at least chrome version  77.0 for the included chrome driver to work

