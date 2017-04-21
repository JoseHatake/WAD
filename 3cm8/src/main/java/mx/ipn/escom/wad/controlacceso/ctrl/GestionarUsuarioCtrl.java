package mx.ipn.escom.wad.controlacceso.ctrl;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class GestionarUsuarioCtrl
 */
public class GestionarUsuarioCtrl extends HttpServlet {
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
    public GestionarUsuarioCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioBs.findAll();
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher rd=request.getRequestDispatcher("usuarios/index.jsp");
		rd.forward(request, response);
	}

	public UsuarioBs getUsuarioBs() {
		return usuarioBs;
	}

	public void setUsuarioBs(UsuarioBs usuarioBs) {
		this.usuarioBs = usuarioBs;
	}
}
