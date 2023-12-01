package com.example.JPAHibernateAdvancedMapping.instructor.controller;

import com.example.JPAHibernateAdvancedMapping.course.entity.Course;
import com.example.JPAHibernateAdvancedMapping.instructor.entity.Instructor;
import com.example.JPAHibernateAdvancedMapping.instructor.services.InstructorServices;
import com.example.JPAHibernateAdvancedMapping.instructor.instructordetail.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiV1")
public class InstructorController {

    private final InstructorServices instructorServices;

    @Autowired
    public InstructorController(InstructorServices instructorServices) {

        this.instructorServices = instructorServices;
    }

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors() {

        return instructorServices.findAll();
    }

    @GetMapping("/instructors/{instructorId}")
    public Instructor getInstructorById(@PathVariable("instructorId") Integer instructorId) {

        return instructorServices.findByID(instructorId);
    }

    @GetMapping("/instructors/{instructorId}/detail")
    public InstructorDetail getInstructorDetailByInstructorId(@PathVariable("instructorId") Integer instructorId) {

        return instructorServices.findByID(instructorId).getInstructorDetail();
    }

    @GetMapping("/instructors/{instructorId}/courses")
    public List<Course> getInstructorCoursesByInstructorId(@PathVariable("instructorId") Integer instructorId) {

        Instructor dbInstructor = instructorServices.findInstructorByIdJoinFetch(instructorId);

        return dbInstructor.getCourses();
    }

    @PostMapping("/instructors")
    public Instructor addInstructor(@RequestBody Instructor instructor) {

        return instructorServices.save(instructor);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {

        return instructorServices.save(instructor);
    }

    @PutMapping("/instructors/{instructorId}/detail")
    public Instructor updateInstructorDetail(@PathVariable("instructorId") Integer instructorId,
                                             @RequestBody InstructorDetail instructorDetail) {

        Instructor dbInstructor = instructorServices.findByID(instructorId);

        dbInstructor.setInstructorDetail(instructorDetail);

        return instructorServices.save(dbInstructor);
    }

    @PutMapping("/instructors/{instructorId}/courses")
    public Instructor publishNewCourse(@PathVariable("instructorId") Integer instructorId,
                                              @RequestBody Course course) {

        Instructor dbInstructor = instructorServices.findByID(instructorId);

        dbInstructor.addCourse(course);

        return instructorServices.save(dbInstructor);
    }

    @DeleteMapping("/instructors")
    public void deleteAllInstructors() {

        instructorServices.deleteAll();
    }

    @DeleteMapping("/instructors/{instructorId}")
    public String deleteInstructor(@PathVariable("instructorId") Integer instructorId) {

        instructorServices.delete(instructorId);

        return "Successfully deleted id: "+instructorId;
    }
}
