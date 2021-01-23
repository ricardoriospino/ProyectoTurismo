package proyectoServicio.demo.service;

import proyectoServicio.demo.jpa.entity.RolJPA;

public interface RolService {
	
	public RolJPA getRolById (int id);
	
	public RolJPA getRolByDescripcion (String descripcion);

}
