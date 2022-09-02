package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Film;

public class FilmDAOHibernateImpl implements FilmDAO {
	private EntityManagerFactory emf;
	
	public FilmDAOHibernateImpl() {
		emf = Persistence.createEntityManagerFactory("user");
	}
	
	@Override
	public void insert(Film film) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.persist(film);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public List<Film> selectAll() {
		EntityManager em = emf.createEntityManager();
		List<Film> resultat = em.createQuery("from Film", Film.class).getResultList();
		em.close();
		return resultat;
	}
	
	@Override
	public Film selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Film resultat = em.find(Film.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void delete(Film film) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			/*
			 * On est oblige d'utiliser em.remove(...) pour declencher les suppressions en cascade
			 * Si on utilise une requete du type "DELETE FROM Film WHERE id = :id", la cascade n'est pas declenchee
			 */
			em.remove(em.merge(film));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public void update(Film film) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.merge(film);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
}
