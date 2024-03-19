package main;

import java.sql.Date;
import java.util.ArrayList;

import dao.KhachHangDAO;
import model.KhachHang;

public class TestKhachHang {
	public static void main(String[] args) {
//		ArrayList<KhachHang> guestList = KhachHangDAO.getInstance().selectAll();
//		for(KhachHang k: guestList) {
//			System.out.println(k);
//		}
		
//		KhachHang k3 = new KhachHang(3,"Vo Thi Kim Thanh",Date.valueOf("1986-04-08"),"Vinh Long");
//		KhachHangDAO.getInstance().insert(k3);
		
//		KhachHang k4 = new KhachHang(4,"Mai Hac Son",Date.valueOf("1959-08-30"),"Hai Phong");
//		KhachHangDAO.getInstance().delete(k4);
		
//		KhachHang k = new KhachHang();
//		k.setId(3);
//		System.out.println(KhachHangDAO.getInstance().selectById(k));
		
		String condition = " diaChi LIKE 'V%'";
		ArrayList<KhachHang> guestList = KhachHangDAO.getInstance().selectByCondition(condition);
		for(KhachHang k: guestList) {
			System.out.println(k);
		}
		
	}
}
