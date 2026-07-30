package com.jpa.test.app;

import com.jpa.test.entity.CurrentStudent;
import com.jpa.test.entity.OnlineStudent;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OnlineStudentAddApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            OnlineStudent st = OnlineStudent.builder()
                    .name("DDD")
                    .email("d@xyz.com")
                    .session("2026-2027")
                    .timing("10:00 AM - 12:00 PM")
                    .joiningLink("http://abc.com")
                    .username("dd@user")
                    .password("dd@pass")
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
