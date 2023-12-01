package com.example.JPAHibernateAdvancedMapping.course.controller;

import com.example.JPAHibernateAdvancedMapping.course.entity.Course;
import com.example.JPAHibernateAdvancedMapping.course.entity.Review;
import com.example.JPAHibernateAdvancedMapping.course.servecies.CourseServices;
import com.example.JPAHibernateAdvancedMapping.instructor.entity.Instructor;
import com.example.JPAHibernateAdvancedMapping.instructor.instructordetail.entity.InstructorDetail;
import com.example.JPAHibernateAdvancedMapping.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiV2")
public class CourseController {
    private final CourseServices courseServices;

    @Autowired
    public CourseController(CourseServices courseServices) {

        this.courseServices = courseServices;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {

        return courseServices.findAllCourse();
    }

    @GetMapping("/courses/{courseId}")
    public Course findCourseById(@PathVariable("courseId") Integer courseId) {

        return courseServices.findById(courseId);
    }

    @GetMapping("courses/{courseId}/instructor")
    public Instructor findCourseInstructorByCourseId(@PathVariable("courseId") Integer courseId) {

        Course dbCourse = courseServices.findCourseWithInstructorByCourseIdJoinFetch(courseId);

        return dbCourse.getInstructor();
    }

    @GetMapping("courses/{courseId}/instructor/detail")
    public InstructorDetail findCourseInstructorDetailByCourseId(@PathVariable("courseId") Integer courseId) {

        Course dbCourse = courseServices.findCourseWithInstructorByCourseIdJoinFetch(courseId);

        return dbCourse.getInstructor().getInstructorDetail();
    }

    @GetMapping("/courses/{courseId}/reviews")
    public List<Review> findCourseReviewsByCourseId(@PathVariable("courseId") Integer courseId) {

        Course dbCourse = courseServices.findCourseWithReviewsByCourseIdJoinFetch(courseId);

        return dbCourse.getReviews();
    }

    @GetMapping("/courses/{courseId}/students")
    public List<Student> findCourseStudentsByCourseIdJoinFetch(@PathVariable("courseId") Integer courseId){

        Course dbCourse = courseServices.findCourseWithStudentsByIdJoinFetch(courseId);

        return dbCourse.getStudents();
    }

    @PostMapping("/courses")
    public Course saveNewCourse(@RequestBody Course course) {

        return courseServices.save(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {

        return courseServices.save(course);
    }

    @PutMapping("courses/{courseId}/instructor")
    public Course updateCourseInstructor(@PathVariable("courseId") Integer courseId,
                                         @RequestBody Instructor newInstructor) {

        Course dbCourse = courseServices.findById(courseId);

        dbCourse.setInstructor(newInstructor);

        newInstructor.addCourse(dbCourse);

        return courseServices.save(dbCourse);
    }

    @PutMapping("courses/{courseId}/student")
    public Course addNewStudentToTheCourse(@PathVariable("courseId") Integer courseId,
                                            @RequestBody Student student){

        Course dbCourse = courseServices.findCourseWithStudentsByIdJoinFetch(courseId);

        dbCourse.addStudent(student);

        return courseServices.save(dbCourse);
    }

    @PutMapping("courses/{courseId}/review")
    public Course addNewReviewtToTheCourse(@PathVariable("courseId") Integer courseId,
                                           @RequestBody Review review){

        Course dbCourse = courseServices.findCourseWithReviewsByCourseIdJoinFetch(courseId);

        dbCourse.addReview(review);

        return courseServices.save(dbCourse);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") Integer id) {

        courseServices.deleteCourse(id);
    }

    @DeleteMapping("/courses")
    public void deleteAllCourses() {

        courseServices.deleteAll();
    }

}
