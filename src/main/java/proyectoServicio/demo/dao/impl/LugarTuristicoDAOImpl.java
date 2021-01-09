package proyectoServicio.demo.dao.impl;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.turismo.LugarTuristicoDAO;
import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;



public class LugarTuristicoDAOImpl implements LugarTuristicoDAO {
	
	private static final Logger log= LogManager.getLogger(LugarTuristicoDAOImpl.class);

	@Override
	public LugarTuristicoJPA getLugarTuristicoById(int id) {
		
		EntityManager manager = null;
		LugarTuristicoJPA lugarTuristico = null;
		
		try {
			manager = JPAUtil.getEntityManager();
			lugarTuristico = manager.find(LugarTuristicoJPA.class, id);
			if(lugarTuristico == null) {
				log.warn("No existe lugar Turistico con el id : " + id);
			}
			
		} catch (Exception e) {
			log.error("Error al consultar: " + e);
		}finally {
			manager.close();
		}
		return lugarTuristico;
	}

}
