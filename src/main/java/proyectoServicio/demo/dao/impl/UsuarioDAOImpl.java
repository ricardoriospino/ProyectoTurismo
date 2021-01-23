package proyectoServicio.demo.dao.impl;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.UsuarioDAO;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;



public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static final Logger log= LogManager.getLogger(UsuarioDAOImpl.class);

	@Override
	public UsuarioJPA getUsuarioById(int id) {
		
		EntityManager manager = null;
		UsuarioJPA usuario = null;
		
		try {
			 manager = JPAUtil.getEntityManager();
			usuario = manager.find(UsuarioJPA.class, id);
			if(usuario == null) {
				 log.warn("No existe usuario con el id : " + id);
			}
		} catch (Exception e) {
			log.error("Error al consultrar: " + e);
		}finally {
			manager.close();
		}
		
		return usuario;
	}

}
