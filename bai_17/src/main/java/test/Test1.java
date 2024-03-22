package test;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerDAO;
import dao.OrderDAO;
import model.Customer;
import model.Order;

public class Test1 {
     public static void main(String[] args) {
//		Customer c1 = new Customer("1", "Customer1", "c1@gmail.com");
//		CustomerDAO.getInstance().insert(c1);
		
//		List<Order> orderList = new ArrayList();
//		Order o1 = new Order("001", "TPHCM", c1);
//		Order o2 = new Order("002", "TPHCM", c1);
//		Order o3 = new Order("003", "TPHCM", c1);
//		Order o4 = new Order("004", "TPHCM", c1);
//		
//		orderList.add(o1);
//		orderList.add(o2);
//		orderList.add(o3);
//		orderList.add(o4);
//		
//		for(Order o: orderList) {
//			OrderDAO.getInstance().insert(o);
//		}
    	 
//		Customer c2 = new Customer("2", "Customer2", "c2@gmail.com");
//		CustomerDAO.getInstance().insert(c2);
//		List<Order> orderList = new ArrayList();
//		Order o5 = new Order("005", "TPHCM", c2);
//		Order o6 = new Order("006", "TPHCM", c2);
//		Order o7 = new Order("007", "TPHCM", c2);
//		
//		orderList.add(o5);
//		orderList.add(o6);
//		orderList.add(o7);
//		
//		for(Order o: orderList) {
//			OrderDAO.getInstance().insert(o);
//		}
    	 
//    	 String condition = "size(c.orders) > 0";
//    	 List<Customer> orderList = (ArrayList<Customer>)CustomerDAO.getInstance().selectByCondition(condition);
//    	 for(Customer o: orderList) {
//    		 System.out.println(o);
//    	 }
//    	 
//    	 Order o = new Order();
//    	 o.setId("001");
//    	 o = OrderDAO.getInstance().selectById(o);
//    	 System.out.println(o);
    	 
    	 
//    	 Customer c = new Customer();
//    	 c.setId("1");
//    	 c = CustomerDAO.getInstance().selectById(c);
//    	 System.out.println(c);
    	 
    	 Customer c = new Customer();
    	 c.setId("2");
    	 ArrayList<Order> orderList = (ArrayList<Order>)OrderDAO.getInstance().getOrdersByCustomer(c);
    	 for(Order o:orderList) {
    		 System.out.println(o);
    	 }
    	 
    	 
    	 
		
	}
}
