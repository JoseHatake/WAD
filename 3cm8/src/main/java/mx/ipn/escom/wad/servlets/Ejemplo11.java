package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo11
 */
public class Ejemplo11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer parametro1;
	private Integer parametro2;
	private Boolean parametro3;

	public void init(ServletConfig config) {
		try {
			parametro1 = Integer.valueOf(config.getInitParameter("parametro1"));
			parametro2 = Integer.valueOf(config.getInitParameter("parametro2"));
			parametro3 = Boolean.valueOf(config.getInitParameter("parametro3"));
		} catch (NumberFormatException nfe) {
			System.err.println("-->" + nfe.getMessage());
			nfe.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Ejemplo11() {
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
		out.println("<h1>Servlets: parámetros de inicialización</h1>");
		out.println("<ul>");
		out.println("<li> Parametro1: " + parametro1 + "</li>");
		out.println("<li> Parametro2: " + parametro2 + "</li>");
		out.println("<li> Parametro3: " + parametro3 + "</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

	public Integer getParametro1() {
		return parametro1;
	}

	public void setParametro1(Integer parametro1) {
		this.parametro1 = parametro1;
	}

	public Integer getParametro2() {
		return parametro2;
	}

	public void setParametro2(Integer parametro2) {
		this.parametro2 = parametro2;
	}

	public Boolean getParametro3() {
		return parametro3;
	}

	public void setParametro3(Boolean parametro3) {
		this.parametro3 = parametro3;
	}
}
