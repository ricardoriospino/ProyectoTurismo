package proyectoServicio.demo.dao;

import proyectoServicio.demo.jpa.entity.RolJPA;

public interface RolDAO {
	
	public RolJPA getRolById (int id);
	
	public RolJPA getRolByDescripcion (String descripcion);

}
