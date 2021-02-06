package proyectoServicio.demo.service.impl;

import java.util.List;

import proyectoServicio.demo.dao.LugarTuristicoDAO;
import proyectoServicio.demo.dao.impl.LugarTuristicoDAOImpl;
import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;
import proyectoServicio.demo.service.LugarTuristicoService;

public class LugarTuristicoServiceImpl implements LugarTuristicoService {

	private LugarTuristicoDAO lugarTuristicoDAO;
	
	public LugarTuristicoServiceImpl() {
		lugarTuristicoDAO = new LugarTuristicoDAOImpl();
	}
	
	@Override
	public LugarTuristicoJPA getLugarTuristicoById(int id) {
		
		return lugarTuristicoDAO.getLugarTuristicoById(id);
	}

	@Override
	public LugarTuristicoJPA getLugarTuristicoByNombre(String nombre) {
		
		return lugarTuristicoDAO.getLugarTuristicoByNombre(nombre);
	}

	@Override
	public List<LugarTuristicoJPA> listarLugaresTuristicos() {
		
		return lugarTuristicoDAO.listarLugaresTuristicos();
	}

	@Override
	public LugarTuristicoJPA obtenerLugaresTuristicosByid(int idLugarTuristico) {
		
		return lugarTuristicoDAO.obtenerLugaresTuristicosByid(idLugarTuristico);
	}

}
