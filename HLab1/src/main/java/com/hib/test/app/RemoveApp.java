package com.hib.test.app;

import com.hib.test.entity.Student;
import com.hib.test.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class RemoveApp {
    public static void main(String[] args) {
        Transaction tx = null;
        try (SessionFactory factory = HibernateUtil.getSessionFactory();
             Session session  = factory.openSession()) {
            tx = session.beginTransaction();

            Student st = session.find(Student.class,5);
            if(st == null) {
                System.out.println("No Record Found");
            } else {
                System.out.println(st.getStudId() + "\t" + st.getStudentName() + "\t" + st.getEmail() + "\t" + st.getPhone() + "\t" + st.getPassword() + "\t" + st.getJoiningDate());
                session.remove(st);
            }
            tx.commit();
        }catch(Exception e) {
            e.printStackTrace();
            if(tx!=null)
                tx.rollback();
        }
    }
}
