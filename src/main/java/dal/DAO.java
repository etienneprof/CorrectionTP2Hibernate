package dal;

import java.util.List;

public interface DAO<T> {
	T selectById(int id);
	List<T> select();
	void insert(T data);
	void update(T data);
	void delete(int id);
	void delete(T data);
}
