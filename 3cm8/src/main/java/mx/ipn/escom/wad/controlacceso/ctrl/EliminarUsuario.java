package mx.ipn.escom.wad.controlacceso.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.controlacceso.bs.UsuarioBs;
import mx.ipn.escom.wad.controlacceso.mapeo.Usuario;

/**
 * Servlet implementation class EliminarUsuario
 */
public class EliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsuarioBs usuarioBs;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		Usuario usuario = usuarioBs.findById(idUsuario);
		RequestDispatcher rd = request.getRequestDispatcher("usuarios/eliminar.jsp");
		request.setAttribute("usuario", usuario);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		usuarioBs.delete(idUsuario);
		response.sendRedirect("GestionarUsuarioCtrl");
	}

	public UsuarioBs getUsuarioBs() {
		return usuarioBs;
	}

	public void setUsuarioBs(UsuarioBs usuarioBs) {
		this.usuarioBs = usuarioBs;
	}

}
