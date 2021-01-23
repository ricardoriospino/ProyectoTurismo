package proyectoServicio.demo.service.impl;

import proyectoServicio.demo.dao.CrudDAO;
import proyectoServicio.demo.dao.impl.CrudDAOImpl;
import proyectoServicio.demo.service.CRUDService;

public class CRUDServiceImpl implements CRUDService {
	
	CrudDAO crudDAO;
	
	 public CRUDServiceImpl(){
		crudDAO = new CrudDAOImpl();
	}

	@Override
	public void insertar(Object objeto) {
		crudDAO.insertar(objeto);
		
	}

	@Override
	public void actualizar(Object objeto) {
		crudDAO.actualizar(objeto);
		
	}

	@Override
	public void eliminar(Object objeto) {
		crudDAO.eliminar(objeto);
		
	}

}
