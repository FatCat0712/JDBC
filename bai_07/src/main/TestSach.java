package main;

import java.util.ArrayList;

import dao.SachDAO;
import model.Sach;

public class TestSach {
	public static void main(String[] args) {
//	   Sach s1 = new Sach(2,"Data Structure",200000,2010);
//	   SachDAO.getInstance().insert(s1);
		
//		ArrayList<Sach> bookList = SachDAO.getInstance().selectAll();
//		for(Sach s: bookList) {
//			System.out.println(s);
//		}
		
//		Sach s = new Sach();
//		s.setId(1);
//		System.out.println(SachDAO.getInstance().selectById(s));
		
		String condition = "giaBan>50000";
		ArrayList<Sach> books = SachDAO.getInstance().selectByCondition(condition);
		for(Sach s: books) {
			System.out.println(s);
		}
		
		
	} 
}
