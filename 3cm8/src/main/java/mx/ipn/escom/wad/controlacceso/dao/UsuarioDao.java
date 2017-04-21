package mx.ipn.escom.wad.controlacceso.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.wad.controlacceso.mapeo.Usuario;

@Service("usuarioDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioDao {
	@Autowired
	private SessionFactory sessionFactory;
	private String QUERY_1 = "select * from usuario as u inner join persona as p on (u.id_usuario=p.id_persona)";

	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class).list();
		// return
		// sessionFactory.getCurrentSession().createSQLQuery(QUERY_1).addEntity(Usuario.class).list();
	}

	public Usuario save(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
		return usuario;
	}

	public Usuario update(Usuario usuario) {
		sessionFactory.getCurrentSession().merge(usuario);
		sessionFactory.getCurrentSession().update(usuario);
		return usuario;
	}

	public Usuario findById(Integer idUsuario) {
		return sessionFactory.getCurrentSession().load(Usuario.class, idUsuario);
	}

	public void delete(Integer idUsuario) {
		Query q = sessionFactory.getCurrentSession().getNamedQuery("deleteUsuario");
		q.setParameter("idUsuario", idUsuario);
		q.executeUpdate();
	}

	public List<Usuario> findByExample(Usuario example) {
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class).add(Example.create(example)).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
