package trello01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresa
 */
@WebServlet("/cadEmpresa")
public class NovaEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("testando cadastro");
		
		String nomeEmpresa = request.getParameter("nome");
		
		Empresa empresa = new Empresa();
		
		empresa.setNome(nomeEmpresa);
		
		Banco banco = new Banco();
	
		banco.adiciona(empresa);
		
		banco.getEmpresas().forEach(e -> System.out.println(e.getNome()));
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa " 
				+ nomeEmpresa + ", cadastrada com sucesso!<br><br>"
						+ "<form action=\"/ExercicioSemana09Trello/index.html\" method=\"get\">\n"
						+ "\n"+ "<button type=\\\"submit\\\"/>Voltar</button>\n"
						+ "</form>"
								+ "</body></html>");
		
		
	}

	
}
