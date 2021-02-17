package proyectoServicio.demo.service;

import java.util.List;

import proyectoServicio.demo.jpa.entity.ServicioJPA;

public interface ServicioService {

	public ServicioJPA getServicioById (int id);
	
	public ServicioJPA getServicioByTipoServicio (String tipoServicio);
	
	public List<ServicioJPA> listarServiciosTour (int idTour);
	
	public List<ServicioJPA> listarServicios ();
}
