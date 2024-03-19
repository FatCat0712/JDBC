package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import database.JDBCUtil;
import model.KhachHang;

public class KhachHangDAO implements DAO<KhachHang>{
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO khachHang(id,hoTen,ngaySinh,diaChi)"
						+"VALUES("+object.getId()+",'"
						+object.getHoTen()+"','"
						+object.getNgaySinh()+"','"
						+object.getDiaChi()+"')";
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result+" rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(KhachHang object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "DELETE FROM khachHang WHERE id="+object.getId();
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result+" rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
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
			String sql = "UPDATE khachHang "
					+ "SET hoTen='"+object.getHoTen()+"',"
					+  " ngaySinh='"+object.getNgaySinh()+"',"
					+  " diaChi='"+object.getDiaChi()+"'"
					+ " WHERE id="+object.getId();
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result+" rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * FROM khachHang";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				ketQua.add(new KhachHang(id,hoTen,ngaySinh,diaChi));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang object) {
		KhachHang khach = new KhachHang();
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * FROM khachHang";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				khach = new KhachHang(id,hoTen,ngaySinh,diaChi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return khach;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * FROM khachHang WHERE"+condition;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String hoTen = rs.getString("hoTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				ketQua.add(new KhachHang(id,hoTen,ngaySinh,diaChi));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

}
