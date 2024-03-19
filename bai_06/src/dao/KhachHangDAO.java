package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;

public class KhachHangDAO implements DAO<KhachHang> {
	
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang object) {
		// TODO Auto-generated method stub
		Connection c = JDBCUtil.connect();
		int result = 0;
		try {
			Statement st  = c.createStatement();
			String sql = "INSERT INTO khachHang(id,hoTen,ngaySinh,DiaChi)"+
					 "VALUES("+object.getId()+","
					 		+"'"+object.getHoTen()+"',"
					 		+"'"+object.getNgaySinh()+"',"
					 		+"'"+object.getDiaChi()+"')";
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println(result + " rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 								 			
		return result;
	}

	@Override
	public int delete(KhachHang object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			Statement st= c.createStatement();
			String sql = "DELETE FROM khachHang WHERE id="+object.getId();
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result + " rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int update(KhachHang object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "UPDATE khachHang "+
					     "SET hoTen='"+object.getHoTen()+"',"
					     +"ngaySinh='"+object.getNgaySinh()+"',"
					     +"diaChi='"+object.getDiaChi()+"'"
					     +"WHERE id="+object.getId();
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+ sql);
			System.out.println(result + " rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectById(KhachHang object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
