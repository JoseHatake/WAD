package mx.ipn.escom.wad.controlacceso.bs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.wad.controlacceso.bs.exception.LoginDuplicatedException;
import mx.ipn.escom.wad.controlacceso.dao.UsuarioDao;
import mx.ipn.escom.wad.controlacceso.mapeo.Usuario;

@Service("usuarioBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioBs {
	@Autowired
	private UsuarioDao usuarioDao;

	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}

	@Transactional(readOnly = true)
	public Usuario findById(Integer idUsuario) {
		return usuarioDao.findById(idUsuario);
	}

	@Transactional(rollbackFor = Exception.class)
	public Usuario save(Usuario usuario) throws LoginDuplicatedException{
		Usuario example = new Usuario();
		example.setLogin(usuario.getLogin());
		List<Usuario> listUsuarios = usuarioDao.findByExample(example);
		if (listUsuarios.isEmpty()) {
			return usuarioDao.save(usuario);
		} else {
			throw new LoginDuplicatedException();
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public Usuario update(Usuario usuario) {
		Usuario model = findById(usuario.getId());
		model.setNombre(usuario.getNombre());
		model.setPrimerApellido(usuario.getPrimerApellido());
		model.setSegundoApellido(usuario.getSegundoApellido());
		model.setNacimiento(usuario.getNacimiento());
		return usuarioDao.update(model);
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(Integer idUsuario) {
		usuarioDao.delete(idUsuario);
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
