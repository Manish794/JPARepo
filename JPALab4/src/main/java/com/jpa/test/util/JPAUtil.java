package com.jpa.test.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    // Application-Manage

    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("JPALabPersistence");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
