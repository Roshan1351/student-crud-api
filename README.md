# Student Management REST API

A RESTful Student Management System built using Java Spring Boot. The application provides CRUD operations, search functionality, pagination, and dashboard statistics. Data is persisted using Spring Data JPA (Hibernate) with MySQL as the database.

## 🚀 Features

* Create a new student
* Retrieve all students
* Retrieve a student by ID
* Update student details
* Delete a student by ID
* Dashboard statistics
* Search students by first name
* Count total students
* Get students by class name
* Pagination support
* Input validation using Jakarta Validation
* API testing with Postman

## 🛠 Tech Stack

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Build Tool

* Maven

### API & Validation

* REST APIs
* Jakarta Bean Validation

### Testing Tools

* Postman

## 📌 API Endpoints

| Method | Endpoint                        | Description                   |
| ------ | ------------------------------- | ----------------------------- |
| GET    | /api/students                   | Get all students              |
| GET    | /api/students/{id}              | Get student by ID             |
| POST   | /api/students                   | Create a student              |
| PUT    | /api/students/{id}              | Update a student              |
| DELETE | /api/students/{id}              | Delete a student              |
| GET    | /api/students/search?name=      | Search students by first name |
| GET    | /api/students/class/{className} | Get students by class         |
| GET    | /api/students/count             | Get total student count       |
| GET    | /api/students/dashboard         | Dashboard statistics          |

## 📈 Future Enhancements

* Spring Security
* Role-Based Access Control (Admin, Teacher, Student)
* OAuth2 and JWT Supports and Security
* Marks Management
* Swagger/OpenAPI Documentation

## 👨‍💻 Author

Roshan Giri
