package mx.ipn.escom.wad.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.ipn.escom.wad.mapeo.Usuario;

/**
 * Servlet implementation class Ejemplo7A
 */
public class Ejemplo7A extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		//Simula autenticación
		Usuario u =  new Usuario(usuario,password);
		RequestDispatcher rd = request.getRequestDispatcher("Ejemplo7B");
		request.setAttribute("mx.ipn.escom.wad.servlets.usuario", u);
		rd.forward(request, response);
	}

}
