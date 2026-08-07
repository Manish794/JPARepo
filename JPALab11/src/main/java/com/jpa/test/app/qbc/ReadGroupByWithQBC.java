package com.jpa.test.app.qbc;

import com.jpa.test.entity.Employee;
import com.jpa.test.entity.EmployeeGroupByData;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ReadGroupByWithQBC {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;

        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();


            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<EmployeeGroupByData> criteriaQuery =  criteriaBuilder.createQuery(EmployeeGroupByData.class);

            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery
                    .multiselect(
                                root.get("city"),
                                criteriaBuilder.count(root.get("salary")),
                                criteriaBuilder.sum(root.get("salary")));

            CriteriaBuilder.In inCondition = criteriaBuilder.in(root.get("city"));
            inCondition.value("Blore").value("Hyd");

            criteriaQuery
                    .groupBy(root.get("city"))
                    .having(inCondition);

            List<EmployeeGroupByData> employees = entityManager.createQuery(criteriaQuery).getResultList();

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
