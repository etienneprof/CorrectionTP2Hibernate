package servlet.film;

import java.io.IOException;

import bll.FilmBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficherServlet
 */
@WebServlet("/afficher")
public class AfficherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FilmBLL bll;
    
    @Override
    public void init() throws ServletException {
    	bll = new FilmBLL();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("index");
		request.setAttribute("film", bll.selectById(Integer.parseInt(id)));
		request.getRequestDispatcher("/afficherFilm.jsp").forward(request, response);
	}
}
