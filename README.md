this is a example of springboot api with java that
## Prerequisites :
- docker
- mongoDB
- mongo-express

## you are able :
- **GET**    -> get list of students that in database
- **POST**   -> register new student
- **PUT**    -> update student name or email
- **DELETE** -> delete a student by ID
*you are able to make filter for GET method*

## Database
Database is MongoDB
- Username : you can change it in `application.properties` *Default is `rootuser`*
- Password : you can change it in `application.properties` *Default is `rootpass`*
- default port `27017`

## server
- localhost:8080/swagger-ui.html#/  ->  *it includes GUI for using api's*
- localhost:8080/api

*Use postman or swagger url to GET, POST, PUT and DELETE*
