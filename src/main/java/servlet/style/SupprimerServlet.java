package servlet.style;

import java.io.IOException;

import bll.StyleBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/supprimerStyle")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StyleBLL bll;
	
	@Override
	public void init() throws ServletException {
		bll = new StyleBLL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recuperer les parametres
		String idStr = request.getParameter("index");
		
		// 2. Je transforme mes parametres dans le type adequat
		int id = Integer.parseInt(idStr);
		
		// 3. Je procede a la suppression du style correspondant
		bll.deleteById(id);
		
		// 4. Je redirige mon utilisateur
		response.sendRedirect("listerStyle");
	}
}
