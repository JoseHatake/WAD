package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.escom.wad.mapeo.Usuario;

/**
 * Servlet implementation class Ejemplo7B
 */
public class Ejemplo7B extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo7B() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Usuario u=(Usuario)request.getAttribute("mx.escom.ipn.wad.servlets.usuario");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Bienvenido "+u.getLogin()+"</h1>");
		out.println("</body>");
		out.println("</html>");

	}

}
