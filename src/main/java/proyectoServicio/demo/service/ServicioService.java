package proyectoServicio.demo.service;

import proyectoServicio.demo.jpa.entity.ServicioJPA;

public interface ServicioService {

	public ServicioJPA getServicioById (int id);
	
	public ServicioJPA getServicioByTipoServicio (String tipoServicio);
}
