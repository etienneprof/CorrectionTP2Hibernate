package servlet.film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.FilmBLL;

@WebServlet("/lister")
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmBLL bll;
	
	@Override
	public void init() throws ServletException {
		bll = new FilmBLL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listeF", bll.selectAll());
		request.getRequestDispatcher("/listeFilms.jsp").forward(request, response);
	}
}
