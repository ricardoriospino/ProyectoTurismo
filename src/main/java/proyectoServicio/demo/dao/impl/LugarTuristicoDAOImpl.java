package proyectoServicio.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

	@Override
	public List<LugarTuristicoJPA> listarLugaresTuristicos() {
		
		EntityManager manager = null;
		List<LugarTuristicoJPA>lst = new ArrayList<LugarTuristicoJPA>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql = "SELECT lt FROM LugarTuristicoJPA lt";
			Query q = manager.createQuery(hql);
			LugarTuristicoJPA lugarTuristico = null;
			
			lst =(List<LugarTuristicoJPA>) q.getResultList();
			
		} catch (NoResultException e) {
			e.printStackTrace();
			log.error("Error al realizar la validacion : " + e);
			
		}finally {
			manager.close();
		}
		return lst;
	}

	@Override
	public LugarTuristicoJPA obtenerLugaresTuristicosByid(int idLugarTuristico) {
		
		EntityManager manager = null;
		LugarTuristicoJPA lugarTuristico = null;
		
		try {
				
			manager = JPAUtil.getEntityManager();
			String hql= "SELECT olt FROM LugarTuristicoJPA olt WHERE olt.idLugarTuristico = :p_id ";
			Query q = manager.createQuery(hql);
			q.setParameter("p_id", idLugarTuristico );
			
			lugarTuristico = (LugarTuristicoJPA) q.getSingleResult();
			
		} catch (NoResultException e) {
			e.printStackTrace();
			log.error("Error al realizar la validacion : " + e);
			
		}finally {
			manager.close();
		}
	
		return lugarTuristico;
	}



}
