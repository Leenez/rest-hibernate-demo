package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import models.Book;
import models.BookInfo;
//import models.BookInfo;
import models.Publisher;

public class Hibernate {
	
	private static SessionFactory factory;
	
	public Hibernate() {
		try {
	         factory = new Configuration().
	                   configure().
	                   addAnnotatedClass(Publisher.class).
	                   addAnnotatedClass(Book.class).	                   
	                   buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	public void createDemoMySQLDb() {		
		BookInfo demoinfo = new BookInfo();
		demoinfo.setReviewScore("demoscore");
		demoinfo.setRevision(0);
		
		Book book1 = new Book();
		book1.setBookID(1);
		book1.setDescription("First demo book");
		book1.setPublished(false);
		book1.setBookInfo(demoinfo);
				
		Book book2 = new Book();
		book2.setBookID(2);
		book2.setDescription("Second demo book");
		book2.setPublished(true);
		book2.setBookInfo(demoinfo);
				
		List<Book> booklist1 = new ArrayList<Book>();
		booklist1.add(book1);
		booklist1.add(book2);
		
		Publisher publisher1 = new Publisher();
		publisher1.setPublisherID(0);
		publisher1.setName("demo-publisher");
		publisher1.setBooks(booklist1);
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(publisher1);
			session.save(book1);
			session.save(book2);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static Publisher getPublisher(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		Publisher p = new Publisher();
		
		try {
			tx = session.beginTransaction();
			p = (Publisher) session.get(Publisher.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return p;
	}
}