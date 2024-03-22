package dao;

import java.util.List;

public interface DAO<T> {
	public boolean insert(T object);
	public int delete(T object);
	public int update(T object);
	public T selectById(T object);
	public List<T> selectAll();
}
