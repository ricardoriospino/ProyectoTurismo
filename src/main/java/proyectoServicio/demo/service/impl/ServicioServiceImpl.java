package proyectoServicio.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import proyectoServicio.demo.bean.ServicioBean;
import proyectoServicio.demo.dao.ServicioDAO;
import proyectoServicio.demo.dao.impl.ServicioDAOImpl;
import proyectoServicio.demo.jpa.entity.ServicioJPA;
import proyectoServicio.demo.service.ServicioService;

public class ServicioServiceImpl implements ServicioService {

	private ServicioDAO servicioDAO;
	
	public ServicioServiceImpl() {
		
		servicioDAO = new ServicioDAOImpl();
	}
	@Override
	public ServicioJPA getServicioById(int id) {
		
		return servicioDAO.getServicioById(id);
	}
	@Override
	public ServicioJPA getServicioByTipoServicio(String tipoServicio) {
		
		return servicioDAO.getServicioByTipoServicio(tipoServicio);
	}
	@Override
	public List<ServicioJPA> listarServiciosTour(int idTour) {
		
		return servicioDAO.listarServiciosTour(idTour);
	}
	
	
	@Override
	public List<ServicioBean> listarServiciosCostoByTour(int idTour) {
		
		List<Object []> lista = servicioDAO.listarServiciosCostoByTour(idTour);
		List<ServicioBean> listaNueva = new ArrayList<ServicioBean>();
		
		for (int i = 0; i < lista.size(); i++) {
			ServicioBean servicio = new ServicioBean();

			servicio.setIdServicio(Integer.parseInt(""+lista.get(i)[0]));
			servicio.setNombreServicio("" + lista.get(i)[1]);
			servicio.setCosto((lista.get(i)[2]== null)?"":""+lista.get(i)[2]);
			listaNueva.add(servicio);
			
		}
		
		return  listaNueva;
	}

}
