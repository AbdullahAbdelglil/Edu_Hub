package com.example.JPAHibernateAdvancedMapping.instructor.instructordetail.dao;

import com.example.JPAHibernateAdvancedMapping.instructor.instructordetail.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {
    InstructorDetail findInstructorDetailById(Integer id);
}
