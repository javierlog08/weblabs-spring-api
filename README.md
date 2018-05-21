
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
 
 **for us is required :**
 
 Setup one postgresql database on VM machine or in your own machine and create one empty database and called *api*. Once you do this automaticly our migration engine will
 fill the database with all necessary tables to start.
 
 **important: please always use latest postgres db version, for this Demo we are using postgresql version 9.5, cause uf you postgresdb is too old, then flyway will ask for comertial support**
  

 ## How to run
 
 To run the app you can do it *using Spring Tool Suite IDE* importing the project as maven project.
 
 Also you could run it by console with the tradional spring boot command
 
 ```
 # mvn spring-boot:run
 ```
 
 ## How to use
 
 You can see it in action on the browser to the url http://127.0.0.1:8080 (or whetever the port that spring is using to run the webapp)
 
 Default user and password is admin / admin.
 
 We recommend use this webservice with *curl* command
 
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
 
 ### Using with token based authentication
 We are using Spring Session version 1.3.3 in this project to enable  HttpSession Strategy that allow us enable Token based authentication,
 in this way you can control sessions from the server side and use a token that should expirates to get information from the server
 
 **Lets to see in action with curl command:***
 
 ```
 // When you authenticate with username and password you should see your token back
 # curl -v --user admin:admin http://127.0.0.1:8080/foo
 
 // You will see something like this as response
 
 < HTTP/1.1 200
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY
< x-auth-token: 17433234-6426-4a16-bb8b-3ba228835817
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 21 May 2018 03:40:31 GMT

// Then  if you want to use the current session , copy and paste the x-auth-token and use it with every request
# curl -v http://127.0.0.1:8080/foo -H "x-auth-token: 17433234-6426-4a16-bb8b-3ba228835817"

// The output will be
[{"id":1,"name":"bar"}]* Connection #0 to host 127.0.0.1 left intact
  
 ```
 
 With token based authentication you dont need to pass username and password with every request, and you can set expiration time from the server side in the application.properties file. just set spring.session.timeout.seconds=YOUR TIME IN SECONDS