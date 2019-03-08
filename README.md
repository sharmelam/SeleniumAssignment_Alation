# SeleniumAssignment_Alation

Selenium Project which automates the Amazon website for searching a book and get the book details.
Scenario1:
Search Product with "data Catalog" keyword
Select the first result and go to the Product details page
Get the Product details

Scenario1:
Search Product with "data Catalog" keyword
Select the specific result based on the appropriate product name and go to product details page
Get the Product details

## Installation

Use the Eclipe IDE
The Selenium JAR Files are already included in the Project (\AlationAssignment\src\JarFiles)

#Packages:
com.alation.library - Contains the Classes & Methods that are in common for a Selenium Project. Input for the Selenium project is given here.
com.alation.locators - contains the Locators details of the Amazon application in page wise.
com.alation.testcase - contains the methods to perform actions specific to amazon app.
com.alation.testsuite - here is where the actual junit tests are available

/src/JarFiles - Folder that contains the JAR files that are needed for the project.
Drivers - Folder where the Chromedriver & Geckodriver exe files are available.
Results - Folder where the Product details are captured in txt file.

## Execution
1.Import the Project to Eclipse.
2.Run as Junit Test.
Once the Execution is over, kindly check the Results folder for the txt file.
Execution Results can be exported from Junit Runner 

