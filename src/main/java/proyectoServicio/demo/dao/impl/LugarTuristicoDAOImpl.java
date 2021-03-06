package proyectoServicio.demo.dao.impl;

import java.util.ArrayList;
import java.util.Date;
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
	public Long validarTourExist(String codigo) {
		
		EntityManager manager = null;
		
		Long  tourExistente = 0L;
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql ="SELECT COUNT(a) FROM LugarTuristicoJPA a " +
						" WHERE a.codigoLugarTuristico = :p_codigoTour ";
			
			Query q = manager.createQuery(hql);
			q.setParameter("p_codigoTour", codigo );
			
			tourExistente = (Long) q.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar validarTourExist  : " + e);
		}finally {
			manager.close();
		}
		
		return tourExistente;
	}

	@Override
	public int actualizarPrecioPaquete(int idTour, double costoNuevo) {
		
		EntityManager manager = null;
		int exito = 1;

		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin(); 
			String hql =("UPDATE LugarTuristicoJPA SET precioXpersona = :p_costoNuevo " +
					 	 " WHERE idLugarTuristico = :p_idTour ");
			
			Query q = manager.createQuery(hql);
			q.setParameter("p_idTour", idTour);
			q.setParameter("p_costoNuevo",costoNuevo );
			q.executeUpdate();
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			log.error("Error al realizar actualizarPrecioPaquete  : " + e);
			exito = 0;
		}finally {
			manager.close();
		}
		
		return exito;
	}

	@Override
	public int actualizarAuditoriaPaquete(int idTour, String modificadoPor, Date fechaModificada) {
		
		EntityManager manager = null;
		int exito = 1;
		
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin(); 
			String hql =("UPDATE LugarTuristicoJPA SET modificadoPor = :p_modificadoPor , fechaUpdate = :p_fechaModificada " +
				 	 " WHERE idLugarTuristico = :p_idTour ");
			
			Query q = manager.createQuery(hql);
			q.setParameter("p_idTour", idTour);
			q.setParameter("p_modificadoPor",modificadoPor );
			q.setParameter("p_fechaModificada",fechaModificada );
			q.executeUpdate();
			manager.getTransaction().commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			log.error("Error al realizar actualizarPrecioPaquete  : " + e);
			exito = 0;
		}finally {
			manager.close();
		}
		return exito;
	}
}
