package com.jpa.test.app;

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

            st = entityManager.find(Student.class,1);
            if(st == null){
                System.out.println("No Record Found");
            } else {
                System.out.println("Id "+st.getId()+"\t Name "+st.getName());
                System.out.println("*** Printing Phones");
                //System.out.println("Phones "+st.getPhones());
                System.out.println("*** Printing Emails");
                //System.out.println("Email "+st.getEmails());
                System.out.println("*** Printing Marks");
                System.out.println("Marks "+st.getMarks());
            }

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(entityTransaction != null){
                entityTransaction.rollback();
            }
        }


        System.out.println("Done");
        System.out.println("Emails:"+ st.getEmails());
        System.out.println("Marks:"+ st.getMarks());
        System.out.println("Phones:"+ st.getPhones());
    }
}
