package com.hib.test.app;

import com.hib.test.entity.Student;
import com.hib.test.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

public class InsertlApp {
    public static void main(String[] args) {
        Transaction tx = null;
        try (SessionFactory factory = HibernateUtil.getSessionFactory();
             Session session  = factory.openSession()) {
            tx = session.beginTransaction();

            Student student = Student.builder()
                    .studentName("Gaurav")
                    .email("gaurav@abc.com")
                    .phone(87878989)
                    .joiningDate(LocalDate.now())
                    .password(Base64.getEncoder().encodeToString("guarav@111".getBytes()))
                    .build();

            session.persist(student);

            tx.commit();
        }catch(Exception e) {
            e.printStackTrace();
            if(tx!=null)
                tx.rollback();
        }
    }
}
