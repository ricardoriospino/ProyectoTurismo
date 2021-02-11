package proyectoServicio.demo.service;

import java.util.List;

import proyectoServicio.demo.jpa.entity.RolJPA;

public interface RolService {
	
	public RolJPA getRolById (int id);
	
	public RolJPA getRolByDescripcion (String descripcion);
	
	public List<RolJPA> listarRol();

}
