package trello01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresa
 */
@WebServlet("/listaEmpresa")
public class ListaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h4>Todas Empresas cadastradas até o momento.</h4>");
        out.println("<ul>");
        
        for (Empresa empresa: lista) {
        	out.println("<li>"+ empresa.getNome() +"</li>");
        }
        out.println("</ul>");
        out.println("<form action=\"/ExercicioSemana09Trello/index.html\" method=\"get\">\n"
						+ "\n"+ "<button type=\\\\\\\"submit\\\\\\\"/>Voltar</button>\n"
						+ "</form");
        out.println("</body></html>");
	}
}
