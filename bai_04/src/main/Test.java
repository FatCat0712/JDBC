package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class Test {
	 public static void main(String[] args) {
		 
		 try {
			//Tao ket noi
			Connection c = JDBCUtil.connect();
			
			//Tao doi tuong statement
			Statement st = c.createStatement();
			
			//Tao cau truy van
			String sql = "INSERT INTO lophoc( maLop,tenLop,tenKHoa)"
									+ "VALUES (\"TT2003\",\"He Thong Thong Tin\",\"Khoa Hoc Du Lieu\")";
			
			int check = st.executeUpdate(sql);
			
			// Xu ly ket qua
			System.out.println("So dong thay doi: "+check);
			if(check > 0) {
				System.out.println("Them du lieu thanh cong");
			}
			else {
				System.out.println("Them du lieu that bai");
			}
			//Ngat ket noi
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
}
