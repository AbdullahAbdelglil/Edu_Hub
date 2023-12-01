package com.example.JPAHibernateAdvancedMapping.student.controller;

import com.example.JPAHibernateAdvancedMapping.course.entity.Course;
import com.example.JPAHibernateAdvancedMapping.student.entity.Student;
import com.example.JPAHibernateAdvancedMapping.student.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiV3")
public class StudentController {
    private final StudentServices studentServices;

    @Autowired
    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){

        return studentServices.findAll();
    }

    @GetMapping("students/{studentId}")
    public Student findStudentById(@PathVariable("studentId")Integer studentId){

        return studentServices.fidById(studentId);
    }

    @GetMapping("students/{studentId}/courses")
    public List<Course> getStudentCourseByStudentId(@PathVariable("studentId")Integer studentId) {

        Student dbStudent = studentServices.findStudentWithCoursesByIdJoinFetch(studentId);

        return dbStudent.getCourses();
    }

    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student) {

        return studentServices.save(student);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentServices.save(student);
    }

    @DeleteMapping("/students")
    public void deleteAllStudents() {

        studentServices.deleteAll();
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId")Integer studentId) {

        studentServices.delete(studentId);
    }

}
