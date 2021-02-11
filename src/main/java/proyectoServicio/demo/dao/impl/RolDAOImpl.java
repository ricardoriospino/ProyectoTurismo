package proyectoServicio.demo.dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.RolDAO;
import proyectoServicio.demo.jpa.entity.RolJPA;



public class RolDAOImpl implements RolDAO {
	
	private static final Logger log= LogManager.getLogger(RolDAOImpl.class);

	@Override
	public RolJPA getRolById(int id) {
		
		EntityManager manager = null;
		RolJPA rol = null;
		
		try {
			
			manager = JPAUtil.getEntityManager();
			rol = manager.find(RolJPA.class, id);
			
			if(rol == null) {
				 log.warn("No existe rol con el id : " + id);
			 }
			
			
		} catch (Exception e) {
			log.error("Error al consultrar: " + e);
		}finally {
			manager.close();
		}
		return rol;
	}

	@Override
	public RolJPA getRolByDescripcion(String descripcion) {
		
		EntityManager  em = JPAUtil.getEntityManager();
		String hql = "SELECT r FROM RolJPA r WHERE r.descripcion = :p_nombre";
		Query q = em.createQuery(hql);
		q.setParameter("p_nombre", descripcion);
		 RolJPA empleado = (RolJPA) q.getSingleResult();
		
		return empleado;
	}

	@Override
	public List<RolJPA> listarRol() {
		
		EntityManager manager = null;
		List<RolJPA>lst = new ArrayList<RolJPA>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql = "SELECT lr FROM RolJPA lr";
			Query q = manager.createQuery(hql);
			
			lst =(List<RolJPA>) q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la validacion : " + e);
			
		}finally {
			manager.close();
		}
		return lst;
	}

}
