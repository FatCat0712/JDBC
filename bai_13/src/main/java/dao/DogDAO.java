package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import model.Dog;
import util.HibernateUtil;

public class DogDAO implements DAO<Dog>{

	public static DogDAO getInstance() {
		return new DogDAO();
	}
	@Override
	public boolean insert(Dog object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				session.saveOrUpdate(object);
				tr.commit();
				result = true;
			}finally {
				session.close();
			}
		}
		return result;
	}

	@Override
	public boolean delete(Dog object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				session.delete(object);
				tr.commit();
				result = true;
			}finally {
				session.close();
			}
		}
		return result;
	}

	@Override
	public boolean update(Dog object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				session.saveOrUpdate(object);
				tr.commit();
				result = true;
			}
			finally {
				session.close();
			}
		}
		return result;
	}

	@Override
	public ArrayList<Dog> selectAll() {
		List<Dog> dogList = new ArrayList<Dog>();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Dog";
				Query query = session.createQuery(hql);
				dogList = query.getResultList();
				tr.commit();
			}finally {
				session.close();
			}
		}
		return (ArrayList<Dog>) dogList;
	}

	@Override
	public Dog selectById(Dog object) {
		Dog d = null;
		List<Dog> list = new ArrayList();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Dog WHERE id=:dog_id";
				Query query = session.createQuery(hql);
				query.setParameter("dog_id", object.getId());
				list = query.getResultList();
				tr.commit();
			}
			finally {
				session.close();
			}
			if(list.size() > 0) {
				d = list.get(0);
			}
		}
		return d;
	}

}
