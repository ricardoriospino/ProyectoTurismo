package proyectoServicio.demo.service.impl;

import java.util.List;

import proyectoServicio.demo.dao.RolDAO;
import proyectoServicio.demo.dao.impl.RolDAOImpl;
import proyectoServicio.demo.jpa.entity.RolJPA;
import proyectoServicio.demo.service.RolService;

public class RolServiceImpl implements RolService {

	private RolDAO rolDAO;
	
	public RolServiceImpl() {
		rolDAO = new RolDAOImpl();
	}
	@Override
	public RolJPA getRolById(int id) {
		
		return rolDAO.getRolById(id);
	}
	@Override
	public RolJPA getRolByDescripcion(String descripcion) {
		
		return rolDAO.getRolByDescripcion(descripcion);
	}
	@Override
	public List<RolJPA> listarRol() {
		
		return rolDAO.listarRol();
	}

}
