package mx.ipn.escom.wad.controlacceso.ctrl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ipn.escom.wad.controlacceso.bs.UsuarioBs;
import mx.ipn.escom.wad.controlacceso.bs.exception.LoginDuplicatedException;
import mx.ipn.escom.wad.controlacceso.mapeo.Usuario;
import mx.ipn.escom.wad.util.FieldErrors;

/**
 * Servlet implementation class RegistrarUsuario
 */
public class RegistrarUsuario extends HttpServlet {
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
	public RegistrarUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("usuarios/registrar.jsp");
		Usuario usuario = new Usuario();
		FieldErrors fieldErrors = new FieldErrors();
		request.setAttribute("usuario", usuario);
		request.setAttribute("fieldErrors", fieldErrors);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FieldErrors fieldErrors = new FieldErrors();
		Usuario usuario = obtenerUsuario(request, fieldErrors);
		try {
			if (!fieldErrors.hasFieldErrors()) {
				usuarioBs.save(usuario);
				response.sendRedirect("GestionarUsuarioCtrl");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("usuarios/registrar.jsp");
				request.setAttribute("usuario", usuario);
				request.setAttribute("fieldErrors", fieldErrors);
				rd.forward(request, response);
			}
		} catch (LoginDuplicatedException lde) {
			RequestDispatcher rd = request.getRequestDispatcher("usuarios/registrar.jsp");
			request.setAttribute("usuario", usuario);
			String mensaje = "El login proporcionado ya se encuentra registrado";
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("fieldErrors", fieldErrors);
			rd.forward(request, response);
		}
	}

	private Usuario obtenerUsuario(HttpServletRequest request, FieldErrors errors) {
		Usuario u = new Usuario();
		String nombre = request.getParameter("nombre");
		if (nombre == null || nombre != null && nombre.equals("")) {
			errors.add("nombre", "Favor de proporcionar el nombre");
		} else {
			u.setNombre(nombre);
		}
		String primerApellido = request.getParameter("primerApellido");
		if (primerApellido == null || primerApellido != null && primerApellido.equals("")) {
			errors.add("primerApellido", "Favor de proporcionar el primer apellido");
		} else {
			u.setPrimerApellido(primerApellido);
		}
		String segundoApellido = request.getParameter("segundoApellido");
		if (segundoApellido == null || segundoApellido != null && segundoApellido.equals("")) {
			errors.add("segundoApellido", "Favor de proporcionar el segundo apellido");
		} else {
			u.setSegundoApellido(segundoApellido);
		}
		String fechaString = request.getParameter("nacimiento");
		if(fechaString==null||fechaString!=null&&fechaString.equals("")){
			errors.add("nacimiento", "Favor de proporcionar la fecha de nacimiento");
		} else {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date nacimiento = null;
			System.out.println("ELSE----->");
			try {
				nacimiento = format.parse(fechaString);
				u.setNacimiento(nacimiento);
			} catch (ParseException pe) {
				pe.printStackTrace();
				errors.add("nacimiento", "El formato de la fecha es incorrecto (dd/mm/aaaa)");
			}
		}
		String login = request.getParameter("login");
		if (login == null || login != null && login.equals("")) {
			errors.add("login", "Favor de proporcionar el login");
		} else {
			u.setLogin(login);
		}
		String password = request.getParameter("password");
		if (password == null || password != null && password.equals("")) {
			errors.add("password", "Favor de proporcionar el password");
		} else {
			u.setPassword(password);
		}
		return u;
	}

	public UsuarioBs getUsuarioBs() {
		return usuarioBs;
	}

	public void setUsuarioBs(UsuarioBs usuarioBs) {
		this.usuarioBs = usuarioBs;
	}
}
