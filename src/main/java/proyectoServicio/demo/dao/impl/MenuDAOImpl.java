package proyectoServicio.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.MenuDAO;
import proyectoServicio.demo.jpa.entity.MenuJPA;



public class MenuDAOImpl implements MenuDAO {
	
	private static final Logger log= LogManager.getLogger(MenuDAOImpl.class);

	@Override
	public MenuJPA getMenuById(int id) {
		
		EntityManager manager = null;
		MenuJPA menu = null;
		
		try {
			
			manager = JPAUtil.getEntityManager();
			menu = manager.find(MenuJPA.class, id);
			
			if(menu == null) {
				log.warn("No existe menu con el id : " + id);
			}
			
		} catch (Exception e) {
			log.error("Error al consultar: " + e);
		}finally {
			manager.close();
		}
		
		return menu;
	}

	@Override
	public MenuJPA getMenuByCodigo(String codigo) {
		
		EntityManager  em = JPAUtil.getEntityManager();
		String hql = "SELECT m FROM MenuJPA m WHERE m.codigoMenu = :p_codigo";
		Query q = em.createQuery(hql);
		q.setParameter("p_codigo", codigo);
		MenuJPA menu = (MenuJPA) q.getSingleResult();
		return menu;
	}

	@Override
	public List<MenuJPA> listarMenu() {
		
		EntityManager manager = null;
		List<MenuJPA>lst = new ArrayList<MenuJPA>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql ="SELECT lm FROM MenuJPA lm ";
			Query q = manager.createQuery(hql);
			//MenuJPA menu =null;
			
			lst = (List<MenuJPA>) q.getResultList();
			
			//lst.add(menu);
			
		} catch (NoResultException e) {
			e.printStackTrace();
			log.error("Error al realizar la validacion : " + e);
			
		}finally {
			manager.close();
		
		}
		return lst;
	}

	@Override
	public List<MenuJPA> listarMenuByRol(int idRol) {
		
		EntityManager manager = null;
		List<MenuJPA>lst = new ArrayList<MenuJPA>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql="SELECT m FROM MenuJPA m ,RolMenuJPA rm " +
						"where m.idMenu = rm.menu.idMenu and rm.rol.idRol = :p_idRol";
			Query q = manager.createQuery(hql);
			
			q.setParameter("p_idRol", idRol);
			lst = (List<MenuJPA>) q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al cargar  : " + e);

		}finally {
			manager.close();
		
		}
		return lst;
	}

}
