package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			//Tao doi tuong ServiceRegistry tu hibernate.cfg.xml
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			
			//Tao metadata tu serviceRegistry
			Metadata mtdt = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			
			return mtdt.getSessionFactoryBuilder().build();
		}
		catch (Throwable e) {
			System.out.println("Initial SessionFactory creation failed");
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		sessionFactory.close();
	}
}
