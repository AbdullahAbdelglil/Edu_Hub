package com.example.JPAHibernateAdvancedMapping.course.servecies;

import com.example.JPAHibernateAdvancedMapping.course.entity.Course;

import java.util.List;

public interface CourseServices {

    Course save(Course course);

    Course findById(Integer id);

    List<Course> findAllCourse();

    Course findCourseWithInstructorByCourseIdJoinFetch(Integer courseId);

    Course findCourseWithReviewsByCourseIdJoinFetch(Integer id);

    void deleteCourse(Integer id);

    Course findCourseWithStudentsByIdJoinFetch(Integer id);

    void deleteAll();
}
