package com.example.JPAHibernateAdvancedMapping.course.servecies;

import com.example.JPAHibernateAdvancedMapping.course.dao.CourseRepo;
import com.example.JPAHibernateAdvancedMapping.course.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServicesImplemintation implements CourseServices {

    private final EntityManager entityManager;

    private final CourseRepo courseRepo;

    @Autowired
    public CourseServicesImplemintation(EntityManager entityManager, CourseRepo courseRepo) {
        this.entityManager = entityManager;
        this.courseRepo = courseRepo;
    }

    @Override
    public Course save(Course course) {

        return courseRepo.save(course);
    }

    @Override
    public Course findById(Integer id) {

        Course course = null;

        Optional<Course> dbCourse = courseRepo.findById(id);

        if (dbCourse.isPresent()) course = dbCourse.get();

        return course;
    }

    @Override
    public List<Course> findAllCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Course findCourseWithInstructorByCourseIdJoinFetch(Integer courseId) {
        try {
            TypedQuery<Course> query = entityManager.createQuery(
                    "select c from Course c " +
                            "JOIN FETCH c.instructor " +
                            "where c.id=:id", Course.class);


            query.setParameter("id", courseId);

            return query.getSingleResult();
        }catch (NoResultException e) {
            return findById(courseId);
        }

    }

    @Override
    public Course findCourseWithReviewsByCourseIdJoinFetch(Integer id) {
        try {
            TypedQuery<Course> query = entityManager.createQuery(
                    "select c from Course c " +
                            "JOIN FETCH c.reviews " +
                            "where c.id= :theId", Course.class);


            query.setParameter("theId", id);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return findById(id);
        }

    }

    @Override
    public void deleteCourse(Integer id) {

        Course dbCourse = findById(id);

        courseRepo.delete(dbCourse);
    }

    @Override
    public Course findCourseWithStudentsByIdJoinFetch(Integer id) {
        try {
            TypedQuery<Course> query = entityManager.createQuery(
                    "select c from Course c " +
                            "JOIN FETCH c.students " +
                            "where c.id=:id", Course.class);

            query.setParameter("id", id);

            return query.getSingleResult();
        }catch (NoResultException e) {
            return findById(id);
        }
    }

    @Override
    public void deleteAll() {

        courseRepo.deleteAll();
    }
}
