package proyectoServicio.demo.service.impl;

import java.util.List;

import proyectoServicio.demo.dao.UsuarioDAO;
import proyectoServicio.demo.dao.impl.UsuarioDAOImpl;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;
import proyectoServicio.demo.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioDAO usuarioDAO;
	
	public UsuarioServiceImpl() {
		usuarioDAO = new UsuarioDAOImpl();
	}
	@Override
	public UsuarioJPA getUsuarioById(int id) {
		
		return usuarioDAO.getUsuarioById(id);
	}
	@Override
	public UsuarioJPA validarUsuarioClave(String usuario, String clave) {
		
		return usuarioDAO.validarUsuarioClave(usuario, clave);
	}
	@Override
	public List<UsuarioJPA> listarUsuarios() {
		
		return usuarioDAO.listarUsuarios();
	}
	@Override
	public UsuarioJPA obtenerUsuarioById(int idUsuario) {
		
		return usuarioDAO.obtenerUsuarioById(idUsuario);
	}
	@Override
	public Long obtenerUsuarioCompra(int idUsuario) {
		
		return usuarioDAO.obtenerUsuarioCompra(idUsuario);
	}
	@Override
	public Long validarUsuario(String usuario) {
		
		return usuarioDAO.validarUsuario(usuario);
	}

}
