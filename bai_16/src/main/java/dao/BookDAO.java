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

public class BookDAO implements DAO<Book>{
	public static BookDAO getInstance() {
		return new BookDAO();
	}

	@Override
	public boolean insert(Book object) {
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
	public boolean delete(Book object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "DELETE FROM Author WHERE id=:book_id";
				Query query = session.createQuery(hql);
				query.setParameter("book_id", object.getId());
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
	public boolean update(Book object) {
		boolean result = false;
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "UPDATE Book SET title=:t, price:=p WHERE id=:id";
				Query query = session.createQuery(hql);
				query.setParameter("title", object.getTitle());
				query.setParameter("p", object.getPrice());
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
	public Book selectById(Book object) {
		Book book = null;
		List<Book> bookList = new ArrayList<Book>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Book WHERE id=:id";
				Query query = session.createQuery(hql);
				query.setParameter("id", object.getId());
				bookList = query.getResultList();
				if(bookList.size()>0) {
					book = bookList.get(0);
				}
			} finally {
				session.close();
			}
		}
			
		return book;
	}

	@Override
	public List<Book> selectAll() {
		List<Book> bookList = new ArrayList<Book>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Book";
				Query query = session.createQuery(hql);
				bookList = query.getResultList();
			} finally {
				session.close();
			}
		}
		return bookList;
	}
	public List<Book> getBookList(Author object){
		List<Book> bookList = new ArrayList<Book>();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				String hql = "FROM Book WHERE author.id=:id";
				Query query = session.createQuery(hql);
				query.setParameter("id", object.getId());
				bookList = query.getResultList();
			} finally {
				session.close();
			}
		}
		return bookList;
	}

}
