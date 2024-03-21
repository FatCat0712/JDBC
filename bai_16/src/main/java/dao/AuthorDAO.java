package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtils;

public class AuthorDAO implements DAO<Author>{
	public static AuthorDAO getInstance() {
		return new AuthorDAO();
	}

	@Override
	public boolean insert(Author object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				session.save(object);
				tr.commit();
				result = true;
			} finally {
				session.close();
			}
			
		}
		return result;
	}

	@Override
	public boolean delete(Author object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "DELETE FROM Author WHERE id=:author_id";
				Query query = session.createQuery(hql);
				query.setParameter("author_id", object.getId());
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
	public boolean update(Author object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "UPDATE Author SET dateOfBirth=:date, nationality:=n WHERE id=:id";
				Query query = session.createQuery(hql);
				query.setParameter("date", object.getDateOfBirth());
				query.setParameter("n", object.getNationality());
				query.setParameter("id", object.getId());
				tr.commit();
				result = true;
			} finally {
				session.close();
			}
		}
		return result;
	}

	@Override
	public Author selectById(Author object) {
		Author author = null;
		List<Author> authorList = new ArrayList<Author>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Author WHERE id=:id";
				Query query = session.createQuery(hql);
				query.setParameter("id", object.getId());
				authorList = query.getResultList();
				if(authorList.size()>0) {
					author = authorList.get(0);
				}
			} finally {
				session.close();
			}
		}
			
		return author;
	}

	@Override
	public List<Author> selectAll() {
		List<Author> authorList = new ArrayList<Author>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Author";
				Query query = session.createQuery(hql);
				authorList = query.getResultList();
			} finally {
				session.close();
			}
		}
		return authorList;
	}
	
	
	
}
