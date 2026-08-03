package com.jpa.test.app;

import com.jpa.test.entity.Student;
import com.jpa.test.entity.StudentId;
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

            Student st1 = Student.builder()
                    .name("Rahul")
                    .email("rahul@xyz.com")
                    .phone(78541236L)
                    .sid(
                            StudentId.builder().batch("B2").build()
                    )
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
