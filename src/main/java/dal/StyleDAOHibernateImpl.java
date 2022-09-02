package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Style;

public class StyleDAOHibernateImpl implements StyleDAO {
	private EntityManagerFactory emf;
	
	public StyleDAOHibernateImpl() {
		emf = Persistence.createEntityManagerFactory("user");
	}
	
	@Override
	public void insert(Style style) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.persist(style);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public List<Style> selectAll() {
		EntityManager em = emf.createEntityManager();
		List<Style> resultat = em.createQuery("from Style", Style.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Style selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Style style = em.find(Style.class, id);
		em.close();
		return style;
	}


	@Override
	public void deleteById(int id) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em
				.createNamedQuery("deleteStyle")
				.setParameter("id", id)
				.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public void update(Style style) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.merge(style);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
}
