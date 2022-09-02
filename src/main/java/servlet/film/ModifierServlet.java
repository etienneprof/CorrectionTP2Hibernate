package servlet.film;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.FilmBLL;
import bll.StyleBLL;
import bo.Acteur;
import bo.Film;
import bo.Realisateur;
import bo.Style;

/**
 * Servlet implementation class AfficherServlet
 */
@WebServlet("/editer")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StyleBLL styleBll;
	private FilmBLL filmBll;
	
	@Override
	public void init() throws ServletException {
		styleBll = new StyleBLL();
		filmBll = new FilmBLL();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// substring(1) permet de passer de "m2" (identifiant) a "2" (je retire le premier caractere)
		String id = request.getParameter("index").substring(1);
		request.setAttribute("film", filmBll.selectById(Integer.parseInt(id)));
		request.setAttribute("listeStyles", styleBll.selectAll());
		request.getRequestDispatcher("/editerFilm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recuperation des parametres (il y en a beaucoup)
		String pId = request.getParameter("id");
		String pTitre = request.getParameter("titre");
		String pAnnee = request.getParameter("annee");
		String pStyle = request.getParameter("style");
		String pRealPrenom = request.getParameter("real.prennom");
		String pRealNom = request.getParameter("real.nom");
		String pDuree = request.getParameter("duree");
		String pVu = request.getParameter("vu");
		String pSynopsis = request.getParameter("synopsis");
		
		List<Acteur> listActeurs = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String nom = request.getParameter("nom" + i);
			String prenom = request.getParameter("prenom" + i);
			if (!nom.isBlank() && !prenom.isBlank()) {
				Acteur acteur = new Acteur();
				acteur.setNom(nom);
				acteur.setPrenom(prenom);
				listActeurs.add(acteur);
			}
		}
		
		// 2. Je transforme mes parametres dans le type approprie
		int id = Integer.parseInt(pId);
		int annee = Integer.parseInt(pAnnee);
		Style style = styleBll.selectById(Integer.parseInt(pStyle));
		Realisateur real = new Realisateur();
		real.setNom(pRealNom);
		real.setPrenom(pRealPrenom);
		int duree = Integer.parseInt(pDuree);
		boolean vu = Boolean.parseBoolean(pVu);
		
		// 3. Je mets a jour le film correspondant
		Film film = filmBll.selectById(id);
		film.setTitre(pTitre);
		film.setAnnee(annee);
		film.setStyle(style);
		film.setReal(real);
		film.setDuree(duree);
		film.setVu(vu);
		film.setActeurs(listActeurs);
		film.setSynopsis(pSynopsis);
		
		// 4. Je procede a l'insertion
		filmBll.update(film);
		
		// 5. Je redirige mon utilisateur
		response.sendRedirect("lister");
	}

}
