package com.example.JPAHibernateAdvancedMapping.instructor.dao;

import com.example.JPAHibernateAdvancedMapping.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

}
