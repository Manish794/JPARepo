package com.jpa.test.app;

import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Student st = Student.builder()
                    .name("Aadi")
                    .emails(List.of("aadi@abc.com","aadi@sms.com","aadi@xyz.com"))
                    .phones(Set.of(22222222L,989898102L))
                    .marks(Map.of("Java",67,"JPA",98,"Spring",95))
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
