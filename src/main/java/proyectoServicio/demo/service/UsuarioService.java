package proyectoServicio.demo.service;

import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public interface UsuarioService {
	
	public UsuarioJPA getUsuarioById (int id);
	
	public UsuarioJPA validarUsuarioClave (String usuario, String clave);

}
