package proyectoServicio.demo.dao.impl;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.turismo.ServicioDAO;
import proyectoServicio.demo.jpa.entity.ServicioJPA;



public class ServicioDAOImpl implements ServicioDAO {
	
	private static final Logger log= LogManager.getLogger(ServicioDAOImpl.class);

	@Override
	public ServicioJPA getServicioById(int id) {
		
		EntityManager manager = null;
		ServicioJPA servicio = null;
		
		try {
			manager = JPAUtil.getEntityManager();
			servicio = manager.find(ServicioJPA.class, id);
			
			if(servicio ==null) {
				log.warn("No existe servicio con el id : " + id);
			}
			
		} catch (Exception e) {
			log.error("Error al consultar: " + e);
		}finally {
			manager.close();
		}
		return servicio;
	}

}
