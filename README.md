
# Weblabs REST API Starter

This project was created to use as rest API component for welabs company projects.
This stater template includes:
 * Spring Web MVC Features
 * Spring Security and custom authentication using postgres db
 * Postgresql DB compatibility
 * Migrations using Flyway
 * Spring JPA repositories
 
 
 ## How to setup
 
 We asumme you know how to use spring frameworks and spring boot and also that this implies that you need to install maven and all that stuff.
 
 ** for us is required :**
 
 Setup one postgresql database on VM machine or in your own machine and create one empty database and called *api*. Once you do this automaticly our migration engine will
 fill the database with all necessary tables to start.
 
 ** important: please always use latest postgres db version, for this Demo we are using postgresql version 9.5, cause uf you postgresdb is too old, then flyway will ask for comertial support**
  

 ## How to run
 
 To run the app you can do it *using Spring Tool Suite IDE* importing the project as maven project.
 
 Also you could run it by console with the tradional spring boot command
 
 ```
 # mvn spring-boot:run
 ```
 
 ## See in action
 
 You can test it or see it in action using  accesing on the browser to the url http://127.0.0.1:port 
 
 We recommend test this webservice using *curl* command
 
 ```
  // If you do
  # curl http://127.0.0.1:8080
  
  // the output will be
  # Welcome to API Base project. 
  
  // If you want to see data extracted from the database through repositories you need to authenticate
  # curl --user admin:admin http://127.0.0.1:8080/foo
  
  // the output will be
  # [{"id":1,"name":"bar"}]
 ```