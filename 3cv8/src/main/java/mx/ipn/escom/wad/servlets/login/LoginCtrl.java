package mx.ipn.escom.wad.servlets.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCtrl
 */
public class LoginCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtrl() {
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
		out.println("<html>");
		out.println("<h1>Login</h1>");
		out.println("<form action=\"LoginCtrl\" method=\"post\">");
		out.println("Usuario: <input name=\"usuario\" /><br />");
		out.println("Contraseña: <input name=\"password\"><br />");
		out.println("<input type=\"submit\" value=\"Aceptar\">");
		out.println("</form>");
		out.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password=request.getParameter("password");
		if(password!=null&&!password.equals("")&&usuario!=null&&!usuario.equals("")){
			System.out.println("Sin errores");
			RequestDispatcher rd = request.getRequestDispatcher("BienvenidoCtrl");
			rd.forward(request, response);
			
		} else {
			System.out.println("Con errores");
			response.sendRedirect("LoginCtrl");
		}
	}

}
