package com.jpa.test.app;

import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ReadStudentByIdApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        Student st = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            st = entityManager.find(Student.class,1);
            if(st == null){
                System.out.println("No Record Found");
            } else {
                System.out.println(st.getId()+"\t"+st.getName()+"\t"+st.getEmail()+"\t"+st.getPhone());
                System.out.println(st.getAddress());
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
