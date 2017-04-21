package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.ipn.escom.wad.mapeo.Usuario;

/**
 * Servlet implementation class Ejemplo10D
 */
public class Ejemplo10D extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo10D() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Información de la sesión HTTP</h1>");
		out.println("<ul>");
		out.println("<li>Hora de creacion: "+new Date(session.getCreationTime())+"</li>");
		out.println("<li>ID: "+session.getId()+"</li>");
		out.println("<li>Hora del último acceso: "+new Date(session.getLastAccessedTime())+"</li>");
		out.println("<li>Tiempo máximo de inactividad: "+(session.getMaxInactiveInterval()/60)+"</li>");
		out.println("<li> ¿Es nueva?: "+session.isNew()+"</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}
