package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAO<Sach>{
	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "INSERT INTO sach "+
						 "VALUES("+object.getId()+","
						 	+"'"+object.getTenSach()+"',"
						 	+object.getGiaBan()+","
						 	+object.getNamXuatBan()+")";
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result + " rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Sach object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "DELETE FROM sach WHERE id="+object.getId();
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result + " rows affected");
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Sach object) {
		int result = 0;
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "UPDATE sach "
						+"SET tenSach='"+object.getTenSach()+"'"
						+",giaBan="+object.getGiaBan()
						+",namXuatBan="+object.getNamXuatBan()
						+" WHERE id="+object.getId();
			result = st.executeUpdate(sql);
			System.out.println("Ban da thuc thi: "+sql);
			System.out.println(result + " rows affected");
			JDBCUtil.disconnect(c);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * FROM sach";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				ketQua.add(new Sach(id,tenSach,giaBan,namXuatBan));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Sach selectById(Sach object) {
		Sach s = new Sach();
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * FROM sach WHERE id="+object.getId();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				s = new Sach(id,tenSach,giaBan,namXuatBan);
			}
			JDBCUtil.disconnect(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> ketQua = new ArrayList<Sach>();
		Connection c = JDBCUtil.connect();
		try {
			Statement st = c.createStatement();
			String sql = "SELECT * FROM sach WHERE "+condition;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				ketQua.add(new Sach(id,tenSach,giaBan,namXuatBan));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
}
