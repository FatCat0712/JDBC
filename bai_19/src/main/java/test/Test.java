package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Student;
import model.Teacher;
import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				Teacher t1 = new Teacher("GV01","Cao Tien Thanh",new Date(System.currentTimeMillis()),"He dieu hanh");
				Student s1 = new Student("SV01", "Mai Son Hai", new Date(System.currentTimeMillis()), 8.5);
				
				session.saveOrUpdate(t1);
				session.saveOrUpdate(s1);
				tr.commit();
			} finally {
				session.close();
			}
		}
		
	}
}
