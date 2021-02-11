package proyectoServicio.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.UsuarioDAO;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;



public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static final Logger log= LogManager.getLogger(UsuarioDAOImpl.class);

	@Override
	public UsuarioJPA getUsuarioById(int id) {
		
		EntityManager manager = null;
		UsuarioJPA usuario = null;
		
		try {
			 manager = JPAUtil.getEntityManager();
			usuario = manager.find(UsuarioJPA.class, id);
			if(usuario == null) {
				 log.warn("No existe usuario con el id : " + id);
			}
		} catch (Exception e) {
			log.error("Error al consultrar: " + e);
		}finally {
			manager.close();
		}
		
		return usuario;
	}
	
	

	@Override
	public UsuarioJPA validarUsuarioClave(String usuario, String clave) {
		
		
		
		EntityManager manager = null;
		UsuarioJPA permisoUsuario = null;
		
		try {
			 manager = JPAUtil.getEntityManager();
			
			String hql = "SELECT v FROM UsuarioJPA v WHERE v.usuario = :p_usuario AND v.clave = :p_clave";
			Query q = manager.createQuery(hql);
			q.setParameter("p_usuario", usuario);
			q.setParameter("p_clave", clave);
			
			
			List<UsuarioJPA> usuarios = q.getResultList();
			
			// cuando la lista es vacia entra a isEmty
			if (usuarios.isEmpty()){ 
			log.warn("No existe usuario :  " + permisoUsuario);
			return null;
			}
			else if(usuarios.size() > 1) log.error("Usuario duplicado"); 
			
			else if (usuarios.size() == 1) return usuarios.get(0);
			
			
			 
			permisoUsuario = (UsuarioJPA)  q.getResultList();
			
			
			if (permisoUsuario == null) {
				log.warn("No existe usuario :  " + permisoUsuario);
			}
		} catch (NoResultException e) {
			e.printStackTrace();
			log.error("Error al realizar la validacion : " + e);
		} finally {
			manager.close();
		}
		return permisoUsuario ;
	}



	@Override
	public List<UsuarioJPA> listarUsuarios() {
		
		EntityManager manager = null;
		List<UsuarioJPA> lst = new ArrayList<UsuarioJPA>();
		
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql =("SELECT b  " +
						 "FROM RolJPA AS a , UsuarioJPA AS b " +
						 "WHERE a.idRol = b.rol.idRol ");
			
			Query q = manager.createQuery(hql);
			lst = (List<UsuarioJPA>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la validacion : " + e);
			
		}finally {
			manager.close();
		}
		return lst;
	}



	@Override
	public UsuarioJPA obtenerUsuarioById(int idUsuario) {
		
		EntityManager manager = null;
		UsuarioJPA usuario = null;
		
		try {
			manager = JPAUtil.getEntityManager();
			String hql ="SELECT ou FROM UsuarioJPA ou WHERE ou.idUsuario = :p_idUsuario";
			Query q = manager.createQuery(hql);
			q.setParameter("p_idUsuario", idUsuario );
			
			usuario = (UsuarioJPA) q.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la validacion : " + e);
			
		}finally {
			manager.close();
		}
		return usuario;
	}

}
