package com.jpa.test.app;

import com.jpa.test.entity.Course;
import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CourseAddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Course course1 = Course.builder()
                            .name("Java")
                            .duration("2 Months")
                            .fee(25000).
                    build();

            entityManager.persist(course1);
            Course course2 = Course.builder()
                    .name("JPA")
                    .duration("7 Days")
                    .fee(15000).
                    build();
            entityManager.persist(course2);

            Course course3 = Course.builder()
                    .name("Spring")
                    .duration("15 Days")
                    .fee(35000).
                    build();
            entityManager.persist(course3);

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
        }
    }
}
