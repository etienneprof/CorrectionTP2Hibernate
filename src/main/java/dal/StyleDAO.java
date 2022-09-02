package dal;

import java.util.List;

import bo.Style;

public interface StyleDAO {
	void insert(Style style);
	List<Style> selectAll();
	void deleteById(int id);
	void update(Style style);
	Style selectById(int id);
}
