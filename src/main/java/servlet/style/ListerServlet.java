package servlet.style;

import java.io.IOException;
import java.util.List;

import bll.StyleBLL;
import bo.Style;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listerStyle")
public class ListerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StyleBLL bll;
	
	@Override
	public void init() throws ServletException {
		bll = new StyleBLL();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Style> styles = bll.selectAll();
		request.setAttribute("listeS", styles);
		request.getRequestDispatcher("listeStyles.jsp").forward(request, response);
	}
}
