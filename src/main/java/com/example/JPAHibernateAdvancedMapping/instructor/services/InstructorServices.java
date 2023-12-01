package com.example.JPAHibernateAdvancedMapping.instructor.services;

import com.example.JPAHibernateAdvancedMapping.course.entity.Course;
import com.example.JPAHibernateAdvancedMapping.instructor.entity.Instructor;

import java.util.List;

public interface InstructorServices {

    Instructor save(Instructor instructor);

    Instructor findByID(Integer id);

    public List<Instructor> findAll();

    void delete(Integer Id);

    void deleteAll();

    Instructor findInstructorByIdJoinFetch(Integer id) ;
}
