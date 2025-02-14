package servlet.style;

import java.io.IOException;

import bll.StyleBLL;
import bo.Style;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouterStyle")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StyleBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new StyleBLL();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recuperer les parametres
		String libelle = request.getParameter("libelle");
		
		// 2. Creer le style avec les informations recuperees
		Style style = new Style(libelle);
		
		// 3. J'envoie le Style cree au bll pour proceder a l'enregistrement en bdd
		bll.insert(style);
		
		// 4. Je redirige l'utilisateur vers la page de liste des styles
		response.sendRedirect("listerStyle");
	}

}
