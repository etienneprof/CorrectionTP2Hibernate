package servlet.style;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.StyleBLL;
import bo.Style;

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
