package proyectoServicio.demo.dao;

import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;

public interface LugarTuristicoDAO {
	
	public LugarTuristicoJPA getLugarTuristicoById (int id);
	
	public LugarTuristicoJPA getLugarTuristicoByNombre (String nombre);

}
