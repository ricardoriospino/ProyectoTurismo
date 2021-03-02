package proyectoServicio.demo.Bean;

import java.io.Serializable;

public class ServicioBean implements Serializable {
	
	private int idServicio;
	
	private String nombreServicio;
	
	private String costo;

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}
	
	
	

}
