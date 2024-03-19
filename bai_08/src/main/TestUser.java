package main;

import java.util.ArrayList;

import dao.UserDAO;
import model.User;

public class TestUser {
	public static void main(String[] args) {
//		User u1 = new User("hai","123456","Mai Son Hai");
//		User u2 = new User("ha","123456","Mai Thanh Ha");
//		User u3 = new User("thanh","123456","Vo Thi Kim Thanh");
		User u4 = new User("hacker","01234","Nothing");
		
		UserDAO.getInstance().insert(u4);
		
//		UserDAO.getInstance().insert(u1);
//		UserDAO.getInstance().insert(u2);
//		UserDAO.getInstance().insert(u3);
	
//		UserDAO.getInstance().delete(u3);
		String condition1 = "taiKhoan='ha'";
		String condition2 = "taiKhoan='' OR 1=1; --";
		ArrayList<User> userList = UserDAO.getInstance().selectByCondition(condition2);
		for(User u : userList) {
			System.out.println(u);
		}
		
		
		
		
	}
}
