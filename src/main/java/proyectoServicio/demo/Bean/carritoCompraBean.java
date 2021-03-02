package proyectoServicio.demo.Bean;

import java.io.Serializable;

public class carritoCompraBean implements Serializable {
	
	private int idDetalleCompra;
	private int idTour;
	private String nombreTour;
	private String imagenTour;
	private double precio;
	private int cantidad;
	private double subTotal;
	
	
	
	public carritoCompraBean () {
		
	}


	public carritoCompraBean(int idTour, int cantidad) {
		super();
		this.idTour = idTour;
		this.cantidad = cantidad;
	}



	public carritoCompraBean(int idDetalleCompra, int idTour, String nombreTour, String imagenTour, double precio,
			int cantidad, double subTotal) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.idTour = idTour;
		this.nombreTour = nombreTour;
		this.imagenTour = imagenTour;
		this.precio = precio;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
	}
	
	


	public carritoCompraBean(int idTour, String nombreTour, String imagenTour, double precio, int cantidad,
			double subTotal) {
		super();
		this.idTour = idTour;
		this.nombreTour = nombreTour;
		this.imagenTour = imagenTour;
		this.precio = precio;
		this.cantidad = cantidad;
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


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public String getImagenTour() {
		return imagenTour;
	}


	public void setImagenTour(String imagenTour) {
		this.imagenTour = imagenTour;
	}

	
	
}
