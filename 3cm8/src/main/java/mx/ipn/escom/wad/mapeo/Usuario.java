package mx.ipn.escom.wad.mapeo;

public class Usuario {
	public Usuario() {
		super();
	}

	public Usuario(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/**
	 * 
	 */
	private String nombre;
	
	/**
	 * 
	 */
	private String primerApellido;
	
	/**
	 * 
	 */
	private String segundoApellido;
	
	/**
	 * 
	 */
	private String login;
	
	/**
	 * 
	 */
	private String password;

	public Usuario(String nombre, String primerApellido, String segundoApellido, String login, String password) {
		super();
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.login = login;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
