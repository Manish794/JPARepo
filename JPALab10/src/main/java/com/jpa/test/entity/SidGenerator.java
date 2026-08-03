package com.jpa.test.entity;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

import java.util.List;

public class SidGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor session, Object entity) {
        System.out.println(entity);
        if(entity instanceof Student stud){
            StudentId sid = stud.getSid();
            String batch = sid.getBatch();
            Query query = session.createQuery("SELECT max(sid.id) from Student s where sid.batch=?1");
            query.setParameter(1,batch);

            List<Integer> ids = query.getResultList();
            if(ids !=null && ids.get(0)!=null){
                Integer id = ids.get(0);
                sid.setId(++id);
                return sid;
            }
            return StudentId.builder().batch(batch).id(1).build();
        }
       long time =  System.currentTimeMillis();
        System.out.println("Sid Generator executed "+time);
        return "S-"+time;
    }
}
