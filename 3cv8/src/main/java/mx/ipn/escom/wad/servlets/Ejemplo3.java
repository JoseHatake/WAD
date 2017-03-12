package mx.ipn.escom.wad.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejemplo3
 */
public class Ejemplo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Enumeration<String> parameters=request.getParameterNames();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Ejemplo 3: Parámetros en la query string</h1>");
		out.println("<ol>");
		while(parameters.hasMoreElements()){
			String parameter = parameters.nextElement();
			Integer value = Integer.parseInt(request.getParameter(parameter));
			out.println("<li>"+parameter+"= "+value+"</li>");
		}
		out.println("</ol>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
