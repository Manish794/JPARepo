package com.jpa.test.app;

import com.jpa.test.entity.Course;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ReadCourseByIdApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        Course cou = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            cou = entityManager.find(Course.class,2);
            if(cou == null){
                System.out.println("No Record Found");
            } else {
                System.out.println(cou);
                System.out.println(cou.getStudents());
            }

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
        }



    }
}
