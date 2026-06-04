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
* Role Based Access(Teacher/Admin)
* Registration for Teacher/Admin with Role

## 🛠 Tech Stack

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Spring Security
* Role Based Access Control(RBAC)
* Lombok

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

| Method | Endpoint                        | Description                   | Access By
| ------ | ------------------------------- | ----------------------------- | ---------------------
| GET    | /api/students                   | Get all students              | Teacher/Admin
| GET    | /api/students/{id}              | Get student by ID             | Teacher/Admin
| POST   | /api/students/create            | Create a student              | Admin
| PUT    | /api/students/update/{id}       | Update a student              | Admin
| DELETE | /api/students/delete/{id}       | Delete a student              | Admin
| GET    | /api/students/search/name       | Search students by first name | Teacher/Admin
| GET    | /api/students/class/{className} | Get students by class         | Admin
| GET    | /api/students/count             | Get total student count       | Admin
| GET    | /api/dashboard                  | Dashboard statistics          | Admin
| Post   | /api/user/register              | Register user with role(teacher/admin)| Public

## 📈 Future Enhancements

* OAuth2 and JWT Supports and Security
* Marks Management
* Swagger/OpenAPI Documentation

## 👨‍💻 Author

Roshan Giri
