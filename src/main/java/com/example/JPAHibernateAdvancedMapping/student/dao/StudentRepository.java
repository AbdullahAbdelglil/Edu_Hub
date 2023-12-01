package com.example.JPAHibernateAdvancedMapping.student.dao;

import com.example.JPAHibernateAdvancedMapping.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
