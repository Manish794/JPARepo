package com.jpa.test.app.qbc;

import com.jpa.test.entity.Employee;
import com.jpa.test.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ReadByConditionWithQBC {
    public static void main(String[] args) {
        EntityTransaction entityTransaction = null;

        try(EntityManager entityManager = JPAUtil.getEntityManager()){
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();


            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Employee> criteriaQuery =  criteriaBuilder.createQuery(Employee.class);

            Root<Employee> root = criteriaQuery.from(Employee.class);
            criteriaQuery.select(root);

            Predicate cityPredicate = criteriaBuilder.equal(root.get("city"), "Blore");
            Predicate salaryPredicate = criteriaBuilder.greaterThan(root.get("salary"), 25000);

            Predicate cityAndSalary = criteriaBuilder.and(cityPredicate, salaryPredicate);
            criteriaQuery
                    .where(cityAndSalary)
                    .orderBy(criteriaBuilder.asc(root.get("name")));


            List<Employee> employees = entityManager.createQuery(criteriaQuery).getResultList();

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
