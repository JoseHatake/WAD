package mx.ipn.escom.wad.controlacceso.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@NamedQuery(name="deleteUsuario",query="delete from Usuario where id = :idUsuario")

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "id_usuario", referencedColumnName = "id_persona")
public class Usuario extends Persona {
	@Column(name = "tx_login")
	private String login;

	@Column(name = "tx_password")
	private String password;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", nacimiento=" + nacimiento + ", direccion=" + direccion + "]";
	}
}
