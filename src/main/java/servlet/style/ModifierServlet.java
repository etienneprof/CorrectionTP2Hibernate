package servlet.style;

import java.io.IOException;

import bll.StyleBLL;
import bo.Style;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/modifStyle")
public class ModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StyleBLL bll;
	
	@Override
	public void init() throws ServletException {
		bll = new StyleBLL();
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recuperer les parametres
		String idStr = request.getParameter("id");
		String libelle = request.getParameter("libelle");
		
		// 2. Je transforme mes parametres dans le type adequat
		int id = Integer.parseInt(idStr);
		
		// 3. Je procede a la modification du style correspondant
		Style styleAModifier = new Style(libelle);
		styleAModifier.setId(id);
		bll.update(styleAModifier);
		
		// 4. Je redirige mon utilisateur
		response.sendRedirect("listerStyle");
	}

}
