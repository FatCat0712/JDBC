package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.jdbc.Driver;

public class JDBCUtil {
	public static Connection connect() {
		Connection c = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String sql = "jdbc:mySQL://10.10.10.5:3306/nhaSach";
			String username = "root";
			String password = "root123";
			c = DriverManager.getConnection(sql, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static void disconnect(Connection c) {
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void printInfo(Connection o) {
		try {
			DatabaseMetaData mtdt = (DatabaseMetaData) o.getMetaData();
			System.out.println(mtdt.getDatabaseProductName());
			System.out.println(mtdt.getDatabaseProductVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
