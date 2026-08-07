package com.jpa.test.app.jpql;

import com.jpa.test.entity.Employee;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class ReadByNamedParameterWithJPQL {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;

        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Query query = entityManager.createQuery("FROM Employee em where em.city=:cty and em.salary>:sal order by em.name ASC");
            query.setParameter("cty", "Blore");
            query.setParameter("sal", 25000);

            List<Employee> employees = query.getResultList();

            if(employees == null || employees.isEmpty()){
                System.out.println("No Record Found");
            } else {
                employees.forEach(System.out::println);
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
