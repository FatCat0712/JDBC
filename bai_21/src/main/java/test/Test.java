package test;



import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.OrderDetails;
import model.Orders;
import util.HibernateUtils;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			try {
				Transaction tr = session.beginTransaction();
//				Orders o1 = new Orders();
//				o1.setId(1);
//				o1.setTenKhachHang("Mai Son Hai");
//				o1.setNgayLap(new Date(System.currentTimeMillis()));
				
//				for(int i = 0; i < 500; i++) {
//					OrderDetails od = new OrderDetails();
//					od.setId(i);
//					od.setTenSanPham("Banh Mi");
//					od.setDonGia(50000);
//					od.setSoLuong(5);
//					od.setTongTien(od.getDonGia() * od.getSoLuong());
//					od.setDonHang(o1);
//					o1.addChiTietDonHang(od);
//				}
//				
//				session.save(o1);
				
				Orders o2 = new Orders();
				long batDau = System.currentTimeMillis();
				o2 = session.load(Orders.class, 1);
				Set<OrderDetails> ods = o2.getDanhSachChiTiet();
				long ketThuc = System.currentTimeMillis();
//				for(OrderDetails o: ods) {
//					System.out.println(o);
//				}
				System.out.println("takes: "+(ketThuc - batDau));
				System.out.println(o2);
				tr.commit();
			} finally {
				session.close();
			}
		}
	}
}
