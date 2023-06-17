# OnlineEmployeeDirectory

•	Developed an Employee Directory Web Application in SpringBoot using Maven. Created REST Webservices to perform functionalities like adding, updating, deleting, searching employees Department wise.

• Leveraged the application by implementing user authentication and authorization using Spring Security.

•	Implemented the MVC model, by building the frontend using Thymeleaf. Used Spring Data JPA to connect to the MySQL Database.

• Written testcases using JUnit and Mockito to test the REST API endpoints before running on server.

• Deployed the entire application including the database on Heroku Cloud Platform.



Deploying application to Heroku Cloud:

A.Creating Database on Heroku Cloud
1. Create an account on Heroku Cloud.
2. Create an app called online-employee-directory in your account.
3. Go to resources and create a JawDB Database.
4. It will create credentials for you like hostname, username, password, port number.
5. Download HeidiSQL tool to connect to JawDB database.
6. Enter the credentials and connect to the JawDB Database (Created on amazon RDS)
7. Create your tables on the database.
8. Add the database credentials to your SpringBoot code in application.properties


B. Deploy the code WAR file on Heroku Cloud
1. Go to Heroku CLI
commands: 
2. mvn package
3. deploy:war target\OnlineEmployeeDirectory.war -a online-employee-directory

4. Then go the Heroku in your app and it will generate an URL for you and you can access your app from there.
