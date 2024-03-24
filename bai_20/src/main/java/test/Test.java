package test;

import java.sql.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.OrderDetails;
import model.Orders;
import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
		Orders o1 = new Orders();
		o1.setTenKhachHang("Mai Son Hai");
		o1.setNgayTao(new Date(System.currentTimeMillis()));
		
		OrderDetails od1 = new OrderDetails();
		od1.setTenSanPham("Pho Xua va Nay");
		od1.setSoLuong(5);
		od1.setDonGia(6500);
		od1.setTongTien(od1.getSoLuong() * od1.getDonGia());
		od1.setDonHang(o1);
		
		OrderDetails od2 = new OrderDetails();
		od2.setTenSanPham("Mi Cay");
		od2.setSoLuong(3);
		od2.setDonGia(9500);
		od2.setTongTien(od2.getSoLuong() * od2.getDonGia());
		od2.setDonHang(o1);
		
		
		o1.addDanhSachChiTiet(od1);
		o1.addDanhSachChiTiet(od2);
		
		SessionFactory sessionFactory = HibernateUtils.buildSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
				
//				session.persist(o1);
				
				Orders o_m = session.load(Orders.class, 1);
				o_m.setTenKhachHang("Nguyen Van C");
				o_m.setNgayTao(Date.valueOf("2002-07-07"));		
				OrderDetails od_m = o_m.getDanhSachchiTiet().iterator().next();
				od_m.setDonGia(100000);
				session.merge(o_m);
				
				tr.commit();
				
				
//				long batDau = System.currentTimeMillis();
//				Orders myOrder = session.load(Orders.class, 1);
//				long ketThuc = System.currentTimeMillis();
//				System.out.println("Thoi gian lay du lieu: "+ (ketThuc - batDau));
//				System.out.println(myOrder);
//				Set<OrderDetails> ods = myOrder.getDanhSachchiTiet();
//				for(OrderDetails o: ods) {
//					System.out.println(o);
//				}
				
				
				
			}finally {
				session.close();
			}
		}
		
		
		
	}
}
