package proyectoServicio.demo.bean;

import java.io.Serializable;

public class CarritoCompraBean implements Serializable {
	
	private int idDetalleCompra;
	private int idTour;
	private String nombreTour;
	private String imagenTour;
	private double precio;
	private int cantidad;
	private String fechaDeViaje;
	private double subTotal;
	
	
	
	public CarritoCompraBean () {
		
	}


	public CarritoCompraBean(int idTour, int cantidad) {
		super();
		this.idTour = idTour;
		this.cantidad = cantidad;
	}

	public CarritoCompraBean(int idDetalleCompra, int idTour, String nombreTour, String imagenTour, double precio,
			int cantidad, String fechaDeViaje, double subTotal) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.idTour = idTour;
		this.nombreTour = nombreTour;
		this.imagenTour = imagenTour;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechaDeViaje = fechaDeViaje;
		this.subTotal = subTotal;
	}




	public CarritoCompraBean(int idTour, String nombreTour, String imagenTour, double precio, int cantidad,
			String fechaDeViaje, double subTotal) {
		super();
		this.idTour = idTour;
		this.nombreTour = nombreTour;
		this.imagenTour = imagenTour;
		this.precio = precio;
		this.cantidad = cantidad;
		this.fechaDeViaje = fechaDeViaje;
		this.subTotal = subTotal;
	}


	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}


	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}


	public int getIdTour() {
		return idTour;
	}


	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}


	public String getNombreTour() {
		return nombreTour;
	}


	public void setNombreTour(String nombreTour) {
		this.nombreTour = nombreTour;
	}


	public String getImagenTour() {
		return imagenTour;
	}


	public void setImagenTour(String imagenTour) {
		this.imagenTour = imagenTour;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getFechaDeViaje() {
		return fechaDeViaje;
	}


	public void setFechaDeViaje(String fechaDeViaje) {
		this.fechaDeViaje = fechaDeViaje;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	
	
}
