package proyectoServicio.demo.dao.impl;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.turismo.MenuDAO;
import proyectoServicio.demo.jpa.entity.MenuJPA;



public class MenuDAOImpl implements MenuDAO {
	
	private static final Logger log= LogManager.getLogger(MenuDAOImpl.class);

	@Override
	public MenuJPA getMenuById(int id) {
		
		EntityManager manager = null;
		MenuJPA menu = null;
		
		try {
			
			manager = JPAUtil.getEntityManager();
			menu = manager.find(MenuJPA.class, id);
			
			if(menu == null) {
				log.warn("No existe menu con el id : " + id);
			}
			
		} catch (Exception e) {
			log.error("Error al consultar: " + e);
		}finally {
			manager.close();
		}
		
		return menu;
	}

}
