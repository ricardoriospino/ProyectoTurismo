package proyectoServicio.demo.dao;

import proyectoServicio.demo.jpa.entity.PermisoJPA;

public interface PermisoDAO {
	
	public PermisoJPA getPermisoById(int id);
	
	public PermisoJPA getPermisoByDescripcion (String descripcion);

}
