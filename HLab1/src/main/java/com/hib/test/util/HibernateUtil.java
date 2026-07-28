package com.hib.test.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static StandardServiceRegistry registry = null;
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static final SessionFactory buildSessionFactory() {
		try {
			registry = new StandardServiceRegistryBuilder().configure().build();
			MetadataSources metadataSource = new MetadataSources(registry);
			Metadata metadata = metadataSource.getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		if (null != registry)
			StandardServiceRegistryBuilder.destroy(registry);
	}

}
