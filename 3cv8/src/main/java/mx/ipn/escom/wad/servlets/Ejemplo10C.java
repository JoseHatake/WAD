package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.servlets.mapeo.Usuario;

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
		System.out.println("Ejemplo10C: GET");
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		session.removeAttribute("usuario");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Session:" + u.getLogin() + " " + u.getPassword() + "</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
