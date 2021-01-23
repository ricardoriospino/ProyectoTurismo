package proyectoServicio.demo.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.ServicioDAO;
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

	@Override
	public ServicioJPA getServicioByTipoServicio(String tipoServicio) {
		
		EntityManager  em = JPAUtil.getEntityManager();
		String hql = "SELECT s FROM ServicioJPA s WHERE s.nombreServicio = :p_nombre";
		Query q = em.createQuery(hql);
		q.setParameter("p_nombre", tipoServicio );
		ServicioJPA servicio = (ServicioJPA) q.getSingleResult();
		
		return servicio;
	}

}
