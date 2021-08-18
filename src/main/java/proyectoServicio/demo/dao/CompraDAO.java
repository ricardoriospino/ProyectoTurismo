package proyectoServicio.demo.dao;

import java.util.List;


public interface CompraDAO {
	
	
	
	public List<Object[]> listarCompra();
	
	public List<Object[]> listarCompraById (String codigoTour);
	
	public List<Object[]> listarCompraByFechas (String fechaIni , String fechaFin);
	
	public List<Object[]> listarCompraByFechasAndCodigoTour (String fechaIni , String fechaFin , String codigoTour);

}
