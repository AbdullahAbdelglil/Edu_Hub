# Edu_Hub API Documentation

## Base URL
- All endpoints are relative to the base URL: `http://localhost:8080`

## Authentication
- The API requires authentication. Include an Authorization header in your requests.

## Error Handling
- The API follows standard HTTP response codes.

## 1. Instructor API

### Get All Instructors
`GET /apiV1/instructors`

### Get Instructor by ID
`GET /apiV1/instructors/{id}`

### Get Instructor Detail by Instructor ID
`GET /apiV1/instructors/{id}/detail`

### Get List of Instructor Courses by Instructor ID
`GET /apiV1/instructors/{id}/courses`

### Add New Instructor
`POST /apiV1/instructors`

### Publish New Course
`PUT /apiV1/instructors/{id}/courses`

### Update Instructor
`PUT /apiV1/instructors`

### Update Instructor Detail
`PUT /apiV1/instructors/{id}/detail`

### Delete All Instructors
`DELETE /apiV1/instructors`

### Delete Individual Instructor by ID
`DELETE /apiV1/instructors/{id}`



## 2. Course API

### Get All Courses
`GET /apiV2/courses`

### Get Course by Course ID
`GET /apiV2/courses/{id}`

### Get Course Instructor by Course ID
`GET /apiV2/courses/{id}/instructor`

### Get Course Instructor Detail by Course ID
`GET /apiV2/courses/{id}/instructor/detail`

### Get All Reviews for This Course
`GET /apiV2/courses/{id}/reviews`

### Get All Students in This Course
`GET /apiV2/courses/{id}/students`

### Add New Course
`POST /apiV2/courses`

### Update Course
`PUT /apiV2/courses`

### Add An Instructor to the Course or Change an Existing One
`PUT /apiV2/courses/{id}/instructor`

### Add Review to Course
`POST /apiV2/courses/{id}/reviews`

### Delete Course by ID
`DELETE /apiV2/courses/{id}`

### Delete All Courses
`DELETE /apiV2/courses`


## 3. Student API 

### Get All Students
`GET /apiV3/students`

### Get Student by ID
`GET /apiV3/students/{id}`

### Get All Courses for the Student by Student ID
`GET /apiV3/students/{id}/courses`

### Add New Student
`POST /apiV3/students`

### Update Student
`PUT /apiV3/students/{id}`

### Delete Student
`DELETE /apiV3/students/{id}`

### Delete All Students
`DELETE /apiV3/students` 

