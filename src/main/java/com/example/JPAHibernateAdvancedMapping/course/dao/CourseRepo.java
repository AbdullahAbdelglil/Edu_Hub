package com.example.JPAHibernateAdvancedMapping.course.dao;

import com.example.JPAHibernateAdvancedMapping.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
