#README

##CRUD tests for Addressbook PHP.

###Used:

   * Maven
   * JUnit 5
   * Selenide
   * AssertJ
   * JDBC Template
   * Faker
   * Log4J2
   * Allure

Tests are being ran in parallel. You can run them in one stream by disabling a 'junit.jupiter.execution.parallel.enabled' parameter in JUnit config file.
Data is preparing by truncating 'addressbook' table in DB and adding a few records there.
Use Jenkinsfile for creating an example pipeline (you need to edit it with your own git repository link).

###@TODO

   * Add some tests for DB
   * Add more custom WebElements
   * Migrate SQL scripts into specific config file and create a class to use it


###Running tests
1. Download testable application here: https://sourceforge.net/projects/php-addressbook/

    Run it with Xampp server or something like that.

3. Run 'mvn clean test' for example