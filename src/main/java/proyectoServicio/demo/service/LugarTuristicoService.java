package proyectoServicio.demo.service;

import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;

public interface LugarTuristicoService {
	
	public LugarTuristicoJPA getLugarTuristicoById (int id);
	
	public LugarTuristicoJPA getLugarTuristicoByNombre (String nombre);

}
