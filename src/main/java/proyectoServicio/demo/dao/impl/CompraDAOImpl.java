package proyectoServicio.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proyectoServicio.demo.bean.CarritoCompraBean;
import proyectoServicio.demo.cnx.JPAUtil;
import proyectoServicio.demo.dao.CompraDAO;
import proyectoServicio.demo.jpa.entity.CompraJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public class CompraDAOImpl implements CompraDAO {
	private static final Logger log= LogManager.getLogger(CompraDAOImpl.class);

	@Override
	public boolean insertarCompra(UsuarioJPA usuario, List<CarritoCompraBean> lstCarrito) {
		
		return false;
	}

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

}
