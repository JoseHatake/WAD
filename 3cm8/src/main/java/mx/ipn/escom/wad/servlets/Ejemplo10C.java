package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.mapeo.Usuario;

/**
 * Servlet implementation class Ejemplo10C
 */
public class Ejemplo10C extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo10C() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		session.removeAttribute("usuario");
		Usuario u = (Usuario) session.getAttribute("usuario");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		try{
		out.println("<h1>Bienvenido " + u.getLogin() + "</h1>");
		} catch (NullPointerException npe) {
			out.println("<h1>Bienvenido el usuario ya no esta en la sesión </h1>");
			System.out.println("El usuario es null");
		}
		out.println("</body>");
		out.println("</html>");

	}

}
