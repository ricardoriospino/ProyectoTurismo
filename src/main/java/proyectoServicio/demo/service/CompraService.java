package proyectoServicio.demo.service;

import java.util.List;

import proyectoServicio.demo.bean.ListaComprasBean;

public interface CompraService {

	public List<ListaComprasBean> listarCompra();
	
	public List<ListaComprasBean> listarCompraById (String codigoTour);
	
	public List<ListaComprasBean> listarCompraByFechas (String fechaIni , String fechaFin);
	
	public List<ListaComprasBean> listarCompraByFechasAndCodigoTour (String fechaIni , String fechaFin , String codigoTour);
}
