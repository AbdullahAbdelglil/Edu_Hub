# Edu_Hub Project
EduHub is a comprehensive Educational Platform Management System developed using Spring Boot, Spring Data JPA, and Hibernate. This system facilitates the management of instructors, courses, and students within an educational center. The project utilizes advanced mapping features provided by Hibernate for efficient and flexible data handling.

![Java Badge](https://img.shields.io/badge/Java-17-blue)
![Spring Boot Badge](https://img.shields.io/badge/Spring%20Boot-3.1.3-brightgreen)
![MySQL Badge](https://img.shields.io/badge/MySQL-8.0-orange)
![IntelliJ Badge](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-red)
![Postman Badge](https://img.shields.io/badge/Testing%20Tool-Postman-orange)


## 🔴 Project Overview

Edu_Hub stands as an innovative educational platform, meticulously crafted using advanced Hibernate mappings alongside the robust Spring ecosystem, which encompasses Spring Boot, Spring Data JPA, and RESTful services.

The project revolves around five fundamental entities:

1. **Instructor**
2. **InstructorDetail**
3. **Course**
4. **CourseReview**
5. **Student**

In this well-architected system, the entities interconnect with precision, establishing meaningful relationships.

### ⚪ Instructor Entity

1. **InstructorDetail:** Establishes a one-to-one, bi-directional relationship.
2. **List of Courses:** Forms a many-to-one, bi-directional relationship.

### ⚪ Course Entity

1. **Instructor:** Defines a one-to-many, bi-directional relationship.
2. **List of Reviews:** Illustrates a many-to-one, uni-directional relationship.
3. **List of Students:** Exhibits a many-to-many, bi-directional relationship.

### ⚪ Student Entity

1. **List of Courses:** Demonstrates a many-to-many, bi-directional relationship.

## Application Features

Edu_Hub presents an intuitive set of APIs, ensuring a seamless user experience.

### 1. 🔴 Instructor API

- Retrieve all instructors
- Obtain instructor by ID
- Fetch instructor details by instructor ID
- Access the list of instructor courses by instructor ID
- Add a new instructor
- Publish a new course, and ink it to the instructor
- Update instructor information
- Update instructor details
- Delete all instructors
- Remove an individual instructor by ID

### 2. 🔴 Course API

- Retrieve all courses
- Obtain course by course ID
- Fetch course instructor by course ID
- Access course instructor details by course ID
- Retrieve all reviews for a specific course
- Retrieve all students in a course
- Add a new course
- Update course information
- Add a new instructor to the course or modify an existing one
- Add a review to the course
- Delete course by ID
- Delete all courses

### 3. 🔴 Student API

- Retrieve all students
- Obtain student by ID
- Retrieve all courses for a student by student ID
- Add a new student
- Update student information
- Delete a student
- Delete all students

## ⚪ Database

The project utilizes the robust MySQL database system. To set up the database, adhere to the following steps:

1. Create a MySQL database named `edu_hub`.
2. Configure the application properties file (`application.properties`) with the pertinent database connection details.

# Database Configuration
`spring.datasource.url=jdbc:mysql://localhost:3306/edu_hub`<br>
`spring.datasource.username=root`<br>
`spring.datasource.password=root`<br>
`spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver`<br>

# 🐱‍🏍 Getting Started

To launch the Edu_Hub application, undertake the following steps:

1. Clone the repository.
2. Configure the database as specified above.
3. Build and run the application through your chosen IDE or by executing the following command: `./mvnw spring-boot:run`

The application will be accessible at `http://localhost:8080`

## 📄 API Documintation

for comprehensive API documentation: go to API documentation directory in the directory tree


## 🤝 Contributing

We welcome contributions from the community. If you have ideas for improvements, bug fixes, or additional features, please follow these steps:

- Fork the repository.
- Create a branch for your feature or bug fix: `git checkout -b feature-name`.
- Make your changes and commit them with clear and concise commit messages.
- Push your changes to your forked repository.
- Create a pull request with a detailed description of your changes.

 
## ❤ feel free to contact with me: [LinkedIn](https://www.linkedin.com/in/abdullah-abduljalil-0b966b265/)
