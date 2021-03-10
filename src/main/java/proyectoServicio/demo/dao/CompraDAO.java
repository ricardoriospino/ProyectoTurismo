package proyectoServicio.demo.dao;

import java.util.List;

import proyectoServicio.demo.bean.CarritoCompraBean;
import proyectoServicio.demo.jpa.entity.CompraJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public interface CompraDAO {
	
	public boolean insertarCompra (UsuarioJPA usuario, List<CarritoCompraBean> lstCarrito);
	
	public List<Object[]> listarCompra();

}
