package proyectoServicio.demo.dao;

import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public interface UsuarioDAO {
	
	public UsuarioJPA getUsuarioById (int id);
	
	public UsuarioJPA validarUsuarioClave (String usuario, String clave);
	

}
