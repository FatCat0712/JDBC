package dao;

import java.util.ArrayList;

import model.KhachHang;

public class KhachHangDAO implements DAO<KhachHang> {
	
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int add(KhachHang object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(KhachHang object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public KhachHang selectById(KhachHang object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
