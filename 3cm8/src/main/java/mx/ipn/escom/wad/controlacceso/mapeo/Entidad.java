package mx.ipn.escom.wad.controlacceso.mapeo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="entidad")
public class Entidad {
	@Id
	//@SequenceGenerator(name="idSeq",sequenceName="")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idSeq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entidad")
	private Integer id;
	
	@Column(name="nb_entidad")
	private String nombre;

	@OneToMany(mappedBy="entidad")
	private List<Direccion> direcciones;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
}
