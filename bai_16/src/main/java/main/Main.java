package main;

import java.sql.Date;
import java.util.ArrayList;

import dao.AuthorDAO;
import dao.BookDAO;
import model.Author;
import model.Book;

public class Main {
	public static void main(String[] args) {
//		Author a1 = new Author("CTA", "Cuong Tuyet An", new Date(System.currentTimeMillis()), "China");
		//AuthorDAO.getInstance().insert(a1);
		
		
//		Book b1 = new Book("B01", "title1", 50000, a1);
//		Book b2 = new Book("B02", "title2", 60000, a1);
//		Book b3 = new Book("B03", "title3", 50000, a1);
//		BookDAO.getInstance().insert(b1);
//		BookDAO.getInstance().insert(b2);
//		BookDAO.getInstance().insert(b3);
		
		Author a2 = new Author("NNA","Nguyen Nhat Anh", new Date(System.currentTimeMillis()),"Vietnam");
//		AuthorDAO.getInstance().insert(a2);
		
		Book b4 = new Book("B04","title4",100000,a2);
		Book b5 = new Book("B05","title5",150000,a2);
		Book b6 = new Book("B06","title6",200000,a2);
		
//		BookDAO.getInstance().insert(b4);
//		BookDAO.getInstance().insert(b5);
//		BookDAO.getInstance().insert(b6);
		
		ArrayList<Book> list = (ArrayList<Book>) BookDAO.getInstance().getBookList(a2);
		for(Book b: list) {
			System.out.println(b);
		}
		
//		ArrayList<Author> list = (ArrayList<Author>) AuthorDAO.getInstance().selectAll();
//		for(Author a:list) {
//			System.out.println(a);
//		}
//				
//		Book book7 = new Book();
//		book7.setId("B04");
//		System.out.println(BookDAO.getInstance().selectById(book7));
		
		
	}
}
