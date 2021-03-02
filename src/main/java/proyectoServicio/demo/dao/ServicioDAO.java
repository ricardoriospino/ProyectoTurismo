package proyectoServicio.demo.dao;

import java.util.List;
import java.util.Map;

import proyectoServicio.demo.jpa.entity.ServicioJPA;

public interface ServicioDAO {
	
	public ServicioJPA getServicioById (int id);
	
	public ServicioJPA getServicioByTipoServicio (String tipoServicio);
	
	public List<ServicioJPA> listarServiciosTour (int idTour);
	
	public List<Object[]> listarServiciosCostoByTour(int idTour);
	
	

}
