package proyectoServicio.demo.service.impl;

import proyectoServicio.demo.dao.PermisoDAO;
import proyectoServicio.demo.dao.impl.PermisoDAOImpl;
import proyectoServicio.demo.jpa.entity.PermisoJPA;
import proyectoServicio.demo.service.PermisoService;

public class PermisoServiceImpl implements PermisoService {

	private PermisoDAO permisoDAO;
	
	public PermisoServiceImpl() {
		permisoDAO = new PermisoDAOImpl();
	}
	@Override
	public PermisoJPA getPermisoById(int id) {
		
		return permisoDAO.getPermisoById(id);
	}
	@Override
	public PermisoJPA getPermisoByDescripcion(String descripcion) {
		
		return permisoDAO.getPermisoByDescripcion(descripcion);
	}

}
