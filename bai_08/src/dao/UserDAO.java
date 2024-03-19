package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAO<User>{
	public static UserDAO getInstance() {
		return new UserDAO();
	}

	@Override
	public int insert(User object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "INSERT INTO USER VALUES(?,?,?)";
			
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getTaiKhoan());
			pst.setString(2, object.getMatKhau());
			pst.setString(3, object.getHoTen());
			result = pst.executeUpdate();
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result + "rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(User object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "DELETE FROM USER WHERE taiKhoan=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getTaiKhoan());
			result = pst.executeUpdate();
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result + "rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(User object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "UPDATE USER "
					+"SET matKhau=?,"
					+"hoTen=?"
					+"WHERE taiKhoan=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getMatKhau());
			pst.setString(2, object.getHoTen());
			pst.setString(3, object.getTaiKhoan());
			result = pst.executeUpdate();
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result + "rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> userList = new ArrayList<User>();
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM USER";
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String taiKhoan = rs.getString("taiKhoan");
				String matKhau = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				userList.add(new User(taiKhoan,matKhau,hoTen));
			}
			System.out.println("Ban da thuc thi: "+sql);
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public User selectById(User object) {
		User u = null;
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM USER WHERE taiKhoan=?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, object.getTaiKhoan());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String taiKhoan = rs.getString("taiKhoan");
				String matKhau = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				u = new User(taiKhoan,matKhau,hoTen);
			}
			System.out.println("Ban da thuc thi: "+sql);
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> userList = new ArrayList<User>();
		Connection c = JDBCUtil.connect();
		try {
			String sql = "SELECT * FROM USER WHERE "+condition;
			PreparedStatement pst = c.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String taiKhoan = rs.getString("taiKhoan");
				String matKhau = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				userList.add(new User(taiKhoan,matKhau,hoTen));
			}
			System.out.println("Ban da thuc thi: "+sql);
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	
	
}
