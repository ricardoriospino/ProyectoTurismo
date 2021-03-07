package proyectoServicio.demo.dao;

import java.util.List;

import proyectoServicio.demo.Bean.carritoCompraBean;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public interface CompraDAO {
	
	public boolean insertarCompra (UsuarioJPA usuario, List<carritoCompraBean> lstCarrito);

}
