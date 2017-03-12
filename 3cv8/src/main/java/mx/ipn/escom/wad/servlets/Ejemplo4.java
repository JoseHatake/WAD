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
		PrintWriter out = response.getWriter();
		Enumeration<String> parameters = request.getParameterNames();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Ejemplo 4: Parámetros en la query string</h1>");
		out.println("<ol>");
		while (parameters.hasMoreElements()) {
			String parameter = parameters.nextElement();
			String[] valoresString = request.getParameterValues(parameter);
			String valores = "";
			for (String valorString : valoresString) {
				valores += valorString + ",";

			}
			out.println("<li>" + parameter + "= " + valores + "</li>");
		}
		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
