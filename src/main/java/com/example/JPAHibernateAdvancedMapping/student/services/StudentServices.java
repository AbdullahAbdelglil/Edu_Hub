package com.example.JPAHibernateAdvancedMapping.student.services;

import com.example.JPAHibernateAdvancedMapping.student.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface StudentServices {
    Student save(Student student);

    Student fidById(Integer id);

    List<Student> findAll();

    void delete(Integer id);

    void deleteAll();

    Student findStudentWithCoursesByIdJoinFetch(Integer id);
}
