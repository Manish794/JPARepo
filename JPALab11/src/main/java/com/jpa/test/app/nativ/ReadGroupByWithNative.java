package com.jpa.test.app.nativ;

import com.jpa.test.entity.Employee;
import com.jpa.test.entity.EmployeeGroupByData;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.Arrays;
import java.util.List;

public class ReadGroupByWithNative {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;

        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            List<String> cities  = List.of("Blore","Hyd");

            Query query = entityManager.createNativeQuery(" select ecity,count(*) as 'count',sum(esalary) as 'totalsal' from myemployee group by ecity having ecity in (?1);", EmployeeGroupByData.class);
            query.setParameter(1, cities);

            List<EmployeeGroupByData> employees = query.getResultList();

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
