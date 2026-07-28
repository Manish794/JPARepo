package com.hib.test.app;

import com.hib.test.entity.Student;
import com.hib.test.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SelectByEmailApp {
    public static void main(String[] args) {
        Transaction tx = null;
        try (SessionFactory factory = HibernateUtil.getSessionFactory();
             Session session  = factory.getCurrentSession()) {
            tx = session.beginTransaction();

            Query<Student> query = session.createQuery("from Student where email=?1", Student.class);
            query.setParameter(1,"yug@sms.com");

            List<Student> students = query.list();
            for (Student st : students) {
                System.out.println(st.getStudId()+"\t"+st.getStudentName()+"\t"+st.getEmail()+"\t"+st.getPhone()+"\t"+st.getPassword()+"\t"+st.getJoiningDate());
            }

            tx.commit();
        }catch(Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }
}
