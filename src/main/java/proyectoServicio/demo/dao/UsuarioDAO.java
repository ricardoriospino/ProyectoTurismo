package proyectoServicio.demo.dao;

import java.util.List;

import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public interface UsuarioDAO {
	
	public UsuarioJPA getUsuarioById (int id);
	
	public UsuarioJPA validarUsuarioClave (String usuario, String clave);
	
	public List<UsuarioJPA> listarUsuarios ();

	public UsuarioJPA obtenerUsuarioById(int idUsuario);
	

}
