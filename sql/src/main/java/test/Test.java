package test;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Criteria;
import model.Student;
import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Random rd = new Random();
		if(sessionFactory != null) {
//			Session session1 = sessionFactory.openSession();
//			session1.beginTransaction();
//			for(int i = 1; i <= 500; i++) {
//				Student s = new Student();
//				s.setRollno(i);
//				s.setName("Number "+i);
//				int marks = rd.nextInt(100)+1;
//				s.setMarks(marks);
//				session1.save(s);
//				
//			}
//			Student s1 = null;
//			s1 = session1.load(Student.class, 7);
//			String hql1 = "FROM Student WHERE rollno=7";
//			s1 = (Student)session1.createQuery(hql1).setCacheable(true).getSingleResult();
//			System.out.println(s1);
//			session1.getTransaction().commit();
//			session1.close();
			
//			Session session2 = sessionFactory.openSession();
//			session2.beginTransaction();
//			Student s2 = null;
//			s2 = session2.load(Student.class, 7);
//			String hql2 = "FROM Student WHERE rollno=7";
//			s2 = (Student)session2.createQuery(hql2).setCacheable(true).getSingleResult();
//			System.out.println(s2);
//			session2.getTransaction().commit();
//			session2.close();
			
//			Session session3 = sessionFactory.openSession();
//			session3.beginTransaction();
//			String hql = "SELECT SUM(marks) FROM Student WHERE rollno=7";
//			List<Student> studentList = session3.createQuery(hql).list();
//			for(Student s : studentList) {
//				System.out.println(s);
//			}
//			List<Object[]> students = session3.createQuery(hql).getResultList();
//			for(Object[] o: students) {
//				System.out.println(o[0] + " - " + o[1]);
//			}
//			 marks = (Long)session3.createQuery(hql).getSingleResult();
//			System.out.println(marks);
//			session3.getTransaction().commit();
//			session3.close();
//			sessionFactory.close();
			
			
			Session session4 = sessionFactory.openSession();
			session4.beginTransaction();
			String sql = "SELECT name,marks FROM tbl_student WHERE marks > 60";
//			Query<Student> query = session4.createNativeQuery(sql,Student.class);
//			List<Student> students = query.getResultList();
			
			
			//Native Query
			Query query = session4.createNativeQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List<Object> studentList = query.getResultList();
			for(Object o: studentList) {
				Map<String, Integer> m = (Map)o;
				System.out.println(m.get("name")+" - "+m.get("marks"));
				
			}
			session4.getTransaction().commit();
			sessionFactory.close();
			
			
			
			
			
			
		}
	}
}
