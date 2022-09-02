package bll;

import java.util.List;

import bo.Style;
import dal.StyleDAO;
import dal.StyleDAOHibernateImpl;

public class StyleBLL {
	private StyleDAO dao;
	
	public StyleBLL() {
		dao = new StyleDAOHibernateImpl();
	}
	
	public List<Style> selectAll() {
		return dao.selectAll();
	}
	
	public Style selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Style style) {
		dao.insert(style);
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

	public void update(Style styleAModifier) {
		dao.update(styleAModifier);
	}

}
