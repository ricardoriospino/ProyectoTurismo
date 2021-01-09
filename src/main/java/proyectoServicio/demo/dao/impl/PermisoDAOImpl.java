package proyectoServicio.demo.dao.impl;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.turismo.PermisoDAO;
import proyectoServicio.demo.jpa.entity.PermisoJPA;



public class PermisoDAOImpl implements PermisoDAO {
	
	private static final Logger log= LogManager.getLogger(PermisoDAOImpl.class);

	@Override
	public PermisoJPA getPermisoById(int id) {
		
		EntityManager manager = null;
		PermisoJPA permiso = null;
		try {
			manager = JPAUtil.getEntityManager();
			permiso = manager.find(PermisoJPA.class, id);
			
			if(permiso == null) {
				log.warn("No existe permiso con el id : " + id);
			}
		} catch (Exception e) {
			log.error("Error al consultar: " + e);
		}finally {
			manager.close();
		}
		return permiso;
	}

}
