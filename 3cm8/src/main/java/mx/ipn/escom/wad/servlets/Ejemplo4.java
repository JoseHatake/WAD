package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo4
 */
public class Ejemplo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejemplo4() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Parámetros en la query string</h1>");
		Enumeration<String> parametros = request.getParameterNames();
		out.println("<ol>");
		while (parametros.hasMoreElements()) {
			String parametro = parametros.nextElement();
			String[] valores = request.getParameterValues(parametro);
			String aux = "";
			for (String valor : valores) {
				aux += valor + ",";
			}
			out.println("<li>" + parametro + "=" + aux + "</li>");
		}
		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
	}
}
