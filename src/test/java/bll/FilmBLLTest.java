package bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import bo.Film;
import bo.Realisateur;
import bo.Style;

class FilmBLLTest {
	static FilmBLL bll;
	static StyleBLL stylebll;
	
	@BeforeAll
	static void setupBeforeAll() {
		bll = new FilmBLL();
		stylebll = new StyleBLL();
		
		Style style = new Style("Comédie");
		stylebll.insert(style);
		System.out.println(style.getId());
	}
	
	@Test
	void insert_filmValide_doitEnregistrerEnBDD() {
		Film film = new Film();
		film.setTitre("Test");
		film.setAnnee(2025);
		film.setDuree(120);
		film.setVu(true);
		film.setSynopsis("Un film qu'il est bien");
		
		Realisateur real = new Realisateur();
		real.setNom("muche");
		real.setPrenom("truc");
		
		film.setReal(real);
		
		Style style = stylebll.selectById(1);
		film.setStyle(style);
		
		try {
			bll.insert(film);
		} catch (FilmException e) {
			fail("Le film inséré aurait du être valide");
		}
		
		assertNotEquals(0, film.getId());
		assertNotEquals(0, real.getId());
	}
	
	@Test
	void insert_filmKO_leveException() {
		Film film = new Film();
		film.setAnnee(15);
		film.setDuree(-10);
		film.setVu(true);
		film.setSynopsis("Un film qu'il est bien");
		
		Realisateur real = new Realisateur();
		real.setNom("muche");
		real.setPrenom("truc");
		
		film.setReal(real);
		
		Style style = stylebll.selectById(1);
		film.setStyle(style);
		
		FilmException fe = assertThrows(FilmException.class, () -> {
			bll.insert(film);
		});
		
		assertEquals(3, fe.getMessages().size());
	}
}
