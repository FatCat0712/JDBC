package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAO<Sach>{
	public static SachDAO getInstance() {
		return new SachDAO();
	}

	public int insert(Sach object) {
		
		// khoi tao ket noi
		Connection c = JDBCUtil.connect();
		// tao bien de luu so dong bi thay doi
		int result = 0;
		try {
			// tao statement de thuc thi
			Statement st = c.createStatement();
			
			//tao cau truy van
			String sql = "INSERT INTO sach(tenSach,giaBan,namXuatBan)"+
						 "VALUES('"+object.getTenSach()+"'"
						 		 +",'"+object.getGiaBan()+"'"
						 		 + ",'"+object.getNamSanXuat()+"')";
			
			//thuc thi
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			
			//ngat ket noi
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Sach object) {
		// TODO Auto-generated method stub
		Connection c = JDBCUtil.connect();
		int result = 0;
		try {
			Statement st = c.createStatement();
			String sql = "DELETE FROM sach WHERE tenSach = '"+object.getTenSach()+"'";
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Sach object) {
		// TODO Auto-generated method stub
		Connection c = JDBCUtil.connect();
		int result = 0;
		try {
			Statement st = c.createStatement();
			String sql = "UPDATE sach "
						+"SET giaBan="+object.getGiaBan()
						+" WHERE tenSach='"+object.getTenSach()+"'";
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectById(Sach object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return 0;
	}

}
