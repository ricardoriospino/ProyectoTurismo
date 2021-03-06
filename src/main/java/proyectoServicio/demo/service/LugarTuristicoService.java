package proyectoServicio.demo.service;

import java.util.Date;
import java.util.List;

import proyectoServicio.demo.jpa.entity.LugarTuristicoJPA;

public interface LugarTuristicoService {
	
	public LugarTuristicoJPA getLugarTuristicoById (int id);
	
	public LugarTuristicoJPA getLugarTuristicoByNombre (String nombre);
	
	public List<LugarTuristicoJPA> listarLugaresTuristicos ();
	
	public Long validarTourExist(String codigo);
	
	public int actualizarPrecioPaquete (int idTour, double costoNuevo);
	
	public int actualizarAuditoriaPaquete (int idTour, String modificadoPor , Date fechaModificada);
	

}
