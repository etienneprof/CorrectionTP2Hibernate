package servlet.film;

import java.io.IOException;

import bll.FilmBLL;
import bo.Film;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficherServlet
 */
@WebServlet("/supprimer")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmBLL bll;
	
	@Override
	public void init() throws ServletException {
		bll = new FilmBLL();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("index").substring(1);
		Film filmASupprimer = bll.selectById(Integer.parseInt(pId));
		bll.delete(filmASupprimer);
		response.sendRedirect("lister");
	}
}
