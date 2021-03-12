package proyectoServicio.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import proyectoServicio.demo.bean.ListaComprasBean;
import proyectoServicio.demo.dao.CompraDAO;
import proyectoServicio.demo.dao.impl.CompraDAOImpl;
import proyectoServicio.demo.service.CompraService;

public class CompraServiceImpl implements CompraService {

	private CompraDAO compraDAO;
	
	public CompraServiceImpl() {
		compraDAO = new CompraDAOImpl();
	}

	@Override
	public List<ListaComprasBean> listarCompra() {
		
		List<Object []> lista = compraDAO.listarCompra();
		List<ListaComprasBean> listaNueva = new ArrayList<ListaComprasBean>();
		
		for (int i = 0; i < lista.size(); i++) {
			ListaComprasBean listaCompras = new ListaComprasBean();
			
			listaCompras.setCodigoTour(""+lista.get(i)[0]);
			listaCompras.setNombreTour(""+lista.get(i)[1]);
			listaCompras.setUsuario(""+lista.get(i)[2]);
			listaCompras.setNombreUsuario(""+lista.get(i)[3]);
			listaCompras.setFechaSalida(""+lista.get(i)[4]);
			listaCompras.setSubTotal(""+lista.get(i)[5]);
			listaNueva.add(listaCompras);
			
		}	
		return listaNueva;
	}

	@Override
	public List<ListaComprasBean> listarCompraById(String codigoTour) {
		
		List<Object []>lista = compraDAO.listarCompraById(codigoTour);
		List<ListaComprasBean> listaNueva = new ArrayList<ListaComprasBean>();
		
		for (int i = 0; i < lista.size(); i++) {
			ListaComprasBean listaCompras = new ListaComprasBean();
			listaCompras.setCodigoTour(""+lista.get(i)[0]);
			listaCompras.setNombreTour(""+lista.get(i)[1]);
			listaCompras.setUsuario(""+lista.get(i)[2]);
			listaCompras.setNombreUsuario(""+lista.get(i)[3]);
			listaCompras.setFechaSalida(""+lista.get(i)[4]);
			listaCompras.setSubTotal(""+lista.get(i)[5]);
			listaNueva.add(listaCompras);
		}
		
		return listaNueva;
	}

	@Override
	public List<ListaComprasBean> listarCompraByFechas(String fechaIni, String fechaFin) {
		List<Object []>lista = compraDAO.listarCompraByFechas(fechaIni, fechaFin);
		List<ListaComprasBean> listaNueva = new ArrayList<ListaComprasBean>();
		
		for (int i = 0; i < lista.size(); i++) {
			ListaComprasBean listaCompras = new ListaComprasBean();
			listaCompras.setCodigoTour(""+lista.get(i)[0]);
			listaCompras.setNombreTour(""+lista.get(i)[1]);
			listaCompras.setUsuario(""+lista.get(i)[2]);
			listaCompras.setNombreUsuario(""+lista.get(i)[3]);
			listaCompras.setFechaSalida(""+lista.get(i)[4]);
			listaCompras.setSubTotal(""+lista.get(i)[5]);
			listaNueva.add(listaCompras);
		}
		
		return listaNueva;
		
	}

	@Override
	public List<ListaComprasBean> listarCompraByFechasAndCodigoTour(String fechaIni, String fechaFin,
			String codigoTour) {
		
		List<Object []>lista = compraDAO.listarCompraByFechasAndCodigoTour(fechaIni, fechaFin, codigoTour);
		List<ListaComprasBean> listaNueva = new ArrayList<ListaComprasBean>();
		
		for (int i = 0; i < lista.size(); i++) {
			ListaComprasBean listaCompras = new ListaComprasBean();
			listaCompras.setCodigoTour(""+lista.get(i)[0]);
			listaCompras.setNombreTour(""+lista.get(i)[1]);
			listaCompras.setUsuario(""+lista.get(i)[2]);
			listaCompras.setNombreUsuario(""+lista.get(i)[3]);
			listaCompras.setFechaSalida(""+lista.get(i)[4]);
			listaCompras.setSubTotal(""+lista.get(i)[5]);
			listaNueva.add(listaCompras);
		}
		
		return listaNueva;
	}
}
