********************************************************************
Web Application URL
********************************************************************
http://localhost:9090/ OR
http://localhost:9090/login


********************************************************************
Web Application login credentials
********************************************************************
username = admin
password = password

********************************************************************
H2 database details
********************************************************************
JDBC URL = jdbc:h2:mem:test
DB user interface console = http://localhost:9090/dbconsole

********************************************************************
Application setup
********************************************************************
1. Unzip or load the code from Git repo (https://github.com/naimtamboli/nst_repo.git) and run "mvn install" command.
2. Run the UserApplication.java with "Run as java application" option.
3. Open the DB UI console with above mentioned URL and run the commands in 'data.sql' file. Note that CREATE command needs to be run only once intially and to be commented after that.
4. Access the app login page with the above mentioned app URL.

********************************************************************
Application Deliveries
********************************************************************
1. Spring MVC application with CRUD rest apis.
2. Spring security with basic authentication for all rest apis through web application. POSTMAN rest apis not secured.
3. H2 in memory database with hibernate dialect.

********************************************************************
Coding standards not implemented for this exercise
********************************************************************
1. Loggers
2. Interface/Impl implementations for service and dao layers.
3. Form validations for UI
4. Page redirection after update and delete user calls. So after update and delete operations navigate to '/user' url