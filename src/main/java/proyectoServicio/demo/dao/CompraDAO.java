package proyectoServicio.demo.dao;

import java.util.List;

import proyectoServicio.demo.bean.CarritoCompraBean;
import proyectoServicio.demo.bean.ListaComprasBean;
import proyectoServicio.demo.jpa.entity.CompraJPA;
import proyectoServicio.demo.jpa.entity.UsuarioJPA;

public interface CompraDAO {
	
	
	
	public List<Object[]> listarCompra();
	
	public List<Object[]> listarCompraById (String codigoTour);
	
	public List<Object[]> listarCompraByFechas (String fechaIni , String fechaFin);
	
	public List<Object[]> listarCompraByFechasAndCodigoTour (String fechaIni , String fechaFin , String codigoTour);

}
