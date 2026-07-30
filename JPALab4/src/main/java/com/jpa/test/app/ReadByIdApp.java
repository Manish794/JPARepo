package com.jpa.test.app;

import com.jpa.test.entity.CurrentStudent;
import com.jpa.test.entity.OnlineStudent;
import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadByIdApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        Student st = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            st = entityManager.find(OnlineStudent.class,4);
            if(st == null){
                System.out.println("No Record Found");
            } else {
                System.out.println(st);
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
