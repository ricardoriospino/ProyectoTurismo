package proyectoServicio.demo.service.impl;

import proyectoServicio.demo.dao.MenuDAO;
import proyectoServicio.demo.dao.impl.MenuDAOImpl;
import proyectoServicio.demo.jpa.entity.MenuJPA;
import proyectoServicio.demo.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;
	
	public MenuServiceImpl() {
		menuDAO = new MenuDAOImpl();
	}
	@Override
	public MenuJPA getMenuById(int id) {
		
		return  menuDAO.getMenuById(id);
	}

}
