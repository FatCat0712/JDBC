package net.sonhai.bai_15;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Person;
import util.HibernateUtils;

public class Test2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		try {
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					Person p1 = session.load(Person.class, 1);
//					Person p1 = new Person("Nguyen Van A",new Date(System.currentTimeMillis()),null);
					Person p2 = new Person("Tran Thi C",new Date(System.currentTimeMillis()),p1);
					p1.setSpouse(p2);
				
					session.saveOrUpdate(p2);
					tr.commit();
				} finally {
					session.close();
				}
			}
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
