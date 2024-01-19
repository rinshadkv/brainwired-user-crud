
# Project Title

User CRUD Application
This is a simple CRUD (Create, Read, Update, Delete) application for managing user data. It provides RESTful APIs to perform these operations on user entities.

Technologies Used
Spring Boot: A powerful framework for building Java-based enterprise applications.

Spring Data JPA: Simplifies database access using the Java Persistence API (JPA).

SQLite: A lightweight, file-based relational database engine.

Prerequisites
Before you begin, ensure you have the following installed on your machine:

Java (version 21 )
Gradle (for building the project)
Getting Started
Clone the Repository:

bash
Copy code
git clone https://github.com/your-username/user-crud.git
cd user-crud
Run the Application:
./gradlew bootRun

The application will start at http://localhost:8080.

Configuration
The application is configured to use an SQLite database. You can customize the database settings in the application.properties file.

properties
Copy code
# DataSource Configuration
spring.datasource.driver-class-name=org.sqlite.JDBC
spring.datasource.url=jdbc:sqlite::file:/path/to/your/database
spring.datasource.username=root
spring.datasource.password=root

# JPA and Hibernate Configuration
spring.jpa.database-platform=org.hibernate.dialect.SQLiteDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
API Endpoints
Create User:

Method: POST
URL: /api/v1/users
Payload Example:
json
Copy code
`{
"firstName": "John",
"lastName": "Doe",
"dob": "1990-05-15",
"address": "calicut University road "
}`
Update User:

Method: PUT
URL: **/api/v1/users/{id}**
Payload Example:

json
Copy code

`{
"id": 1,
"firstName": "UpdatedJohn",
"lastName": "UpdatedDoe",
"dob": "1990-05-15",
"address": "calicut University road "
}
`
Get All Users:

Method: GET
URL: /api/v1/users
Get One User:

Method: GET
URL: /api/v1/users/{id}
Delete User:

Method: DELETE
URL: /api/v1/users/{id}


