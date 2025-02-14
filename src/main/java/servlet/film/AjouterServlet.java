package servlet.film;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bll.FilmBLL;
import bll.FilmException;
import bll.StyleBLL;
import bo.Acteur;
import bo.Film;
import bo.Realisateur;
import bo.Style;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StyleBLL styleBll;
	private FilmBLL filmBll;
	
	@Override
	public void init() throws ServletException {
		styleBll = new StyleBLL();
		filmBll = new FilmBLL();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listeStyles", styleBll.selectAll());
		request.getRequestDispatcher("ajouterFilm.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recuperation des parametres (il y en a beaucoup)
		String pTitre = request.getParameter("titre");
		String pAnnee = request.getParameter("annee");
		String pStyle = request.getParameter("style");
		String pRealPrenom = request.getParameter("real.prenom");
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
		
		boolean insertionOk = true;
		// 2. Je transforme mes parametres dans le type approprie
		try {
			int annee = Integer.parseInt(pAnnee);
			Style style = styleBll.selectById(Integer.parseInt(pStyle));
			Realisateur real = new Realisateur();
			real.setNom(pRealNom);
			real.setPrenom(pRealPrenom);
			int duree = Integer.parseInt(pDuree);
			boolean vu = Boolean.parseBoolean(pVu);
			
			// 3. Je cree le film correspondant
			Film film = new Film();
			film.setTitre(pTitre);
			film.setAnnee(annee);
			film.setStyle(style);
			film.setReal(real);
			film.setDuree(duree);
			film.setVu(vu);
			film.setActeurs(listActeurs);
			film.setSynopsis(pSynopsis);
			
			// 4. Je procede a l'insertion en bdd
			filmBll.insert(film);
		} catch (FilmException e) { // L'exception renvoyee par le BLL
			insertionOk = false;
			request.setAttribute("erreurs", e.getMessages());
			doGet(request, response);
		} catch (Exception e) { // Les exceptions issues de mauvais Integer.parseInt...
			insertionOk = false;
			List<String> erreurs = new ArrayList<>();
			erreurs.add("L'annee ou la duree ne respecte pas un format de nombre correct");
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("classError", "error_input");
			doGet(request, response);
		}
		
		// 5. Je redirige mon utilisateur
		if (insertionOk) {
			response.sendRedirect("lister");
		}
	}
}
