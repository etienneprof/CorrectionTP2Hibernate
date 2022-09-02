package bll;

import java.util.List;

import bo.Film;
import dal.FilmDAO;
import dal.FilmDAOHibernateImpl;

public class FilmBLL {
private FilmDAO dao;
	
	public FilmBLL() {
		dao = new FilmDAOHibernateImpl();
	}
	
	public List<Film> selectAll() {
		return dao.selectAll();
	}
	
	public Film selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Film film) throws FilmException {
		verifierValeurs(film);
		dao.insert(film);
	}

	public void delete(Film film) {
		dao.delete(film);
	}

	public void update(Film filmAModifier) {
		dao.update(filmAModifier);
	}

	private void verifierValeurs(Film film) throws FilmException {
		FilmException exception = new FilmException();
		if (film.getTitre().isBlank()) {
			exception.ajouterErreur("Veuillez saisir un titre");
		}
		if (film.getDuree() <= 0) {
			exception.ajouterErreur("Veuillez saisir une duree valide");
		}
		if (film.getAnnee() <= 0) {
			exception.ajouterErreur("Veuillez saisir une annee valide");
		}
		if (film.getReal().getNom().isBlank() || film.getReal().getPrenom().isBlank()) {
			exception.ajouterErreur("Veuillez renseigner les informations du realisateur");
		}
		
		if (exception.getMessages().size() > 0) {
			throw exception;
		}
	}
}
