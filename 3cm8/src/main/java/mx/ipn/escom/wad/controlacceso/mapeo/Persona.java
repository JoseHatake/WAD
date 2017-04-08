package mx.ipn.escom.wad.controlacceso.mapeo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona {
	@Id
	//@SequenceGenerator(name = "idSeq", sequenceName = "")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_persona")
	protected Integer id;

	@Column(name = "nb_persona")
	protected String nombre;

	@Column(name = "tx_primer_ap")
	protected String primerApellido;

	@Column(name = "tx_segundo_ap")
	protected String segundoApellido;

	@Column(name = "fh_nacimiento")
	protected Date nacimiento;

	@OneToOne(optional=true)
	@JoinColumn(name="id_persona",referencedColumnName="id_persona",insertable=false,updatable=false)
	protected Direccion direccion;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the primerApellido
	 */
	public String getPrimerApellido() {
		return primerApellido;
	}

	/**
	 * @param primerApellido
	 *            the primerApellido to set
	 */
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	/**
	 * @return the segundoApellido
	 */
	public String getSegundoApellido() {
		return segundoApellido;
	}

	/**
	 * @param segundoApellido
	 *            the segundoApellido to set
	 */
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	/**
	 * @return the nacimiento
	 */
	public Date getNacimiento() {
		return nacimiento;
	}

	/**
	 * @param nacimiento
	 *            the nacimiento to set
	 */
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
}
