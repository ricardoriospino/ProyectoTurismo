package proyectoServicio.demo.dao;

import java.util.List;

import proyectoServicio.demo.jpa.entity.MenuJPA;

public interface MenuDAO {
	
	public MenuJPA getMenuById (int id);
	
	public MenuJPA getMenuByCodigo (String codigo);
	
	public List<MenuJPA> listarMenu();

	public List<MenuJPA> listarMenuByRol(int idRol);

}
