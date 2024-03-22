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

public class OrderDAO implements DAO<Order>{
	public static OrderDAO getInstance() {
		return new OrderDAO();
	}
	@Override
	public boolean insert(Order object) {
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
	public int delete(Order object) {
		int result = 0;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "DELETE FROM Order WHERE id=:order_id";
				Query query = session.createQuery(hql);
				query.setParameter("order_id", object.getId());
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
	public int update(Order object) {
		int result = 0;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "UPDATE Order SET address=:a WHERE id=:customer_id";
				Query query = session.createQuery(hql);
				query.setParameter("a", object.getAddress());
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
	public Order selectById(Order object) {
		Order o = null;
		List<Order> resultList = new ArrayList<Order>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Order WHERE id=:order_id";
				Query query = session.createQuery(hql);
				query.setParameter("order_id", object.getId());
				resultList = query.getResultList();
				tr.commit();
				if(resultList.size() > 0) {
					o = resultList.get(0);
				}
			} finally {
				session.close();
			}
		}
		return o;
	}

	@Override
	public List<Order> selectAll() {
		List<Order> resultList = new ArrayList<Order>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Order";
				Query query = session.createQuery(hql);
				resultList = query.getResultList();
				tr.commit();
			} finally {
				session.close();
			}
		}
		return resultList;
	}
	
	public List<Order> getOrdersByCustomer(Customer object){
		List<Order> resultList = new ArrayList<Order>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Order WHERE customer.id=:customer_id";
				Query query = session.createQuery(hql);
				query.setParameter("customer_id", object.getId());
				resultList = query.getResultList();
				tr.commit();
			} finally {
				session.close();
			}
		}
		return resultList;
	}
	
}
