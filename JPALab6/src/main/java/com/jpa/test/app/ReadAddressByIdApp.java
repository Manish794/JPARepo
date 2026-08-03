package com.jpa.test.app;

import com.jpa.test.entity.Address;
import com.jpa.test.entity.Student;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ReadAddressByIdApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        Address add = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            add = entityManager.find(Address.class,1);
            if(add == null){
                System.out.println("No Record Found");
            } else {
                System.out.println(add.getAid()+"\t"+add.getStreet()+"\t"+add.getCity()+"\t"+add.getPin());
                System.out.println(add.getStudent());
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
