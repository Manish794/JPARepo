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
            String batch = stud.getBatch();
            Query query = session.createQuery("SELECT max(id) from Student s where batch=?1");
            query.setParameter(1,batch);

            List<String> ids = query.getResultList();
            if(ids !=null && ids.get(0)!=null){
                String id = ids.get(0);
                int hyphenIndex = id.indexOf("-");
                String maxId = id.substring(hyphenIndex+1);
                long maxIdLong = Long.parseLong(maxId);
                return batch+"-"+ String.format("%03d",maxIdLong + 1);
            }
            return batch+"-001";
        }
       long time =  System.currentTimeMillis();
        System.out.println("Sid Generator executed "+time);
        return "S-"+time;
    }
}
