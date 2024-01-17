set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath% 
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAssertJ\*;;%ProjectPath%libAllure\*;%ProjectPath%libLog4J\*;%ProjectPath%libExtentV5\*;%ProjectPath%libReportNG\*;%ProjectPath%LibDriverManager\*;%ProjectPath%libSelenium\*;" org.testng.TestNG "%ProjectPath%bin\runNopCommerceUser.xml"
allure serve .\allure-json\
pause