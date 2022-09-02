package dal;

import java.util.List;

import bo.Film;

public interface FilmDAO {
	void insert(Film film);
	List<Film> selectAll();
	void delete(Film film);
	void update(Film film);
	Film selectById(int id);
}
