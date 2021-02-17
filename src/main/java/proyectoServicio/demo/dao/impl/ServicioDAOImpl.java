package proyectoServicio.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.ls.LSInput;

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

	@Override
	public List<ServicioJPA> listarServiciosTour(int idTour) {
		
		EntityManager manager = null;
		List<ServicioJPA>lst = new ArrayList<ServicioJPA>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql =("SELECT a " +
						"FROM ServicioJPA AS a ,IncluyeJPA AS b " +
						"WHERE a.idServicio = b.servicio.idServicio " +
						"AND b.lugarTuristico.idLugarTuristico = :p_idTour ");	
			log.debug("el hql trae" + hql);

			Query q = manager.createQuery(hql);
			q.setParameter("p_idTour", idTour);
			
			lst = (List<ServicioJPA>) q.getResultList();
				
		} catch (NoResultException e) {
			e.printStackTrace();
			log.error("Error al realizar la listarServiciosTour : " + e);
		}finally {
			manager.close();
		}
		return lst;
	}

	@Override
	public List<ServicioJPA> listarServicios() {
		
		EntityManager manager = null;
		List<ServicioJPA>lst = new ArrayList<ServicioJPA>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql =("SELECT a FROM ServicioJPA a  ");
			
			Query q = manager.createQuery(hql);
			lst = (List<ServicioJPA>) q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la listarServicios : " + e);
			
		}finally {
			manager.close();
		
		}
		return lst;
	}

}
