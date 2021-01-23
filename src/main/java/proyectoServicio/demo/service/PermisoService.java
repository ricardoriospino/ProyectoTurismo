package proyectoServicio.demo.service;

import proyectoServicio.demo.jpa.entity.PermisoJPA;

public interface PermisoService {
	
	public PermisoJPA getPermisoById(int id);
	
	public PermisoJPA getPermisoByDescripcion (String descripcion);

}
