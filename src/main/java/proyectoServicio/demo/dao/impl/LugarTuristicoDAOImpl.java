package proyectoServicio.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.LugarTuristicoDAO;
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

	@Override
	public LugarTuristicoJPA getLugarTuristicoByNombre(String nombre) {
		
		EntityManager  em = JPAUtil.getEntityManager();
		String hql = "SELECT lt FROM LugarTuristicoJPA lt WHERE lt.nombre = :p_nombre";
		Query q = em.createQuery(hql);
		q.setParameter("p_nombre", nombre);
		LugarTuristicoJPA lugarTuristico = (LugarTuristicoJPA) q.getSingleResult();
		return lugarTuristico ;
	}

}
