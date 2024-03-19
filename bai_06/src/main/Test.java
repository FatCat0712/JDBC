package main;

import java.sql.Date;

import dao.KhachHangDAO;
import dao.SachDAO;
import model.KhachHang;
import model.Sach;

public class Test {
	public static void main(String[] args) {
//		Sach sach1 = new Sach("MySQL Cookbook",20000,2000);
//		System.out.println(SachDAO.getInstance().insert(sach1));
		
//		Sach sach2 = new Sach("Java Programming",50000,2019);
//		for(int i = 0; i < 5; i++) {
//			SachDAO.getInstance().insert(sach2);
//		}
		
//		Sach sach3 = new Sach("Spring Boot", 70000, 2002);
//		System.out.println(SachDAO.getInstance().insert(sach3));
		
//		Sach sach2 = new Sach("Java Programming",50000,2019);
//		System.out.println(SachDAO.getInstance().insert(sach2));
//		System.out.println(SachDAO.getInstance().delete(sach2));
		
//		Sach sach3 = new Sach("Java Programming",70000,2019);
//		System.out.println(SachDAO.getInstance().update(sach3));
		
//		KhachHang kh1 = new KhachHang("Mai Son Hai", Date.valueOf("2002-12-07"), "Vinh Long");
		
		KhachHang kh2 = new KhachHang(2,"Mai Thanh Ha", Date.valueOf("1995-07-09"), "Vinh Long");

		//KhachHangDAO.getInstance().insert(kh2);
		KhachHangDAO.getInstance().update(kh2);
		
		
		
	}
}
