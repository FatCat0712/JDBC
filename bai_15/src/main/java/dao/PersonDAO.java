package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Person;
import util.HibernateUtils;

public class PersonDAO implements DAO<Person> {
	public static PersonDAO getInstance() {
		return new PersonDAO();
	}

	@Override
	public boolean insert(Person object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		try {
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					
					Transaction tr = session.beginTransaction();
					session.saveOrUpdate(object);
					tr.commit();
					
				} finally {
					session.close();
				}
				result = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(Person object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		try {
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					
					Transaction tr = session.beginTransaction();
					session.delete(object);
					tr.commit();
					
				}finally {
					session.close();
				}
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean update(Person object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		try {
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					
					Transaction tr = session.beginTransaction();
					session.saveOrUpdate(object);
					tr.commit();
					result = true;
				} finally {
					session.close();
				}	
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Person selectById(Person object) {
		Person p = null;
		List<Person> personList = new ArrayList<Person>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		try {
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					String hql = "FROM Person WHERE id=:id";
					Query query = session.createQuery(hql);
					query.setParameter("id", object.getId());
					personList = query.getResultList();
					tr.commit();
				} finally {
					session.close();
				}
				if(personList.size() > 0) {
					p = personList.get(0);
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Person> selectAll() {
		List<Person> personList = new ArrayList<Person>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		try {
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					String hql = "FROM Person";
					Query query = session.createQuery(hql);
					personList = query.getResultList();
				} finally {
					session.close();
				}	
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return personList;
	}
	
	public List<Object[]> getMarriageList(){
		List<Object[]> marriageList = new ArrayList<Object[]>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		try {
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction tr = session.beginTransaction();
					String hql = "SELECT p.name,p.id, p.spouse.name,p.spouse.id FROM Person p";
					Query query = session.createQuery(hql);
					marriageList = query.getResultList();
				} finally {
					session.close();
				}	
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return marriageList;
	}

}
