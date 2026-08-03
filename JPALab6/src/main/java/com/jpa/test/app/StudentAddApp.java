package com.jpa.test.app;

import com.jpa.test.entity.Address;
import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentAddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Student st = Student.builder()
                    .name("CCC")
                    .email("c@xyz.com")
                    .phone(78765676L)

                    .build();

            entityManager.persist(st);

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
        }
    }
}
