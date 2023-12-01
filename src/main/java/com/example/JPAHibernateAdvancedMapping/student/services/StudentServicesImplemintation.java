package com.example.JPAHibernateAdvancedMapping.student.services;

import com.example.JPAHibernateAdvancedMapping.student.dao.StudentRepository;
import com.example.JPAHibernateAdvancedMapping.student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImplemintation implements StudentServices{

    private final StudentRepository studentRepository;
    private final EntityManager entityManager;

    @Autowired
    public StudentServicesImplemintation(StudentRepository studentRepository, EntityManager entityManager) {
        this.studentRepository = studentRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student fidById(Integer id) {
        Student student = null;

        Optional<Student> dbStudent = studentRepository.findById(id);

        if(dbStudent.isPresent()) student=dbStudent.get();

        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {

        Student dbStudent = fidById(id);

        studentRepository.delete(dbStudent);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Student findStudentWithCoursesByIdJoinFetch(Integer id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "+
                    "JOIN FETCH s.courses "+
                    "where s.id= :id", Student.class);

        query.setParameter("id",id);

        return query.getSingleResult();
    }
}
