package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCUtil {
	public static Connection connect() {
		Connection c = null;
		com.mysql.jdbc.Driver driver;
		try {
			driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			String url = "jdbc:mySQL://localhost:3306/truongdaihoc";
			String username = "root";
			String password = "";
			
			c = DriverManager.getConnection(url, username, password);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static void disconnect(Connection c) {
		if(c!=null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void printInfo(Connection c) {
		if(c != null) {
			try {
				DatabaseMetaData mtdt = (DatabaseMetaData) c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
