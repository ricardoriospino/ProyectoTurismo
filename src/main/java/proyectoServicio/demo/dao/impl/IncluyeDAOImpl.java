package proyectoServicio.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.IncluyeDAO;
import proyectoServicio.demo.jpa.entity.IncluyeJPA;


public class IncluyeDAOImpl implements IncluyeDAO {
	private static final Logger log= LogManager.getLogger(IncluyeDAOImpl.class);

	@Override
	public List<IncluyeJPA> listaCostoServicios() {
		
		EntityManager manager = null;
		List<IncluyeJPA> lst = new ArrayList<IncluyeJPA>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql =("SELECT a FROM IncluyeJPA a  ");
			
			Query q = manager.createQuery(hql);
			lst = (List<IncluyeJPA>) q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la listaCostoServicios : " + e);
			
		}finally {
			manager.close();
		
		}
		return lst;
	}
	
	@Override
	public int eliminarServicios(int idTour) {
		EntityManager manager = null;
		int exito = 1;
		
		
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin(); 
			String hql =("DELETE FROM IncluyeJPA a WHERE a.lugarTuristico.idLugarTuristico = :p_idTour ");
			
			
			Query q = manager.createQuery(hql);
			q.setParameter("p_idTour", idTour);
			q.executeUpdate();
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			log.error("Error al eliminar: " + e);
			exito = 0;
		}finally {
			manager.close();		
		}
		return exito;
	}

}
