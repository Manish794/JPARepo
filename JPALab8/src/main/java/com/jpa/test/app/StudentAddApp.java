package com.jpa.test.app;

import com.jpa.test.entity.Course;
import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class StudentAddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createQuery("FROM Course c");
            List<Course> course = query.getResultList();

            Student st1 = Student.builder()
                    .name("Aadi")
                    .email("aadi@xyz.com")
                    .phone(87878787L)
                    .courses(List.of(course.get(1),course.get(2)))
                    .build();

            entityManager.persist(st1);

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
        }
    }
}
