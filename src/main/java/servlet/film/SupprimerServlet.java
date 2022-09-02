package servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.FilmBLL;
import bo.Film;

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
