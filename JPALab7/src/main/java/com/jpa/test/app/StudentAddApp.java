package com.jpa.test.app;

import com.jpa.test.entity.Address;
import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class StudentAddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Student st = Student.builder()
                    .name("Yug")
                    .email("yug@xyz.com")
                    .phone(87878787L)
                    .build();

            entityManager.persist(st);


            Address ad1 = Address.builder()
                    .street("Street1").city("BLR")
                    .pin(560001)
                    .student(st)
                    .build();
            Address ad2 = Address.builder()
                    .street("Street2").city("Hyd").pin(234567)
                    .student(st)
                    .build();
            entityManager.persist(ad1);
            entityManager.persist(ad2);

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
        }
    }
}
