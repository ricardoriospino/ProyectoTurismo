package proyectoServicio.demo.service;

import java.util.List;

import proyectoServicio.demo.jpa.entity.IncluyeJPA;

public interface IncluyeService {
	
	public List<IncluyeJPA> listaCostoServicios ();
	
	public int eliminarServicios (int idTour);

}
