package test;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Alien;
import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
		Alien a1 = new Alien();
		a1.setAid(101);
		a1.setName("Susan");
		a1.setColor("Green");
		
		Alien a2 = new Alien();
		a2.setAid(102);
		a2.setName("Cindy");
		a2.setColor("Brown");
		
		Alien a3 = new Alien();
		a3.setAid(103);
		a3.setName("Michelle");
		a3.setColor("Yellow");
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
				Session session1 = sessionFactory.openSession();
				Transaction tr1 = session1.beginTransaction();
//				session.save(a1);
//				session.save(a2);
//				session.save(a3);
				// First level cache -> Second level cache -> database
				Alien test = new Alien();
				//test = session1.load(Alien.class, 101);
				String hql = "FROM Alien WHERE aid=101";
				Query<Alien> query1 = session1.createQuery(hql,Alien.class);
				//save to cache
				query1.setCacheable(true);
				test = (Alien) query1.getSingleResult();
				System.out.println(test);
				tr1.commit();
				session1.close();
				
				
				Session session2 = sessionFactory.openSession();
				Transaction tr2 = session2.beginTransaction();
				Alien test2 = new Alien();
				//test2 = session2.load(Alien.class, 101);
				Query<Alien> query2 = session2.createQuery("FROM Alien WHERE aid=101",Alien.class);
				//fetch from cache
				query2.setCacheable(true);
				test2 = (Alien) query2.getSingleResult();
				System.out.println(test2);
				tr2.commit();
				session2.close();
				
		}
	}
}
