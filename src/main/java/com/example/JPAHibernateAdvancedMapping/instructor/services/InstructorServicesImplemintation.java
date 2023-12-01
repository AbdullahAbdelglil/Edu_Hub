package com.example.JPAHibernateAdvancedMapping.instructor.services;

import com.example.JPAHibernateAdvancedMapping.course.entity.Course;
import com.example.JPAHibernateAdvancedMapping.instructor.dao.InstructorRepository;
import com.example.JPAHibernateAdvancedMapping.instructor.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class InstructorServicesImplemintation implements InstructorServices {

    private final InstructorRepository instructorRepository;
    private final EntityManager entityManager;

    @Autowired
    public InstructorServicesImplemintation(InstructorRepository instructorRepository, EntityManager entityManager) {
        this.instructorRepository = instructorRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findByID(Integer id) {

        Instructor theInstructor = null;

        Optional<Instructor> dbInstructor = instructorRepository.findById(id);

        if (dbInstructor.isPresent()) theInstructor = dbInstructor.get();

        return theInstructor;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public void delete(Integer id) {

        Instructor dbInstructor = findInstructorByIdJoinFetch(id);

        List<Course> courses = dbInstructor.getCourses();

        for (Course course : courses) course.setInstructor(null);

        instructorRepository.delete(dbInstructor);
    }

    @Override
    public void deleteAll() {
        instructorRepository.deleteAll();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Integer id) {

        try {
            TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " +
                    "JOIN FETCH i.courses " +
                    "JOIN FETCH i.instructorDetail " +
                    "where i.id = :theId", Instructor.class);

            query.setParameter("theId", id);

            return query.getSingleResult();

        } catch (NoResultException e) {
            return findByID(id);
        }
        catch(RuntimeException e) {
            return null;
        }

    }

}

