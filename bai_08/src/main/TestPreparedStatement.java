package main;

import java.util.ArrayList;

import dao.UserDAO;
import model.User;

public class TestPreparedStatement {
	public static void main(String[] args) {
//		User u1 = new User();
//		u1.setTaiKhoan("\' OR 1=1; -- ");
//		
//		System.out.println(UserDAO.getInstance().selectById(u1));
		
//		ArrayList<User> userList = UserDAO.getInstance().selectAll();
//		for(User u: userList) {
//			System.out.println(u);
//		}
		
//		User u2 = new User("hai","07122002","Mai Son Hai");
//		UserDAO.getInstance().update(u2);
		
		User u3 = new User();
		u3.setTaiKhoan("hacker");
		u3.setMatKhau("1111");
		u3.setHoTen("Nguyen Van A");
		UserDAO.getInstance().insert(u3);
	}
}
