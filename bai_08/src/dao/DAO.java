package dao;

import java.util.ArrayList;

public interface DAO<T>{
	public int insert(T object);
	public int delete(T object);
	public int update(T object);
	public ArrayList<T> selectAll();
	public T selectById(T object);
	public ArrayList<T> selectByCondition(String condition);
}
