package com.jpa.test.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class ReadAllApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query jpaQuery = entityManager.createQuery("FROM Student st");
            List<Student> students = jpaQuery.getResultList();
            if(students ==null || students.isEmpty()){
                System.out.println("No Records found");
            } else {
                for (Student st : students) {
                    System.out.println(st.getId()+"\t"+
                            st.getName()+"\t"+
                            st.getEmail()+"\t"+
                            st.getPhone()+"\t"+
                            st.getPassword()+"\t"+
                            st.getDoj());
                }
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
