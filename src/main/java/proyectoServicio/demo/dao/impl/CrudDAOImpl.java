package proyectoServicio.demo.dao.impl;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.CrudDAO;

public class CrudDAOImpl implements CrudDAO {
	
	private static final Logger log= LogManager.getLogger(CrudDAOImpl.class);

	@Override
	public void insertar(Object objeto) {
		
			log.info("ini:  insertar");
		
		// obtiene una cadena conexion de BD 
				EntityManager manager = null;
				
				try {
					manager = JPAUtil.getEntityManager();
					manager.getTransaction().begin(); 
					manager.persist(objeto);// Genera el query de insert a la BD
					manager.flush();// enviar en cola si hay varias sentencias en espera 
					manager.getTransaction().commit();
					
				} catch (Exception e) {
					manager.getTransaction().rollback();
					e.printStackTrace();
					
				}finally {
					manager.close();
				}
				
			log.info("fin:  insertar");
			}
	

	@Override
	public void actualizar(Object objeto) {
		
		log.info("fin:  actualizar");
		
		EntityManager manager = null;
		try {
			
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin(); 
			manager.merge(objeto); // merge para actualizar 
			manager.flush();
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
			log.error("Error al actualizar: " + e);
			
		}finally {
			manager.close();
		}
		
		log.info("fin:  actualizar");
		
	}


	@Override
	public int eliminar(Object objeto) {
		
		
		log.info("ini:  eliminar");
		
		int exito = 1;
		EntityManager manager = null;
		try {
			
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin(); 
			manager.remove(manager.merge(objeto));// primero sincronizamos y luego eliminamos // elimina la base de datos 
			manager.flush();
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			log.error("Error al eliminar: " + e);
			exito = 0;
			
		}finally {
			manager.close();		
		}
		
		log.info("fin:  eliminar");
		return exito;
		
		
	}	
			
}


