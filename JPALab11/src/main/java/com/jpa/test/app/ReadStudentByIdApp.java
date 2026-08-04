package com.jpa.test.app;

import com.jpa.test.entity.Employee;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ReadStudentByIdApp {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;
        Employee emp = null;
        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            emp = entityManager.find(Employee.class,101);
            if(emp == null){
                System.out.println("No Record Found");
            } else {
                System.out.println(emp);
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
