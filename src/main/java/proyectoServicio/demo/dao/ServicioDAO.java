package proyectoServicio.demo.dao;

import proyectoServicio.demo.jpa.entity.ServicioJPA;

public interface ServicioDAO {
	
	public ServicioJPA getServicioById (int id);
	
	public ServicioJPA getServicioByTipoServicio (String tipoServicio);

}
