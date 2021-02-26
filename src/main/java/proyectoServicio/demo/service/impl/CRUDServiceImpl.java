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
	public int insertar(Object objeto) {
		 return crudDAO.insertar(objeto);
		
	}

	@Override
	public int actualizar(Object objeto) {
		return crudDAO.actualizar(objeto);
		
	}

	@Override
	public int eliminar(Object objeto) {
		return crudDAO.eliminar(objeto);
		
	}

}
