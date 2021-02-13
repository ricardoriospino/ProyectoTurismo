package proyectoServicio.demo.service;

import java.util.List;

import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public interface UsuarioService {
	
	public UsuarioJPA getUsuarioById (int id);
	
	public UsuarioJPA validarUsuarioClave (String usuario, String clave);
	
	public List<UsuarioJPA> listarUsuarios ();

	public UsuarioJPA obtenerUsuarioById(int idUsuario);
	
	public Long obtenerUsuarioCompra (int idUsuario);
	
	public Long validarUsuario (String usuario);

}
