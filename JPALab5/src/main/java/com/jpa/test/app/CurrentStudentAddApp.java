package com.jpa.test.app;

import com.jpa.test.entity.CurrentStudent;
import com.jpa.test.entity.OldStudent;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CurrentStudentAddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            CurrentStudent st = CurrentStudent.builder()
                    .name("BBB")
                    .email("b@xyz.com")
                    .session("2025-2026")
                    .timing("9:00 AM - 11:00 AM")
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
