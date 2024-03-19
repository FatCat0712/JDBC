package dao;

import java.util.ArrayList;

public interface DAO<T>{
	public int insert(T object);
	public int delete(T object);
	public int update(T object);
	public ArrayList<T> selectAll();
	public int selectById(T object);
	public int selectByCondition(String condition);
	
}
