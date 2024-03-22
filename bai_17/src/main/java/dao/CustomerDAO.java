package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.Order;
import util.HibernateUtils;

public class CustomerDAO implements DAO<Customer>{
	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}

	@Override
	public boolean insert(Customer object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
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
	public int delete(Customer object) {
		int result = 0;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "DELETE FROM Customer WHERE id=:customer_id";
				Query query = session.createQuery(hql);
				query.setParameter("customer_id", object.getId());
				result = query.executeUpdate();
				tr.commit();
				System.out.println(result + " rows affected");
			} finally {
				session.close();
			}
		}
		return result;
	}

	@Override
	public int update(Customer object) {
		int result = 0;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "UPDATE Customer SET name=:n, email=:e WHERE id=:customer_id";
				Query query = session.createQuery(hql);
				query.setParameter("n", object.getName());
				query.setParameter("e", object.getEmail());
				query.setParameter("customer_id", object.getId());
				result = query.executeUpdate();
				tr.commit();
				System.out.println(result+" rows affected");
			}finally {
				session.close();
			}
		}
		return result;
	}

	@Override
	public Customer selectById(Customer object) {
		Customer c = null;
		List<Customer> resultList = new ArrayList<Customer>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Customer WHERE id=:customer_id";
				Query query = session.createQuery(hql);
				query.setParameter("customer_id", object.getId());
				resultList = query.getResultList();
				tr.commit();
				if(resultList.size() > 0) {
					c = resultList.get(0);
				}
			} finally {
				session.close();
			}
		}
		return c;
	}

	@Override
	public List<Customer> selectAll() {
		List<Customer> resultList = new ArrayList<Customer>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Customer";
				Query query = session.createQuery(hql);
				resultList = query.getResultList();
				tr.commit();
			} finally {
				session.close();
			}
		}
		return resultList;
	}
	
	public List<Customer> selectByCondition(String condition){
		List<Customer> resultList = new ArrayList<Customer>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Customer c WHERE "+condition;
				resultList = session.createQuery(hql).list();
				tr.commit();
			} finally {
				session.close();
			}
		}
		return resultList;
	}
	
	

}
