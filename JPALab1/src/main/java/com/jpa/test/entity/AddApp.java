package com.jpa.test.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.Base64;

public class AddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Student st = Student.builder()
                    .name("Rahul")
                    .email("rahul@abc.com")
                    .phone(98987878)
                    .password(Base64.getEncoder().encodeToString("rahul@11".getBytes()))
                    .doj(LocalDate.now())
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
