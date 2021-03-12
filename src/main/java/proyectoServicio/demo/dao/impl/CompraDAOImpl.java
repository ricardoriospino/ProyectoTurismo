package proyectoServicio.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.CompraDAO;


public class CompraDAOImpl implements CompraDAO {
	private static final Logger log= LogManager.getLogger(CompraDAOImpl.class);

	
	@Override
	public List<Object[]> listarCompra() {
		
		EntityManager manager = null;
		
		List<Object[]> lst = new ArrayList<Object[]>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String sql=("SELECT b.codigo_lugar_turistico , b.nombre , c.usuario , c.nombre_usuario , a.fecha_viaje , a.sub_total " + 
						"FROM tb_compra AS a INNER JOIN tb_lugar_turistico AS b " + 
						"ON a.id_lugar_turistico = b.id_lugar_turistico " + 
						"INNER JOIN tb_usuario AS c ON a.id_usuario = c.id_usuario");
			
			Query q = manager.createNativeQuery(sql);
			lst = (List<Object[]>) q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la listarCompra : " + e);
		}finally {
			manager.close();
		
		}
		
		return lst;
	}

	@Override
	public List<Object []> listarCompraById(String codigoTour) {
		
		EntityManager manager = null;
		
		List<Object[]> lst = new ArrayList<Object[]>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String sql=("SELECT b.codigo_lugar_turistico , b.nombre , c.usuario , c.nombre_usuario , a.fecha_viaje , a.sub_total " + 
						"FROM tb_compra AS a INNER JOIN tb_lugar_turistico AS b " + 
						"ON a.id_lugar_turistico = b.id_lugar_turistico " + 
						"INNER JOIN tb_usuario AS c ON a.id_usuario = c.id_usuario " +
						"WHERE b.codigo_lugar_turistico = :P_codigoTour ");
			
			Query q = manager.createNativeQuery(sql);
			q.setParameter("P_codigoTour",codigoTour );
			
			lst = (List<Object[]>) q.getResultList();
		
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la listarCompraById : " + e);
		}finally {
			manager.close();
		}	
		
		return lst;
	}

	@Override
	public List<Object[]> listarCompraByFechas(String fechaIni, String fechaFin) {
		
		EntityManager manager = null;
		List<Object[]> lst = new ArrayList<Object[]>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String sql=("SELECT b.codigo_lugar_turistico , b.nombre , c.usuario , c.nombre_usuario , a.fecha_viaje , a.sub_total " + 
						"FROM tb_compra AS a INNER JOIN tb_lugar_turistico AS b " + 
						"ON a.id_lugar_turistico = b.id_lugar_turistico " + 
						"INNER JOIN tb_usuario AS c ON a.id_usuario = c.id_usuario "+
						"WHERE a.fecha_viaje BETWEEN :P_fechaIni AND :P_fechaFin ");
			
			Query q = manager.createNativeQuery(sql);
			q.setParameter("P_fechaIni",fechaIni );
			q.setParameter("P_fechaFin",fechaFin );
			
			lst  = (List<Object[]>) q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la listarCompraByFechas : " + e);
			
		}finally {
			manager.close();
		}	
		
		return lst;
	}

	@Override
	public List<Object[]> listarCompraByFechasAndCodigoTour(String fechaIni, String fechaFin, String codigoTour) {
		
		EntityManager manager = null;
		List<Object[]> lst = new ArrayList<Object[]>();
		
		try {
			manager = JPAUtil.getEntityManager();
			String sql=("SELECT b.codigo_lugar_turistico , b.nombre , c.usuario , c.nombre_usuario , a.fecha_viaje , a.sub_total " + 
						"FROM tb_compra AS a INNER JOIN tb_lugar_turistico AS b " + 
						"ON a.id_lugar_turistico = b.id_lugar_turistico " + 
						"INNER JOIN tb_usuario AS c ON a.id_usuario = c.id_usuario "+
						"WHERE a.fecha_viaje BETWEEN :P_fechaIni AND :P_fechaFin "+
						"AND b.codigo_lugar_turistico = :P_codigoTour");
			
			Query q = manager.createNativeQuery(sql);
			q.setParameter("P_fechaIni",fechaIni );
			q.setParameter("P_fechaFin",fechaFin );
			q.setParameter("P_codigoTour",codigoTour );
			
			lst  = (List<Object[]>) q.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error al realizar la listarCompraByFechasAndCodigoTour : " + e);
			
		}finally {
			manager.close();
		}	
		
		return lst;
	}

}
