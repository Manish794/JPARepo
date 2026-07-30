package com.jpa.test.app;

import com.jpa.test.entity.OldStudent;
import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OldStudentAddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            OldStudent st = OldStudent.builder()
                    .name("BBB")
                    .email("b@xyz.com")
                    .passingYear(2025)
                    .batchNo("B98")
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
