package dao;

import java.util.ArrayList;

public interface DAO <T>{
	public boolean insert(T object);
	public boolean delete(T object);
	public boolean update(T object);
	public ArrayList<T> selectAll();
	public T selectById(T object);
}
