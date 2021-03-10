package proyectoServicio.demo.bean;

import java.io.Serializable;

public class ListaComprasBean implements Serializable {
	
	private String codigoTour;
	private String nombreTour;
	private String usuario;
	private String nombreUsuario;
	private String fechaSalida;
	private String subTotal;
	public String getCodigoTour() {
		return codigoTour;
	}
	public void setCodigoTour(String codigoTour) {
		this.codigoTour = codigoTour;
	}
	public String getNombreTour() {
		return nombreTour;
	}
	public void setNombreTour(String nombreTour) {
		this.nombreTour = nombreTour;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	
	

}
