package proyectoServicio.demo.service.impl;

import java.util.List;

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
	@Override
	public MenuJPA getMenuByCodigo(String codigo) {
		
		return menuDAO.getMenuByCodigo(codigo);
	}
	@Override
	public List<MenuJPA> listarMenu() {
		
		return menuDAO.listarMenu();
	}

}
