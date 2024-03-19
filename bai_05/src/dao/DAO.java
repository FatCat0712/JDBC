package dao;

import java.util.ArrayList;

public interface DAO <T>{
	
	public int add(T object);
	
	public int update(T object);
	
	public int delete(T t);
	
	public ArrayList<T> selectAll();
	
	public T selectById(T object);
	
	public ArrayList<T> selectByCondition(String condition);
}
