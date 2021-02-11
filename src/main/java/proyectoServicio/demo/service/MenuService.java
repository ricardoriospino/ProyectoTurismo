package proyectoServicio.demo.service;

import java.util.List;

import proyectoServicio.demo.jpa.entity.MenuJPA;

public interface MenuService {
	
	public MenuJPA getMenuById (int id);
	
	public MenuJPA getMenuByCodigo (String codigo);
	
	public List<MenuJPA> listarMenu();
	
	public List<MenuJPA> listarMenuByRol (int idRol );

}
