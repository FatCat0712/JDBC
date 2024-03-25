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
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Alien a4 = null;
			a4 = session.load(Alien.class, 104);
			a4.setName("Christ");
			System.out.println(session.contains(a4));
			//Detach
			session.evict(a4);
			System.out.println(session.contains(a4));
			a4.setName("Eddie");
			//Detached to Persistent
			Alien a5 = (Alien)session.merge(a4);
			System.out.println(a5 == a4);
			
			session.getTransaction().commit();
		}
	}
}
