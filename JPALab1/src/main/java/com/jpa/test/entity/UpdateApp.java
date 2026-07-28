package com.jpa.test.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UpdateApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Student st = entityManager.find(Student.class,103);
            if(st ==null){
                System.out.println("No Records found");
            } else {
                    System.out.println(st.getId()+"\t"+
                            st.getName()+"\t"+
                            st.getEmail()+"\t"+
                            st.getPhone()+"\t"+
                            st.getPassword()+"\t"+
                            st.getDoj());

                    st.setName("Rahul K");
                    st.setEmail("rahulr@abc.com");
                    entityManager.persist(st);
                    //entityManager.flush();
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
