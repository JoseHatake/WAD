package mx.ipn.escom.wad.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.HttpServletRequest;
import javax.servlet.HttpServletResponse;
import java.io.PrintWriter;
import java.io.exception;
import javax.servlet.ServletConfig;

public class HolaMundo extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		System.out.println("3CM8: Inicializando...");
	}

	public void destroy(){
		System.out.println("3CM8: Fin sel servicio");
	}

	public void doGet(HttpServletRequest reuqest, HttpServletResponse response){
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Document</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hola Mundo</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close;
	}
}