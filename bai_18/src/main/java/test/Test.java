package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Employee;
import model.Meeting;
import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				Employee e1 = new Employee("NV1","nhan vien 1",new Date(System.currentTimeMillis()));
				Employee e2 = new Employee("NV2","nhan vien 2", new Date(System.currentTimeMillis()));
				Meeting m1 = new Meeting(1,"Hop co dong",Date.valueOf("2025-07-12"),"Ha Do Group");
				
				m1.addEmployee(e1);
				m1.addEmployee(e2);
				
				
				Employee e3 = new Employee("NV3","nhan vien 3", new Date(System.currentTimeMillis()));
				
				Meeting m2 = new Meeting(2,"Hop hoi dong quan tri",new Date(System.currentTimeMillis()),"Cappela Holdings");
				m2.addEmployee(e2);
				m2.addEmployee(e1);
				m1.addEmployee(e3);
				session.save(m2);
				tr.commit();
			} finally {
				session.close();
			}
		}
	}
}
