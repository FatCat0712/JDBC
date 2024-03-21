package dao;

import java.util.List;

public interface DAO<T>{
	public boolean insert(T object);
	public boolean delete(T object);
	public boolean update(T object);
	public T selectById(T object);
	public List<T> selectAll();
}	
