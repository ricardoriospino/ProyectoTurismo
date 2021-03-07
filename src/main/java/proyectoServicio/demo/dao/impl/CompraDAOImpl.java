package proyectoServicio.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.Bean.carritoCompraBean;
import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.CompraDAO;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public class CompraDAOImpl implements CompraDAO {
	private static final Logger log= LogManager.getLogger(CompraDAOImpl.class);

	@Override
	public boolean insertarCompra(UsuarioJPA usuario, List<carritoCompraBean> lstCarrito) {
		
//		log.info("ini:  insertar compra");
//		
//		EntityManager manager = null;
//		int registrosAfectados = 0;
//		boolean exito = false;
//		
//		try {
//			
//			manager = JPAUtil.getEntityManager();
//			manager.getTransaction().begin(); 
//			
//			int compra_emitida = 1;
//			long idCompra;
//			
//			
//			if(registrosAfectados == 0) {
//				
//				throw new SQLException("compra no realizada!");
//			}
//			
//			try (ResultSet generatedKeys = manager.getGeneratedKeys()) {
//	            if (generatedKeys.next()) {
//	            	idCompra = generatedKeys.getLong(1);
//	            }else {
//	                throw new SQLException("Creacion de Boleta fallida, no tiene Id.");
//	            }
//			}
//		
//			log.debug("id boleta " + idCompra);
//			
//		} catch (Exception e) {
//			
//		}
//		
//		log.info("fin:  insertar compra");
		return false;
	}

}
