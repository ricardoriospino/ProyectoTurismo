package proyectoServicio.demo.dao;

import java.util.List;

import proyectoServicio.demo.jpa.entity.RolJPA;

public interface RolDAO {
	
	public RolJPA getRolById (int id);
	
	public RolJPA getRolByDescripcion (String descripcion);
	
	public List<RolJPA> listarRol();

}
